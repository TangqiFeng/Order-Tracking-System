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

import com.sales.models.Customer;
import com.sales.services.*;


@Controller
public class CustomerController {

	@Autowired
	@Qualifier("CustomerService")
	private CustomerService customerService;
	
	
	@GetMapping(value = "/showCustomers")
	public String AllCustomers(Model model){
		model.addAttribute("allCustomers",customerService.getCustomers());
		
		return "showCustomers";
	}
	
	
	Customer customer = new Customer();
	@GetMapping(value = "/addCustomer" )
	public String addCustomerForm(Model model){
		model.addAttribute("customer",customer);
		return "AddCustomer";
	}
	
	@PostMapping(value = "/addCustomer" )
	public String addCustomer(@Valid@ModelAttribute ("customer") Customer customer,BindingResult result){
		if (result.hasErrors()) {
			System.out.println("error");
			return "AddCustomer";
		} else{
			System.out.println("no error");
		}
		customerService.addCustomer(customer);
		return "redirect:showCustomers";
	}
	
}
