package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;
import com.example.demo.model.LunchMenuDetails;
import com.example.demo.model.MorningMenuDetails;

@Repository
public interface LunchMenuDetailsRepo extends JpaRepository<LunchMenuDetails, Integer> 
{
	List<LunchMenuDetails> findByCustomerDetails(Customer customerDetails);

}
