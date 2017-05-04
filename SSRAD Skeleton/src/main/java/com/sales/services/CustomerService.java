package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Customer;
import com.sales.repositories.*;

@Service("CustomerService")
public class CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	public ArrayList<Customer> getCustomers(){
		ArrayList<Customer> customers = (ArrayList<Customer>) customerDAO.findAll();
		
		return customers;
	}
	
	public void addCustomer(Customer customer){
		try{
			customerDAO.save(customer);
			
		}catch(Exception e){
			
		}
	}
}
