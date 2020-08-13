package org.example.web;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RegisterController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/register")
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("register");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}

	@PostMapping(value = "/registerProcess")
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
								@ModelAttribute("user") User user) {
		userService.register(user);
		return new ModelAndView("welcome", "firstname", user.getFirstname());
	}

}
