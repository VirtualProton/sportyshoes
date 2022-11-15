package com.sportyshoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.dao.UserDAO;
import com.sportyshoes.model.UserModel;

@Service
public class UserService {
	@Autowired
	UserDAO userDAO;
	
	//getuser
	public List<UserModel> getusers(){
		return userDAO.getUsers();
	}

	//delete
	public int deleteuser(UserModel userModel) {
		// TODO Auto-generated method stub
		 return userDAO.deleteUser(userModel);
	}
}
