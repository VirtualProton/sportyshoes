package com.sportyshoes.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.sportyshoes.model.PurchasedModel;

@Repository
public class PurchasedDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	public List<PurchasedModel> getreport() {
		// TODO Auto-generated method stub
		String sql = "select * from purchase_report";
		return jdbcTemplate.query(sql, new RowMapper<PurchasedModel>() {
			@Override
			public PurchasedModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				PurchasedModel purchasedModel = new PurchasedModel();
				purchasedModel.setId(rs.getInt(1));;
				purchasedModel.setDate_time(rs.getString(2));
				purchasedModel.setProductName(rs.getString(3));
				purchasedModel.setProductCategory(rs.getString(4));
				purchasedModel.setPurchasedBy(rs.getString(5));;
				purchasedModel.setPhonneNumber(rs.getString(6));
				purchasedModel.setEmailId(rs.getString(7));
				purchasedModel.setAddress(rs.getString(8));
				return purchasedModel;
			}
		});
	}
	public List<PurchasedModel> getfilteredreport(String filter) {
		// TODO Auto-generated method stub
		String sql = "select * from purchase_report where product_category = ?";
		return jdbcTemplate.query(sql, new PreparedStatementSetter(){
			public void setValues(PreparedStatement ps)throws SQLException {
				ps.setString(1, filter);
			}
		},new RowMapper<PurchasedModel>() {
			@Override
			public PurchasedModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				PurchasedModel purchasedModel = new PurchasedModel();
				purchasedModel.setId(rs.getInt(1));;
				purchasedModel.setDate_time(rs.getString(2));
				purchasedModel.setProductName(rs.getString(3));
				purchasedModel.setProductCategory(rs.getString(4));
				purchasedModel.setPurchasedBy(rs.getString(5));;
				purchasedModel.setPhonneNumber(rs.getString(6));
				purchasedModel.setEmailId(rs.getString(7));
				purchasedModel.setAddress(rs.getString(8));
				return purchasedModel;
			}
		});
	}
	public List<PurchasedModel> getfilteredreportbydate(String date) {
		// TODO Auto-generated method stub
		String sql = "select * from purchase_report where date_time LIKE ?";
		return jdbcTemplate.query(sql, new PreparedStatementSetter(){
			public void setValues(PreparedStatement ps)throws SQLException {
				ps.setString(1,date+"%");
			}
		},new RowMapper<PurchasedModel>() {
			@Override
			public PurchasedModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				PurchasedModel purchasedModel = new PurchasedModel();
				purchasedModel.setId(rs.getInt(1));;
				purchasedModel.setDate_time(rs.getString(2));
				purchasedModel.setProductName(rs.getString(3));
				purchasedModel.setProductCategory(rs.getString(4));
				purchasedModel.setPurchasedBy(rs.getString(5));;
				purchasedModel.setPhonneNumber(rs.getString(6));
				purchasedModel.setEmailId(rs.getString(7));
				purchasedModel.setAddress(rs.getString(8));
				return purchasedModel;
			}
		});
	}

}
