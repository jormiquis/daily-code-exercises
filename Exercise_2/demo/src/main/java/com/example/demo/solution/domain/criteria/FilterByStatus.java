package com.example.demo.solution.domain.criteria;

import java.util.List;

import com.example.demo.solution.domain.task.Task;
import com.example.demo.solution.domain.task.TaskStatus;

public class FilterByStatus implements Criteria<Task> {

    private final TaskStatus filteredBy;

    public FilterByStatus(TaskStatus status) {
        this.filteredBy = status;
    }

    @Override
    public List<Task> meetCriteria(List<Task> items) {

       return items.stream().filter(
        item -> item.getStatus() == this.filteredBy)
                .collect(java.util.stream.Collectors
                .toList()
       );
    }



}
