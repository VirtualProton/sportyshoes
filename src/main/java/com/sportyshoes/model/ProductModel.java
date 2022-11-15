package com.sportyshoes.model;

import org.springframework.web.multipart.MultipartFile;

public class ProductModel {
	
	public int product_id ; 
	public String product_name;
    public String product_description;
    public String product_catagory;
    public double product_price;
    public String product_image;
    public MultipartFile file;
    
    public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	public String getProduct_catagory() {
		return product_catagory;
	}
	public void setProduct_catagory(String product_catagory) {
		this.product_catagory = product_catagory;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
//	@Override
//	public String toString() {
//		return "ProductModel [product_id=" + product_id + ", product_name=" + product_name + ", product_description="
//				+ product_description + ", product_catagory=" + product_catagory + ", product_price=" + product_price
//				+ ", product_image=" + product_image + file.getOriginalFilename() "]";
//	}
	@Override
	public String toString() {
		return "ProductModel [product_id=" + product_id + ", product_name=" + product_name + ", product_description="
				+ product_description + ", product_catagory=" + product_catagory + ", product_price=" + product_price
				+ ", product_image=" + product_image + ", file=" + file.getOriginalFilename() + "]";
	}
	
}
