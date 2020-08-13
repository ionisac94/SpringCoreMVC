package org.example.web;

import org.example.model.Login;
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
public class LoginController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/login")
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("login", new Login());
		return modelAndView;
	}

	@PostMapping(value = "/loginProcess")
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
									 @ModelAttribute("login") Login login) {
		ModelAndView modelAndView = null;
		User user = userService.validateUser(login);
		if (null != user) {
			modelAndView = new ModelAndView("welcome");
			modelAndView.addObject("firstname", user.getFirstname());
		} else {
			modelAndView = new ModelAndView("login");
			modelAndView.addObject("message", "Username or Password is wrong!!");
		}
		return modelAndView;
	}
}
