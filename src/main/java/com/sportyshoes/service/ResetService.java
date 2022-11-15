package com.sportyshoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sportyshoes.dao.ResetDAO;
import com.sportyshoes.model.ResetModel;

@Service
public class ResetService {
	
 	@Autowired
	ResetDAO resetDAO;
	
	public List<ResetModel> getUserDetails(ResetModel resetModel) {	
		return resetDAO.getUserDetails(resetModel);
	}

	public int updatePassword(ResetModel resetModel) {
		// TODO Auto-generated method stub
		return resetDAO.updatePassword(resetModel);
	}
}
