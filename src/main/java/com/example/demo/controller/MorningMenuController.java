package com.example.demo.controller;





import java.util.Arrays;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.MorningMenu;
import com.example.demo.service.LunchMenuService;
import com.example.demo.service.MorningMenuService;

/*
 * Here @Controller annotation role is create a map of model object and find a view
 */
@Controller
public class MorningMenuController 
{
	/*
	 * @Autowired annotation enables you to inject the object dependency implicitly
	 */
	 @Autowired
	 private MorningMenuService morningMenuService;
	 
	 
	 /*
		 * load the Morning Menu page
		 */
	 @GetMapping("/morning")
	 public String viewHomePage(Model model)
	 {
		 
	    model.addAttribute("morningList", morningMenuService.getAllMorningMenuList());
	   
	    return "morning"; 
	 }
	 
	 @GetMapping("/calculation")
		public String getAllValues(@RequestParam String[] selected, Model model)
		{
//	 		System.out.println("Rare :: "+Arrays.toString(selected));
			morningMenuService.saveMorningMenuDetails(selected);
			model.addAttribute("orderList", morningMenuService.getMorningMenuDetails());
			model.addAttribute("DiscountAppliedCustomerList", morningMenuService.getDiscountApplicableCustomers());
			
			return "totalCalculation";
		}
	
	

}
