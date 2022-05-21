package com.herlan.bookClub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.herlan.bookClub.models.User;
import com.herlan.bookClub.services.BookService;
import com.herlan.bookClub.services.UserService;
import com.herlan.bookClub.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;
	@Autowired
	private UserValidator userValidator;

	@GetMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "index.jsp";
	}

	// Register User
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult results, HttpSession session) {
		userValidator.validate(user, results);

		if (results.hasErrors()) {
			return "index.jsp";
		} else {
			User newUser = userService.register(user);
			session.setAttribute("userId", newUser.getId());
			return "redirect:/dashboard";
		}
	}

	@PostMapping("/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
			HttpSession session, RedirectAttributes redirectAttributes) {
		if (userService.authenticateUser(email, password)) {
			User user = userService.findByEmail(email);
			session.setAttribute("userId", user.getId());
			return "redirect:/dashboard";
		} else {
			redirectAttributes.addFlashAttribute("error", "Invalid user/pass");
			return "redirect:/";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			User user = userService.findById((Long) session.getAttribute("userId"));
			model.addAttribute("user", user);
			model.addAttribute("books", bookService.allBooks());
			return "dashboard.jsp";
		} else {
			return "redirect:/";
		}

	}

}
