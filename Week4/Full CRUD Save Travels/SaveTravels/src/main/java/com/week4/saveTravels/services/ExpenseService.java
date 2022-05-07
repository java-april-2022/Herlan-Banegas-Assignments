package com.week4.saveTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.week4.saveTravels.models.Expense;
import com.week4.saveTravels.repositories.ExpenseRepository;


@Service
public class ExpenseService {
	@Autowired
	private ExpenseRepository expenseRepository;

	public List<Expense> getAllExpenses() {
		return expenseRepository.findAll();
	}

	public List<Expense> allExpenses() {
		return expenseRepository.findAll();
	}

	// creates an expense
	public Expense createExpense(Expense e) {
		return expenseRepository.save(e);
	}

	// retrieves an expense
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if (optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}

	// updates the expense
	public Expense updateExpense(Expense e) {
		return expenseRepository.save(e);
	}

	// Get Expense Details
	public Expense expenseDetails(Long id) {
		return expenseRepository.findById(id).orElse(null);
	}

	// must pass in ID to delete art by id
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
	}

}
