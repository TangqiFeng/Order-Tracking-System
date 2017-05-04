package com.sales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sales.models.*;

@Repository
public interface OrderDAO extends JpaRepository<Order, Long> {

	
}
