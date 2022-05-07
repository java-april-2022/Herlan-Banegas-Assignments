package com.week4.saveTravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.week4.saveTravels.models.Expense;
import com.week4.saveTravels.services.ExpenseService;

@Controller
public class travelController {

	@Autowired
	private ExpenseService expenseService;

	@GetMapping("/")
	public String index() {
		return "redirect:/expenses";
	}

	@GetMapping("/expenses")
	public String topIndex(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> expenses = expenseService.getAllExpenses();
		model.addAttribute("allExpenses", expenses);
		return "index.jsp";
	}
	
	@GetMapping("/expenses/show/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.expenseDetails(id);
		model.addAttribute("expense", expense);
		return "details.jsp";
	}

	@PostMapping("/expenses")
	public String createIndex(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Expense> expenses = expenseService.getAllExpenses();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		} else {
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
	}

	// Update Art (get/put)
	@GetMapping("/edit/{id}")
	public String editExpense(@PathVariable Long id, Model model) {
		Expense editExpense = expenseService.expenseDetails(id);
		model.addAttribute("editExpense", editExpense);
		return "edit.jsp";
	}

	// UPDATE METHOD IS STILL MISSING VALIDATIONS:
	@PutMapping("/update/{id}")
	public String updateExpense(@Valid @ModelAttribute("editExpense") Expense editedExpense, BindingResult result,
			@PathVariable Long id) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {

			expenseService.updateExpense(editedExpense);
			return "redirect:/expenses";
		}

	}
}
