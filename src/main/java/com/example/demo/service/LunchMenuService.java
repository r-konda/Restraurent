package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Customer;
import com.example.demo.model.LunchMenu;
import com.example.demo.model.LunchMenuDetails;
import com.example.demo.model.TotalOrder;


public interface LunchMenuService 
{
	List<LunchMenu> getAllLunchMenuList();
	public List<LunchMenuDetails> saveLunchMenuDetails(String[] list);
	 public TotalOrder getLunchMenuDetails();
	  public List<Customer> getDiscountApplicableCustomers();

}
