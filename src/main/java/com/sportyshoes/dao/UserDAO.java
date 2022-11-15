package com.sportyshoes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sportyshoes.model.UserModel;

@Repository
public class UserDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//get user
	public List<UserModel> getUsers(){
		String sql = "Select * from users";
		return jdbcTemplate.query(sql, new RowMapper<UserModel>() {

			@Override
			public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserModel userModel = new UserModel();
				userModel.setId(rs.getInt(1));
				userModel.setFullName(rs.getString(2));
				userModel.setPhoneNumber(rs.getString(3));
				userModel.setEmailId(rs.getString(4));
				userModel.setAddress(rs.getString(5));
				return userModel;
			}
			
		});
		
	}

	public int deleteUser(UserModel userModel) {
		// TODO Auto-generated method stub
		String sql ="Delete from users where _id=?";
		return jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, userModel.getId());
				return ps;
			}
			
		});
		
	}
}
