package com.sportyshoes.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.stereotype.Repository;

import com.sportyshoes.model.AdminModel;

@Repository
public class AdminDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	@SuppressWarnings("deprecation")
	public List<AdminModel>getAdmin(String email){
		String sql ="select * from admin where email=?";
		return jdbcTemplate.query(sql,new Object[]{email} , new RowMapper<AdminModel>() {
			@Override
			public AdminModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				AdminModel adminModel = new AdminModel();
				adminModel.setEmail(rs.getString(1));
				adminModel.setPassword(rs.getString(2));
				return adminModel;
			}
		});		
	}
}
