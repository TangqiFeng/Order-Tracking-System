package com.sales.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	
	@GetMapping(value = "/logoutDone")
	public String AllCustomers(){
		
		return "logout";
	}
}
