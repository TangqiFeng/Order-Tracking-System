package com.sales.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sales.exceptions.InvalidStockException;
import com.sales.exceptions.MyException;
import com.sales.models.NewOrder;
import com.sales.models.Order;
import com.sales.services.*;

@Controller
@SessionAttributes(value = {"Order"})
public class OrderController {

	@Autowired
	@Qualifier("OrderService")
	private OrderService orderService;
	
	@GetMapping(value = "/showOrders")
	public String AllOrders(Model model){
		model.addAttribute("allOrders",orderService.getOrders());
		
		return "showOrders";
	}
	
	NewOrder order = new NewOrder();
	@GetMapping(value = "/addOrder" )
	public String addOrderForm(Model model){
		model.addAttribute("Order",order);
		model.addAttribute("errorMsg", errorMsg);
		errorMsg = "";
		return "AddOrder";
	}
	
	String errorMsg = "";
	
	@GetMapping(value = "/ErrorOrder")
	public String showERROR(Model model,@ModelAttribute ("Order") NewOrder order){
		model.addAttribute("errorMsg", errorMsg);
		errorMsg = "";
		return "ErrorOrder";
	}
	
	@PostMapping(value = "/addOrder" )
	public String addOrder(@ModelAttribute ("Order") NewOrder order,HttpServletRequest request){

		try{
			orderService.addOrders(order);
		}
		catch(MyException e ){
			e.printStackTrace();
			errorMsg += e.getMessage();
			return "redirect:ErrorOrder";
		} catch (InvalidStockException e) {
			e.printStackTrace();
			errorMsg += e.getMessage();
			return "redirect:addOrder";
		}
		return "redirect:showOrders";
	}
	
}
