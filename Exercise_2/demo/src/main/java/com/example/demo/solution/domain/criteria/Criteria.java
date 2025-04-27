package com.example.demo.solution.domain.criteria;

import java.util.List;

public interface Criteria <T>{
	 public List<T> meetCriteria(List<T> items);
}
