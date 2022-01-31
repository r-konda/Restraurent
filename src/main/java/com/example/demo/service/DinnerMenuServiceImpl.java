package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.model.DinnerMenu;
import com.example.demo.model.DinnerMenuDetails;
import com.example.demo.model.MorningMenuDetails;
import com.example.demo.model.TotalOrder;
import com.example.demo.repository.CustomerRepo;
import com.example.demo.repository.DinnerMenuDetailsRepo;
import com.example.demo.repository.DinnerMenuRepo;
@Service
public class DinnerMenuServiceImpl implements DinnerMenuService {
	
	@Autowired
	private DinnerMenuRepo dinnermenu;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private DinnerMenuRepo dinnerMenuRepo;
	
	@Autowired
	private DinnerMenuDetailsRepo dinnerMenuDetailsRepo;
	
	@Override
	public List<DinnerMenu> getAllList() {
		return dinnermenu.findAll();
	}
	
	@Override
	public List<DinnerMenuDetails> saveDinnerMenuDetails(String[] list) {
		List<DinnerMenuDetails> details = new ArrayList<>();
		Customer cust = this.customerRepo.findById(this.customerRepo.getRecentCustomerId()).orElse(null);
		for(String val : list) {
			DinnerMenuDetails det = new DinnerMenuDetails();
			det.setDinnerDetails(this.dinnerMenuRepo.findById(Long.valueOf(val)).orElse(null));
			det.setCustomerDetails(cust);
			details.add(det);
		}
		return this.dinnerMenuDetailsRepo.saveAll(details);
	}
	
	@Override
	public TotalOrder getDinnerMenuDetails() {
		Customer cust = this.customerRepo.findById(this.customerRepo.getRecentCustomerId()).orElse(null);
		List<DinnerMenuDetails> list = this.dinnerMenuDetailsRepo.findByCustomerDetails(cust);
		TotalOrder total = new TotalOrder();
		List<DinnerMenu> li = new ArrayList<>();
		double tot = 0.0;
		for(DinnerMenuDetails det: list) {
			li.add(det.getDinnerDetails());
			tot += det.getDinnerDetails().getPrice();
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
			List<DinnerMenuDetails> items = this.dinnerMenuDetailsRepo.findByCustomerDetails(cust);
			double tot = 0.0;
			for(DinnerMenuDetails det: items) {
				tot += det.getDinnerDetails().getPrice();
			}
			if(tot >= 1000) {
				applicables.add(cust);
			}
		}
		return applicables;
	}
	
	

}
