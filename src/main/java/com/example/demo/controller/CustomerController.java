package com.example.demo.controller;

import java.lang.reflect.Array;
import java.net.http.HttpRequest;
import java.util.Arrays;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Customer;
import com.example.demo.model.MorningMenu;
import com.example.demo.repository.CustomerRepo;

/*
 * Here @Controller annotation role is create a map of model object and find a view
 */
@Controller
public class CustomerController {
	
	/*
	 * @Autowired annotation enables you to inject the object dependency implicitly
	 */
	@Autowired
	private CustomerRepo customerRepo;

	/*
	 * load the customer page
	 */
    @GetMapping("/")
	public String customerPage() {
		return "customer";
	}

    /*
	 * after the save the customer data 
	 * and return the home page
	 */
	@PostMapping("/saveData")
	public String saveData(Customer customer) {
		
		customerRepo.save(customer);
		return "redirect:/home";

	}
	/*
	 * load the home page
	 */

	@GetMapping("/home")
	public String homePage() {
		return "home";
	}
	
	/* Here based on condition 
	 * load the respective pages
	 */
	/*
	 * @RequestParam annotation is used to read the form data and bind it automatically..
	 */

	@RequestMapping("/checkButtons")
	public String checkButtons(@RequestParam String one) {
		if (one != null && one.equalsIgnoreCase("MorningMenu")) {
			return "redirect:/morning";
		} else if (one != null && one.equalsIgnoreCase("LunchMenu")) {
			return "redirect:/lunch";
		} else if (one != null && one.equalsIgnoreCase("DinnerMenu")) {
			return "redirect:/dinner";
		} else {
			return "redirect:/home";
		}
	}
	
	/*
	 * Here @RequestMapping used for mapping  all type income HTTP request URLs
	 */

}
