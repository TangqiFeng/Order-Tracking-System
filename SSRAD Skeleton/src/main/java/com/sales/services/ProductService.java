package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Product;
import com.sales.repositories.*;

@Service("ProductService")
public class ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	public ArrayList<Product> getProducts(){
		return (ArrayList<Product>) productDAO.findAll();
	}
	
	public void addProduct(Product product){
		try{
			productDAO.save(product);
			
		}catch(Exception e){
			
		}
	}
}
