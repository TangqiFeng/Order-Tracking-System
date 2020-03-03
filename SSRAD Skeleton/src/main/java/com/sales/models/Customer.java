package com.sales.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="CUSTOMERS")
public class Customer {
	@Id
	@GeneratedValue
	@Column(name="CID")
	private Long cid;

	@Column(name="CNAME")
	@NotBlank
	private String cName;
	
	@OneToMany(mappedBy="cust")
	private List<Order> orders = new ArrayList<Order>();

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cId) {
		this.cid = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}	
}