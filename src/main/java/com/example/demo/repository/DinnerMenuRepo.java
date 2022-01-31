package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DinnerMenu;
/*
 * @Repository annotation is used to indicate that the class provides the
 *  mechanism for storage, retrieval, 
 * search, update and delete operation on objects.
 * 
 */
@Repository
public interface DinnerMenuRepo extends JpaRepository<DinnerMenu, Long>
{
	

}
