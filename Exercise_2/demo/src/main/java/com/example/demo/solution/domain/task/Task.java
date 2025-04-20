package com.example.demo.solution.domain.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Task {
    private UUID id;
    private String title;
    private String  description;
    private Date dueDate;
    private Priority priority;
    private TaskStatus status;
    private List<UUID> asignees;
    private UUID primaryAssignee;
    private LocalDate completionDate;

    public Task() {
    }

    public Task(
        UUID id,
        String title,
        String description,
        Date dueDate,
        Priority priority,
        List<UUID> asignees,
        UUID primaryAssignee
        ) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.dueDate = dueDate;
            this.priority = priority;
            this.status = TaskStatus.TO_DO;
            this.asignees = asignees;
            this.primaryAssignee = primaryAssignee;
            this.completionDate = null;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public List<UUID> getAsignees() {
        return asignees;
    }

    public UUID getPrimaryAssignee() {
        return primaryAssignee;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public boolean isUrgent() {
        long now = new Date().getTime();
        long in24h = now + 24 * 60 * 60 * 1000;
        return priority == Priority.HIGH && dueDate.getTime() <= in24h;
    }

public TaskStatus changeTaskStatus() {
    if (this.status == null) {
        throw new IllegalStateException("Task status cannot be null");
    }

    this.status = switch (this.status) {
        case TO_DO -> TaskStatus.IN_PROGRESS;
        case IN_PROGRESS -> this.assignCompletionDate();
        case DONE -> throw new IllegalStateException("Cannot change status of a completed task");
    };

    return this.status;
}

private TaskStatus assignCompletionDate() {
    this.completionDate = LocalDate.now();
    return TaskStatus.DONE;
}

       @Override
    public int hashCode() {
        return Objects.hash(
            id,
            title,
            description,
            dueDate,
            priority,
            status,
            asignees,
            primaryAssignee,
            completionDate
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Task other)) return false;

        return Objects.equals(id, other.id) &&
               Objects.equals(title, other.title) &&
               Objects.equals(description, other.description) &&
               Objects.equals(dueDate, other.dueDate) &&
               Objects.equals(priority, other.priority) &&
               status == other.status &&
               Objects.equals(asignees, other.asignees) &&
               Objects.equals(primaryAssignee, other.primaryAssignee) &&
               Objects.equals(completionDate, other.completionDate);
    }


}
