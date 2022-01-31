package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="morningmenu123")
public class MorningMenu 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	
	@Column(name="morning_id")
	private long id;
	
	@Column(name="item_name")
	private String name;
	
	@Column(name="item_price")
	private double price;
	public MorningMenu() {
		// TODO Auto-generated constructor stub
	}
	
	public MorningMenu(long id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}
