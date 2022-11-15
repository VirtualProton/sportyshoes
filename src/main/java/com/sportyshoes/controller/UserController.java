package com.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sportyshoes.model.UserModel;
import com.sportyshoes.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public String usersList(Model model) {
		List<UserModel> userModel = userService.getusers();
		model.addAttribute("users", userModel);
		return "userslist";
	}
	
	@GetMapping("/userdelete")
	public String deleteUser(@RequestParam(name="id",required=true)int id) {
		UserModel userModel = new UserModel();
		userModel.setId(id);
		userService.deleteuser(userModel);
		return "redirect:/users";
	}
}
