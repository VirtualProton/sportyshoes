package com.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.sportyshoes.model.ResetModel;
import com.sportyshoes.service.ResetService;

@Controller
public class ResetController {
	
	@Autowired
	ResetService resetService;
	
	@GetMapping("/resetform")
	public String resetForm(Model model) {
		ResetModel rm = new ResetModel();
		model.addAttribute("resetModel", rm);
		return "resetform";
	}
	
	@PostMapping("/resetpassword")
	public String resetPassword(@ModelAttribute("resetModel") ResetModel resetModel, Model model) {
		List<ResetModel> dataModel = resetService.getUserDetails(resetModel);
		if(dataModel.isEmpty()) {
			model.addAttribute("err_msg","Incorrect User ID");
			return "resetform";
		}else {
			System.out.println(dataModel.get(0).getOldPassword());
			if(!resetModel.getOldPassword().equals(dataModel.get(0).getOldPassword())) {
				model.addAttribute("err_msg","Incorrect Old Password");
				return "resetform";
			}else {
				if(! resetModel.getNewPassword().equals(resetModel.getRePassword())) {
					model.addAttribute("err_msg","New Password and Re-Password doesn't match");
					return "resetform";
				}else {
					resetService.updatePassword(resetModel);
					model.addAttribute("success","Password updated Successfully");
					return "login";
				}
			}
		}
	}
}
