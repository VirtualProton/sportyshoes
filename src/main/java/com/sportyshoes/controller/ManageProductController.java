package com.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sportyshoes.model.ProductModel;
import com.sportyshoes.service.ProductService;

@Controller
public class ManageProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public String manageProduct(Model model)  {
		List<ProductModel> productModel = productService.getproducts();
		model.addAttribute("products",productModel);
		return "manageproduct";
	}
	
	@GetMapping("/addproduct")
	public String addProduct(Model model) {
		ProductModel pm = new ProductModel();
		model.addAttribute("productModel", pm);
		return "addproduct";
	}
	

	@GetMapping("/delete")
	public String deleteProduct(@RequestParam(name="product_id",required=true)int product_id) {
		ProductModel productModel= new ProductModel();
		productModel.setProduct_id(product_id);
		productService.deleteproduct(productModel);
		return "redirect:/products";
		
	}
	
	@GetMapping("/edit")
	public String editProduct(@RequestParam(name="product_id",required=true)int product_id,
			@RequestParam(name="product_name",required=true)String product_name,
			@RequestParam(name="product_description",required=true)String product_description,
			@RequestParam(name="product_catagory",required=true)String product_catagory,
			@RequestParam(name="product_price",required=true)double product_price,
			@RequestParam(name="product_image",required=true)String product_image,
			Model model)
	{
		ProductModel pm = new ProductModel();
		model.addAttribute("productModel", pm);
		
		model.addAttribute("product_id",product_id);
		model.addAttribute("product_name",product_name);
		model.addAttribute("product_description",product_description);
		model.addAttribute("product_catagory",product_catagory);
		model.addAttribute("product_price",product_price);
		model.addAttribute("product_image",product_image);
	
		return "editproduct";
		
	}
}
