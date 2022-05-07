package com.week4.saveTravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.week4.saveTravels.models.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {
	List<Expense>findAll();
	

}
