package com.example.demo.solution.domain.criteria;

import java.util.List;

import com.example.demo.solution.domain.task.Priority;
import com.example.demo.solution.domain.task.Task;

public class FilteredByPriority implements Criteria<Task> {

    private Priority filteredBy;

    public FilteredByPriority(Priority priority) {
        this.filteredBy = priority;
    }

    @Override
    public List<Task> meetCriteria(List<Task> items) {

        return items.stream().filter(
        item -> item.getPriority() == this.filteredBy)
                .collect(java.util.stream.Collectors
                .toList()
       );
    }

}