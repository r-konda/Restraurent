package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;
import com.example.demo.model.DinnerMenuDetails;

@Repository
public interface DinnerMenuDetailsRepo extends JpaRepository<DinnerMenuDetails, Long> {
	List<DinnerMenuDetails> findByCustomerDetails(Customer customerDetails);

}
