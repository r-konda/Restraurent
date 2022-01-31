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
@Table(name="customer_dinnermenu123")
public class DinnerMenuDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id", referencedColumnName = "customer_id")
	private Customer customerDetails;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="dinner_id", referencedColumnName = "dinner_id")
	private DinnerMenu dinnerDetails;

	public DinnerMenuDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public DinnerMenuDetails(Integer id, Customer customerDetails, DinnerMenu dinnerDetails) {
		super();
		this.id = id;
		this.customerDetails = customerDetails;
		this.dinnerDetails = dinnerDetails;
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

	public DinnerMenu getDinnerDetails() {
		return dinnerDetails;
	}

	public void setDinnerDetails(DinnerMenu dinnerDetails) {
		this.dinnerDetails = dinnerDetails;
	}
	
	

	



}
