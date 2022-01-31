package com.example.demo.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.LunchMenuService;

/*
 * Here @Controller annotation role is create a map of model object and find a view
 */
@Controller
public class LunchMenuController 
{
	/*
	 * @Autowired annotation enables you to inject the object dependency implicitly
	 */
	@Autowired
	 private LunchMenuService lunchMenuService;
	/*
	 * load the lunch Menu page
	 */
	 @GetMapping("/lunch")
	 public String viewHomePage(Model model)
	 {
		 
	    model.addAttribute("lunchList", lunchMenuService.getAllLunchMenuList());
	    return "lunch"; 
	 }
	 
	 @GetMapping("/calculations")
	 public String getAllValues(@RequestParam String[] selected1,Model model) {
//		 System.out.println("vrist"+selected1);
		 lunchMenuService.saveLunchMenuDetails(selected1);
		 model.addAttribute("orderList", lunchMenuService.getLunchMenuDetails());
			model.addAttribute("DiscountAppliedCustomerList", lunchMenuService.getDiscountApplicableCustomers());
			
			return "totalCalculation";
	 }

}
