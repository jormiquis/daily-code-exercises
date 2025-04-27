package com.example.demo.solution.infrastructure;

import com.example.demo.solution.domain.task.TaskRepository;
import com.example.demo.solution.domain.criteria.Criteria;
import com.example.demo.solution.domain.task.Priority;
import com.example.demo.solution.domain.task.Task;
import com.example.demo.solution.domain.task.TaskAssignees;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class TaskInMemoryRepository implements TaskRepository {

    private List<Task> tasks;

    public TaskInMemoryRepository() {
        this.tasks = new ArrayList<>();

        this.tasks.add(new Task(
            UUID.fromString("9d6ef5e2-fca1-4ec4-a5db-a2786fc7e0e4"),
            "Complete Documentation",
            "Write the documentation for the project.",
            new Date(System.currentTimeMillis() + 3 * 24 * 60 * 60 * 1000),
            Priority.MEDIUM,
            new TaskAssignees(
                Arrays.asList(UUID.fromString("9d6ef5e2-fca1-4ec4-a5db-a2786fc7e0e4"), UUID.randomUUID()),
                UUID.fromString("9d6ef5e2-fca1-4ec4-a5db-a2786fc7e0e4")
            )
        ));
        this.tasks.add(new Task(
            UUID.fromString("9d6ef5e2-fca1-4ec4-a5db-a2786fc7e0e5"),
            "Fix Critical Bug",
            "Resolve the critical bug in the payment module.",
            new Date(System.currentTimeMillis() + 1 * 24 * 60 * 60 * 1000),
            Priority.HIGH,
            new TaskAssignees(
                Arrays.asList(UUID.fromString("9d6ef5e2-fca1-4ec4-a5db-a2786fc7e0e5"), UUID.randomUUID()),
                UUID.fromString("9d6ef5e2-fca1-4ec4-a5db-a2786fc7e0e5")
            )
        ));
        this.tasks.add(new Task(
            UUID.fromString("9d6ef5e2-fca1-4ec4-a5db-a2786fc7e0e6"),
            "Code Review",
            "Review the code for the new feature implementation.",
            new Date(System.currentTimeMillis() + 5 * 24 * 60 * 60 * 1000),
            Priority.LOW,
            new TaskAssignees(
                Arrays.asList(UUID.fromString("9d6ef5e2-fca1-4ec4-a5db-a2786fc7e0e6"), UUID.randomUUID()),
                UUID.fromString("9d6ef5e2-fca1-4ec4-a5db-a2786fc7e0e6")
            )
        ));
    }

    @Override
    public List<Task> getAllTasks() {
        return tasks;
    }

    @Override
    public List<Task> getTasksByCriteria(Criteria<Task> criteria) {
        return criteria.meetCriteria(tasks);
    }

}
