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
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.sportyshoes.model.ProductModel;
@Repository
public class ProductDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	//get product
	public List<ProductModel> getProducts() {
		// TODO Auto-generated method stub
		String sql = "select * from products";
		return jdbcTemplate.query(sql, new RowMapper<ProductModel>() {
			@Override
			public ProductModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProductModel productModel = new ProductModel();
				productModel.setProduct_id(rs.getInt(1));
				productModel.setProduct_name(rs.getString(2));
				productModel.setProduct_description(rs.getString(3));
				productModel.setProduct_catagory(rs.getString(4));
				productModel.setProduct_price(rs.getDouble(5));
				productModel.setProduct_image(rs.getString(6));
				return productModel;
			}
		});
		
	}
	
	
	
	//add product
	public int addProduct(ProductModel productModel){
		String sql ="insert into products values(?,?,?,?,?,?)";
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException{
				PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1,productModel.getProduct_id());
				ps.setString(2,productModel.getProduct_name());
				ps.setString(3,productModel.getProduct_description());
				ps.setString(4,productModel.getProduct_catagory());
				ps.setDouble(5,productModel.getProduct_price());
				ps.setString(6,productModel.getProduct_image());
				return ps;
			} 
		},holder);
		System.out.println(holder.getKey().intValue());
		 return holder.getKey().intValue();
		
	}
	
	
	//delete product
	public int deleteProduct(ProductModel productModel) {
	
		String sql ="Delete from products where product_id=?";
		return jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, productModel.getProduct_id());
				boolean n =ps.execute();
				 System.out.println(n);
				return ps;
			}
			
		});
	
	}
	
	//edit
	public int editProduct(ProductModel productModel) {
		
		String sql ="Update products Set product_name=?,product_description=?,product_catagory=?,product_price=?,product_image=?  where product_id=?";
		return jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, productModel.getProduct_name());
				ps.setString(2, productModel.getProduct_description());
				ps.setString(3, productModel.getProduct_catagory());
				ps.setDouble(4, productModel.getProduct_price());
				ps.setString(5, productModel.getProduct_image());
				ps.setInt(6, productModel.getProduct_id());
				boolean n =ps.execute();
				 System.out.println(n);
				return ps;
			}
			
		});
	
	}
}
