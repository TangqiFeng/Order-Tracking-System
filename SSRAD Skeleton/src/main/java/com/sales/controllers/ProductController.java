package com.sales.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sales.models.Product;
import com.sales.services.*;

@Controller
public class ProductController {

	@Autowired
	@Qualifier("ProductService")
	private ProductService productService;
	
	
	@GetMapping(value = "/showProducts")
	public String AllProducts(Model model){
		model.addAttribute("allProducts",productService.getProducts());
		return "showProducts";
	}
	
	Product product = new Product();
	@GetMapping(value = "/addProduct" )
	public String addProductForm( Model model){
		
		model.addAttribute("product",product);
		
		return "AddProduct";
	}
	
	@PostMapping(value = "/addProduct" )
	public String addProduct(@Valid@ModelAttribute ("product") Product product,BindingResult result){
		if (result.hasErrors()) {
			System.out.println("error");
			return "AddProduct";
		} else{
			System.out.println("no error");
		}
		productService.addProduct(product);
		return "redirect:showProducts";
	}
	
}
