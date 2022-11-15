  package com.sportyshoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.dao.ProductDAO;
import com.sportyshoes.model.ProductModel;

@Service
public class ProductService {
	@Autowired
	ProductDAO productDAO;
	
	//get product
	public List<ProductModel> getproducts(){
		
		return productDAO.getProducts();
	}
	
	
   //add product
	public int addproduct(ProductModel productModel) {
		return productDAO.addProduct(productModel);
	}
	
	//add product
		public int deleteproduct(ProductModel productModel) {
			return productDAO.deleteProduct(productModel);
		}
	//add product
		public int editproduct(ProductModel productModel) {
			return productDAO.editProduct(productModel);
		}
}
