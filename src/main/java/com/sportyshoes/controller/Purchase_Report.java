package com.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sportyshoes.model.PurchasedModel;
import com.sportyshoes.service.PurchasedService;

@Controller
public class Purchase_Report {
	@Autowired
	PurchasedService purchasedService;
	
	@GetMapping("/report")
	public String purchaseReport(Model model) {
		List<PurchasedModel> purchsedModel = purchasedService.getreport();
		model.addAttribute("reports",purchsedModel);
		return "purchasereport";
	}
	@GetMapping("/report/filter")
	public String filterByCategory(@RequestParam(name="filter",required=true)String filter,Model model) {
		List<PurchasedModel> purchsedModel = purchasedService.getfilteredreport(filter);
		model.addAttribute("reports",purchsedModel);
		return "purchasereport";
	}
	@GetMapping("/report/date")
	public String filterByDate(@RequestParam(name="date",required=true)String date,Model model) {
		List<PurchasedModel> purchsedModel = purchasedService.getfilteredreportbydate(date);
		model.addAttribute("reports",purchsedModel);
		return "purchasereport";
	}
}
