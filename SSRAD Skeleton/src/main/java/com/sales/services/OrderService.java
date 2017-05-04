package com.sales.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sales.exceptions.InvalidStockException;
import com.sales.exceptions.MyException;
import com.sales.models.Customer;
import com.sales.models.NewOrder;
import com.sales.models.Order;
import com.sales.models.Product;
import com.sales.repositories.*;

@Service("OrderService")
public class OrderService {

	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private CustomerDAO customerDAO;
	@Autowired
	private ProductDAO productDAO;
	
	public ArrayList<Order> getOrders(){
		ArrayList<Order> orders = (ArrayList<Order>) orderDAO.findAll();
		
		return orders;
	}
	
	public void addOrders(NewOrder neworder) throws MyException, InvalidStockException{
		
		
		
		//cid pid qty
		
		// If pid ok you'll have qty in stock
		
		//subtract order.qty from product.qty
		//if less than 0 - error

		long checkCid = Long.parseLong(neworder.getcId());
		long checkPid = Long.parseLong(neworder.getpId());
		int checkQty = neworder.getQty();
		
		Customer checkCustomer = customerDAO.findByCId(checkCid);
		Product checkProduct = productDAO.findByPId(checkPid);
		//Check does cId exist in DB
		if(checkCustomer == null || checkProduct == null){
			//Check does pId exist in DB
			if(checkCustomer == null && checkProduct == null){
				System.out.println(checkCid + "    error customer id");
				System.out.println(checkPid + "    error product id");
				throw new MyException("No such customer : "+ checkCid +"  No such Product : "+ checkPid);
			}else{
				if(checkCustomer == null){
					System.out.println(checkCid + "    error customer id");
					throw new MyException("No such customer : "+ checkCid);
				}
				if(checkProduct == null){
					System.out.println(checkPid + "    error product id");
					throw new MyException("No such Product : "+ checkPid);
				}
			
			}
			
		}
		else{
			
			if(checkQty > checkProduct.getQtyInStock()){
				System.out.println(checkQty + "    error value inStock");
				throw new MyException("Quantity too large :   Product Stock = "+ checkProduct.getQtyInStock());
			}
			else if(checkQty < 1){
				System.out.println(checkQty + "    error value inStock");
				throw new InvalidStockException("must be greater than or equal to 1");
			}
			else{
				Order order = new Order();// new order to add

				//The Product table is updated to reflect the new quantity
				checkProduct.setQtyInStock((checkProduct.getQtyInStock() - checkQty));

				// automatically add date
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				order.setOrderDate(dateFormat.format(date));
				
				order.setCust(checkCustomer);
				order.setProd(checkProduct);
				order.setQty(checkQty);
				
				
				try{
					//save new order
					orderDAO.save(order);
					
				}catch(Exception e){
					
				}
			}
			
			
			
			
			
			
			
		}
		
		
	}
	
}
