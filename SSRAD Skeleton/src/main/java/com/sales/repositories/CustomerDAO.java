package com.sales.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sales.models.*;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long> {

	public Customer findBycName(String name);
	public Customer findByCid (long cid);
	
	
}
