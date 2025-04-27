package com.example.demo.solution.domain.task;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public record TaskAssignees(List<UUID> assignees, UUID primaryAssignee) {

    public TaskAssignees {
        if (primaryAssignee != null && !assignees.contains(primaryAssignee)) {
            throw new IllegalArgumentException("Primary assignee must be in the list of assignees");
        }
    }

    public List<UUID> getAssignees() {
        return Collections.unmodifiableList(assignees);
    }

    public TaskAssignees addAssignee(UUID assignee) {
        if (assignees.contains(assignee)) {
            throw new IllegalArgumentException("This assignee is already linked to this task");
        }
        List<UUID> updatedAssignees = new java.util.ArrayList<>(assignees);
        updatedAssignees.add(assignee);
        return new TaskAssignees(updatedAssignees, primaryAssignee);
    }

    public TaskAssignees changePrimaryAssignee(UUID assignee) {
        if (!assignees.contains(assignee)) {
            throw new IllegalArgumentException("Primary assignee must be in the list of assignees");
        }
        return new TaskAssignees(assignees, assignee);
    }

    public UUID getPrimaryAssignee() {
        return primaryAssignee;
    }
}
