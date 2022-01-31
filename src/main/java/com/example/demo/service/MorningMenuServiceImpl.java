package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.model.DinnerMenu;
import com.example.demo.model.DinnerMenuDetails;
import com.example.demo.model.MorningMenu;
import com.example.demo.model.MorningMenuDetails;
import com.example.demo.model.TotalOrder;
import com.example.demo.repository.CustomerRepo;
import com.example.demo.repository.MorningMenuDetailsRepoistory;
import com.example.demo.repository.MorningMenuRepo;


@Service
public class MorningMenuServiceImpl implements MorningMenuService
{
	@Autowired
	private MorningMenuRepo morningMenuRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private MorningMenuDetailsRepoistory menuDetailsRepoistory;

	@Override
	public List<MorningMenu> getAllMorningMenuList() {
		return  morningMenuRepo.findAll();
	}
	
	@Override
	public List<MorningMenuDetails> saveMorningMenuDetails(String[] list) {
		List<MorningMenuDetails> details = new ArrayList<>();
		Customer cust = this.customerRepo.findById(this.customerRepo.getRecentCustomerId()).orElse(null);
		for(String val : list) {
			MorningMenuDetails det = new MorningMenuDetails();
			det.setMorningDetails(this.morningMenuRepo.findById(Long.valueOf(val)).orElse(null));
			det.setCustomerDetails(cust);
			details.add(det);
		}
		return this.menuDetailsRepoistory.saveAll(details);
	}
	
	@Override
	public TotalOrder getMorningMenuDetails() {
		Customer cust = this.customerRepo.findById(this.customerRepo.getRecentCustomerId()).orElse(null);
		List<MorningMenuDetails> list = this.menuDetailsRepoistory.findByCustomerDetails(cust);
		TotalOrder total = new TotalOrder();
		List<DinnerMenu> li = new ArrayList<>();
		double tot = 0.0;
		for(MorningMenuDetails det: list) {

			DinnerMenu menu = new DinnerMenu();
			menu.setName(det.getMorningDetails().getName());
			menu.setPrice(det.getMorningDetails().getPrice());
			tot += det.getMorningDetails().getPrice();
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
			List<MorningMenuDetails> items = this.menuDetailsRepoistory.findByCustomerDetails(cust);
			double tot = 0.0;
			for(MorningMenuDetails det: items) {
				tot += det.getMorningDetails().getPrice();
			}
			if(tot >= 1000) {
				applicables.add(cust);
			}
		}
		return applicables;
	}

}
