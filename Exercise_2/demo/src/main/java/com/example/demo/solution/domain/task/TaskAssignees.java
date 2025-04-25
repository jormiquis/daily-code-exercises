package com.example.demo.solution.domain.task;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class TaskAssignees {

    private List<UUID> asignees;
    private UUID primaryAsignee;

    public TaskAssignees() {}

    public TaskAssignees(List<UUID> asignees, UUID primaryAsignee ) {

    if (primaryAsignee != null && !this.asignees.contains(primaryAsignee)) {
            throw new IllegalArgumentException("Primary assignee must be in the list of assignees");
    }

        this.asignees = asignees;
        this.primaryAsignee = primaryAsignee;
    }

    public UUID getPrimaryAsignee() {
        return primaryAsignee;
    }

    public void changePrimaryAssignee(UUID assignee) {
        this.primaryAsignee = assignee;
    }

    public List<UUID> getAssignees() {
        return Collections.unmodifiableList(this.asignees);
    }

    public void addAssignee(UUID assignee) {
        if(this.asignees.contains(assignee)) {
            throw new IllegalArgumentException("This asignee is already linked to this task");
        }
        this.asignees.add(assignee);
    }

    //rest of methods
}
