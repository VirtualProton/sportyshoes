package com.sportyshoes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sportyshoes.model.ResetModel;
@Repository
public class ResetDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	public List<ResetModel> getUserDetails(ResetModel resetModel) {
		String sql ="select * from admin where email=?";
		return jdbcTemplate.query(sql,new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, resetModel.getEmail());
			}
			
		}, new RowMapper<ResetModel>() {
			@Override
			public ResetModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				ResetModel resetModel = new ResetModel();
				resetModel.setEmail(rs.getString(1));
				resetModel.setOldPassword(rs.getString(2));
				return resetModel;
			}
		});
	}
	public int updatePassword(ResetModel resetModel) {
		// TODO Auto-generated method stub
		String sql = "UPDATE admin SET password=? WHERE email=?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException{
				PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, resetModel.getRePassword());
				ps.setString(2, resetModel.getEmail());
				return ps;
			} 
		});
	}

}
