package com.sportyshoes.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sportyshoes.model.ProductModel;
import com.sportyshoes.service.ProductService;

@Controller
public class EditProductController {
	@Autowired
	ProductService productService;
	public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";
	
	@PostMapping("/update")
	public String updateProduct(@ModelAttribute("productModel") ProductModel productModel, Model model) throws IOException{
		if(productModel.getFile()==null) 
		{
			productService.editproduct(productModel);
			return "redirect:/products";
		}else if(productModel.getFile()!=null) {
			StringBuilder fileNames = new StringBuilder();
			Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, productModel.getFile().getOriginalFilename());
			fileNames.append(productModel.getFile().getOriginalFilename());
			Files.write(fileNameAndPath,productModel.getFile().getBytes() );
			productModel.setProduct_image(fileNameAndPath.toString());
				System.out.print(productModel);
				productService.editproduct(productModel);
				return "redirect:/products";
		}
		
		return null;
		
	}
}
