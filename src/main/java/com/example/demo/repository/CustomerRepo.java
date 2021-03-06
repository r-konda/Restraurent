package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Integer>
{
	@Query(value = "SELECT max(id) FROM Customer")
	int getRecentCustomerId();

}
