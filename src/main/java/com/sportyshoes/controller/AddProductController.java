package com.sportyshoes.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.sportyshoes.model.ProductModel;
import com.sportyshoes.service.ProductService;

@Controller
public class AddProductController {

	@Autowired
	ProductService productService;
	public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";
	
	@PostMapping("/add")
	public String addproduct(@ModelAttribute("productModel") ProductModel productModel, Model model) throws IOException {
		//File file = new File(productModel.getProduct_image());
		//productService.addproduct(productModel);
		StringBuilder fileNames = new StringBuilder();
		Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, productModel.getFile().getOriginalFilename());
		fileNames.append(productModel.getFile().getOriginalFilename());
		Files.write(fileNameAndPath,productModel.getFile().getBytes() );
		productModel.setProduct_image(fileNameAndPath.toString());
			System.out.print(productModel);
			productService.addproduct(productModel);
			return "redirect:/products";
	}
	
	
}
