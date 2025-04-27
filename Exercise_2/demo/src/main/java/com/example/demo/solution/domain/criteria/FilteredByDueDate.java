package com.example.demo.solution.domain.criteria;

import java.util.Date;
import java.util.List;

import com.example.demo.solution.domain.task.Task;

public class FilteredByDueDate implements Criteria<Task> {

    private Date dueDate;

    public FilteredByDueDate(Date filteredBy) {
        this.dueDate = filteredBy;
    }

    @Override
    public List<Task> meetCriteria(List<Task> items) {

        return items.stream().filter(
            item -> item.getDueDate().before(this.dueDate))
                    .collect(java.util.stream.Collectors
                    .toList()
           );
    }

}
