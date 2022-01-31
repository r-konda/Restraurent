package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.model.DinnerMenu;
import com.example.demo.model.LunchMenu;
import com.example.demo.model.LunchMenuDetails;
import com.example.demo.model.MorningMenuDetails;
import com.example.demo.model.TotalOrder;
import com.example.demo.repository.CustomerRepo;
import com.example.demo.repository.LunchMenuDetailsRepo;
import com.example.demo.repository.LunchMenuRepo;
import com.example.demo.repository.MorningMenuDetailsRepoistory;


@Service
public class LunchMenuServiceImpl implements LunchMenuService
{
	@Autowired
	private LunchMenuRepo lunchMenuRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private LunchMenuDetailsRepo lunchMenuDetailsRepo;

	

	@Override
	public List<LunchMenu> getAllLunchMenuList() {
		
		return  lunchMenuRepo.findAll();
	}
	
	@Override
	public List<LunchMenuDetails> saveLunchMenuDetails(String[] list) {
		List<LunchMenuDetails> details = new ArrayList<>();
		Customer cust = this.customerRepo.findById(this.customerRepo.getRecentCustomerId()).orElse(null);
		for(String val : list) {
			LunchMenuDetails lunchMenuDetails=new LunchMenuDetails();
			lunchMenuDetails.setLunchDetails(this.lunchMenuRepo.findById(Long.valueOf(val)).orElse(null));
			lunchMenuDetails.setCustomerDetails(cust);
			details.add(lunchMenuDetails);
		}
		return this.lunchMenuDetailsRepo.saveAll(details);
	}
	
	@Override
	public TotalOrder getLunchMenuDetails() {
		Customer cust = this.customerRepo.findById(this.customerRepo.getRecentCustomerId()).orElse(null);
		List<LunchMenuDetails> list = this.lunchMenuDetailsRepo.findByCustomerDetails(cust);
		TotalOrder total = new TotalOrder();
		List<DinnerMenu> li = new ArrayList<>();
		double tot = 0.0;
		for(LunchMenuDetails det: list) {

			DinnerMenu menu = new DinnerMenu();
			menu.setName(det.getLunchDetails().getName());
			menu.setPrice(det.getLunchDetails().getPrice());
			tot += det.getLunchDetails().getPrice();
			li.add(menu);
		}
		total.setMenu(li);
		total.setTotal(String.valueOf(tot));
		if(tot >= 1000) {
			total.setApplicable("YES");
			tot -= (tot*0.1);
			total.setDiscTotal(String.valueOf(tot));
		} else {
			total.setApplicable("NO");
		}
		return total;
	}
	
	@Override
	public List<Customer> getDiscountApplicableCustomers() {
		List<Customer> applicables = new ArrayList<>();
		List<Customer> all = this.customerRepo.findAll();
		for(Customer cust: all) {
			List<LunchMenuDetails> items = this.lunchMenuDetailsRepo.findByCustomerDetails(cust);
			double tot = 0.0;
			for(LunchMenuDetails det: items) {
				tot += det.getLunchDetails().getPrice();
			}
			if(tot >= 1000) {
				applicables.add(cust);
			}
		}
		return applicables;
	}
	

}
