package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller

public class UserController {
	@Autowired
	private UserService userService;

	//----------------------------------------------------------------------------------------
	@GetMapping("/users")
	public String allUser(ModelMap model) {
		model.addAttribute("user", userService.getAllUser());
		return "users";
	}
	//----------------------------------------------------------------------------------------
	@GetMapping("/new_user")
	public String newUser(ModelMap model) {
		model.addAttribute("user", new User());
		return "new_users";
	}

	@PostMapping("/users")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.add(user);
		return "redirect:/users";
	}
	//------------------------------------------------------------------------------------------
	@GetMapping("/{id}/edit")
	public String editUser (ModelMap model, @PathVariable("id") Long id) {
		model.addAttribute("user", userService.getUser(id));
		return "/edit_users";
	}

	@PatchMapping("/{id}")
	public String update(@ModelAttribute ("user") User user, @PathVariable("id") Long id) {
		userService.update(id, user);
		return "redirect:/users";
	}
	@DeleteMapping("/{id}")
	public String  deleteUser(@PathVariable("id") Long id) {
		userService.delete(id);
		return "redirect:/users";
	}

}