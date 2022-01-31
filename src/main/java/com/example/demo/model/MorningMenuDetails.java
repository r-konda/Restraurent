package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * @Entity annotation role is it make this class has one entity
 */
@Entity
/*
 * @Table annotation is automatically create a table in db with respective table name
 */

@Table(name="customer_morningmenu123")
public class MorningMenuDetails implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id", referencedColumnName = "customer_id", nullable = false, insertable = true, updatable = true)
	private Customer customerDetails;
    
	/*
	 * used to create the one-to-one relationship between two entities.
	 */
	@OneToOne(cascade = CascadeType.ALL)
	/*
	 * when we want to create multiple join columns, we can use the @JoinColumns annotation
	 */
	@JoinColumn(name="morning_id", referencedColumnName = "morning_id")
	private MorningMenu morningDetails;
	
	public MorningMenuDetails() {
		// TODO Auto-generated constructor stub
	}

	public MorningMenuDetails(Integer id, Customer customerDetails, MorningMenu morningDetails) {
		super();
		this.id = id;
		this.customerDetails = customerDetails;
		this.morningDetails = morningDetails;
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

	public MorningMenu getMorningDetails() {
		return morningDetails;
	}

	public void setMorningDetails(MorningMenu morningDetails) {
		this.morningDetails = morningDetails;
	}
	

}
