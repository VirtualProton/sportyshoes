package com.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sportyshoes.model.AdminModel;
import com.sportyshoes.service.AdminService;

@Controller
public class LoginController
{
	@Autowired
	AdminService adminService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("*")
	public String login1() {
		return "login";
	} 
	
	@GetMapping("/verifyuser")
	public String dashboard(@RequestParam(name="email",required=true)String email,@RequestParam(name="password",required=true)String password, Model model) {
		List<AdminModel> adminModel = adminService.getCredential(email);
//		System.out.println(adminModel.get(0).email);
//		System.out.println(adminModel.get(0).password);
		if(adminModel.isEmpty()) {
			model.addAttribute("err_msg","Incorrect User ID");
			return "login";
		}else {
			if(!password.equals(adminModel.get(0).password)) {
				model.addAttribute("err_msg","Incorrect Password");
				return "login";
			}else {
				return "dashboard";
			}

		}
	}
	
}

