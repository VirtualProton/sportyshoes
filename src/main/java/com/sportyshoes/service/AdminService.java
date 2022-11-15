package com.sportyshoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.dao.AdminDAO;
import com.sportyshoes.model.AdminModel;
@Service
public class AdminService {
	@Autowired
	AdminDAO adminDAO;
	
	public List<AdminModel> getCredential(String email){
		return adminDAO.getAdmin(email);
		
	}
}
