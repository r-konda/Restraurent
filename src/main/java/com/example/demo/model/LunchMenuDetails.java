package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer_lunchmenu123")
public class LunchMenuDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id", referencedColumnName = "customer_id")
	private Customer customerDetails;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="lunch_id", referencedColumnName = "lunch_id")
	private LunchMenu lunchDetails;
	
	public LunchMenuDetails() {
		// TODO Auto-generated constructor stub
	}

	public LunchMenuDetails(Integer id, Customer customerDetails, LunchMenu lunchDetails) {
		super();
		this.id = id;
		this.customerDetails = customerDetails;
		this.lunchDetails = lunchDetails;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Customer getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(Customer customerDetails) {
		this.customerDetails = customerDetails;
	}

	public LunchMenu getLunchDetails() {
		return lunchDetails;
	}

	public void setLunchDetails(LunchMenu lunchDetails) {
		this.lunchDetails = lunchDetails;
	}
	
	

}
