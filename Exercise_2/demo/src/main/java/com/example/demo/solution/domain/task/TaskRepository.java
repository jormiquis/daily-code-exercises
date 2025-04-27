package com.example.demo.solution.domain.task;

import java.util.List;

import com.example.demo.solution.domain.criteria.Criteria;

public interface TaskRepository {

    List<Task> getAllTasks();

    List<Task> getTasksByCriteria(Criteria<Task> criteria);

}
