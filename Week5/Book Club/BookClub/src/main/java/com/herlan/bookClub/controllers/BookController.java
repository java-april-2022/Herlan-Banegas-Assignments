package com.herlan.bookClub.controllers;

import javax.servlet.http.HttpSession;
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

import com.herlan.bookClub.models.Book;
import com.herlan.bookClub.services.BookService;
import com.herlan.bookClub.services.UserService;

@Controller
public class BookController {
	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;

	@GetMapping("/book/new")
	public String newBook(Model model, HttpSession session, @ModelAttribute("newBook") Book book) {
		if(session.getAttribute("userId")==null) {
		return "dashboard.jsp";
		}
		else {
		model.addAttribute("loggedInUser", userService.findById((Long) session.getAttribute("userId")));
		return "new.jsp";
	}
}
	@PostMapping("/book/create")
	public String createBook(@Valid @ModelAttribute("newBook") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return"new.jsp";
		}
		else {
			bookService.createBook(book);
			return "redirect:/dashboard";
		}
	}
	@GetMapping("/book/details/{id}")
	public String viewBook(@PathVariable Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId")!= null) {
		Book book= bookService.getOneBook(id);
		model.addAttribute("book", book);
		return "view.jsp";
	}
		else {
			return "redirect:/";
		}
	}
	@GetMapping("/book/edit/{id}")
	public String editBook(@PathVariable Long id, HttpSession session, @ModelAttribute("editBook") Book book, Model model) {
		if(session.getAttribute("userId")!= null) {
		return "dashboard.jsp";
		}
		else {
			Book editBook = bookService.getOneBook(id);
			model.addAttribute("editBook", editBook);
		return "edit.jsp";
		}
	}
	@PutMapping("/book/update/{id}")
	public String updateBook(@PathVariable Long id, @Valid @ModelAttribute("editBook") Book book, HttpSession session) {
		if(session.getAttribute("userId")!= null) {
			return "dashboard.jsp";
		}
		else {
		bookService.updateBook(book);
		return "redirect:/dashboard";
	}
	
//	@GetMapping("/logout")
//	public String logout(HttpSession session) {
//		
//		session.invalidate();
//		return "redirect:/";
//	}
	}
}
