package com.example.demo;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.model.LunchMenu;
import com.example.demo.model.MorningMenu;
import com.example.demo.repository.LunchMenuRepo;
import com.example.demo.repository.MorningMenuRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LunchMenuRepoTest 
{
	@Autowired
	private LunchMenuRepo lunchMenuRepo;
	
	//Junit test for ListOfLunchMenu
	
	@Test
	public void getListOfLunchMenuTest()
	{
		List<LunchMenu> lList=lunchMenuRepo.findAll();
		Assertions.assertThat(lList.size()).isGreaterThan(0);
	}
	

}
