package com.sales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sales.models.*;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {

	public Product findByPId (long pId);
}
