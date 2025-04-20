package com.example.demo.solution.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.solution.domain.task.Task;
import com.example.demo.solution.domain.task.TaskStatus;


import static org.junit.jupiter.api.Assertions.*;


public class TaskTest {

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

}
