package com.sportyshoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.dao.PurchasedDAO;
import com.sportyshoes.model.PurchasedModel;

@Service
public class PurchasedService {
	@Autowired
	PurchasedDAO purchasedDAO;
	
	public List<PurchasedModel> getreport() {
		// TODO Auto-generated method stub
		
		return purchasedDAO.getreport();
	}

	public List<PurchasedModel> getfilteredreport(String filter) {
		// TODO Auto-generated method stub
		return purchasedDAO.getfilteredreport(filter);
	}

	public List<PurchasedModel> getfilteredreportbydate(String date) {
		// TODO Auto-generated method stub
		return purchasedDAO.getfilteredreportbydate(date);
	}


}
