package com.example.demo.solution.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.solution.domain.criteria.Criteria;
import com.example.demo.solution.domain.criteria.FilterByStatus;
import com.example.demo.solution.domain.criteria.FilteredByDueDate;
import com.example.demo.solution.domain.criteria.FilteredByPriority;
import com.example.demo.solution.domain.task.Priority;
import com.example.demo.solution.domain.task.Task;
import com.example.demo.solution.domain.task.TaskRepository;
import com.example.demo.solution.domain.task.TaskStatus;
import com.example.demo.solution.infrastructure.TaskInMemoryRepository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;


public class TaskTest {

    TaskRepository repository = new TaskInMemoryRepository();

    @Test
    @DisplayName("A new task should have TODO status by default")
    void testTODOStatusByDefault() {
        Task testTask = TaskMother.createDefaultTask();

        assertEquals(testTask.getStatus(),TaskStatus.TO_DO);
    }

    @Test
    @DisplayName("A new task should not have IN_PROGRESS status by default")
    void testInProgressStatusByDefault() {
        Task testTask = TaskMother.createDefaultTask();

        assertNotEquals(testTask.getStatus(),TaskStatus.IN_PROGRESS);
    }

    @Test
    @DisplayName("A task with TODO status should change to IN_PROGRESS and DONE")
    void testTransitionningFromToDoStatus() {
        Task testTask = TaskMother.createDefaultTask();

        testTask.changeTaskStatus();
        assertEquals(testTask.getStatus(), TaskStatus.IN_PROGRESS);
        assertEquals(testTask.getCompletionDate(), null);

        testTask.changeTaskStatus();
        assertEquals(testTask.getStatus(), TaskStatus.DONE);
        assertNotNull(testTask.getCompletionDate());
    }

    @Test
    @DisplayName("A task should be considered as Urgent")
    void testTaskShoulBeConsideredAsUrgent() {
        Task testTask = TaskMother.createUrgentTask();

        assertEquals(testTask.isUrgent(), true);

    }

    @Test
    @DisplayName("A task should not be considered as Urgent")
    void testTaskShoulNotBeConsideredAsUrgent() {
        Task testTask = TaskMother.createDefaultTask();

        assertEquals(testTask.isUrgent(), false);

    }

    @Test
    @DisplayName("Applying criteria should filter tasks by itself")
    void testApplyingCriteriaShouldFilterTasks() {

        Criteria<Task> byStatus = new FilterByStatus(TaskStatus.IN_PROGRESS);

        assertTrue(repository.getTasksByCriteria(byStatus).stream().allMatch(task -> task.getStatus() == TaskStatus.IN_PROGRESS));

        Criteria<Task> byPriority = new FilteredByPriority(Priority.LOW);

        assertTrue(repository.getTasksByCriteria(byPriority).stream().allMatch(task -> task.getPriority() == Priority.LOW));


        Date dueDate = new Date(System.currentTimeMillis() + 5 * 24 * 60 * 60 * 1000);

        Criteria<Task> byDueDate = new FilteredByDueDate(dueDate);

        assertTrue(repository.getTasksByCriteria(byDueDate).stream().allMatch(task -> task.getDueDate().before(dueDate)));

    }

}
