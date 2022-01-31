package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Customer;
import com.example.demo.model.MorningMenu;
import com.example.demo.model.MorningMenuDetails;
import com.example.demo.model.TotalOrder;

public interface MorningMenuService
{
	  List<MorningMenu> getAllMorningMenuList();
	  public List<MorningMenuDetails> saveMorningMenuDetails(String[] list);
	  public TotalOrder getMorningMenuDetails();
	  public List<Customer> getDiscountApplicableCustomers();
}
