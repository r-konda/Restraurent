package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.model.DinnerMenu;
import com.example.demo.model.DinnerMenuDetails;
import com.example.demo.model.MorningMenuDetails;
import com.example.demo.model.TotalOrder;

public interface DinnerMenuService {
	public List<DinnerMenu> getAllList();
	public List<DinnerMenuDetails> saveDinnerMenuDetails(String[] list);
	public List<Customer> getDiscountApplicableCustomers();
	public TotalOrder getDinnerMenuDetails();
}
