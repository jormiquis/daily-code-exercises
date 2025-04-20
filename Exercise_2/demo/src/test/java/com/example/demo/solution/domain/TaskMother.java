package com.example.demo.solution.domain;

import com.example.demo.solution.domain.task.Task;
import com.example.demo.solution.domain.task.Priority;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

public class TaskMother {

    public static Task createDefaultTask() {
        return new Task(
            UUID.randomUUID(),
            "Default Task",
            "Default Description",
            new Date(System.currentTimeMillis() + 5 * 60 * 60 * 1000),
            Priority.MEDIUM,
            new ArrayList<>(Arrays.asList(UUID.randomUUID(), UUID.randomUUID())),
            UUID.randomUUID()
        );
    }

    public static Task createUrgentTask() {
        return new Task(
            UUID.randomUUID(),
            "Default Task",
            "Default Description",
            new Date(System.currentTimeMillis() + 5 * 60 * 60 * 1000),
            Priority.HIGH,
            new ArrayList<>(Arrays.asList(UUID.randomUUID(), UUID.randomUUID())),
            UUID.randomUUID()
        );
    }
}