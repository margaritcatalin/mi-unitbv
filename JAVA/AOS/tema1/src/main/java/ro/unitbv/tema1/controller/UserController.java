package ro.unitbv.tema1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ro.unitbv.tema1.entities.User;
import ro.unitbv.tema1.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public String listUsers(Model theModel) {
		List<User> theUsers = userService.getUsers();
		theModel.addAttribute("users", theUsers);
		return "list-users";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		User theUser = new User();
		theModel.addAttribute("user", theUser);
		return "user-form";
	}

	@PostMapping("/saveUser")
	public String saveUser(@Valid @ModelAttribute("user") User theUser, BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return "user-form";
		} else {
			userService.saveUser(theUser);
			return "redirect:/user/list";
		}
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("userId") int theId, Model theModel) {
		User theUser = userService.getUser(theId);
		theModel.addAttribute("user", theUser);
		return "user-form";
	}

	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId") int theId) {
		userService.deleteUser(theId);

		return "redirect:/user/list";
	}

}
