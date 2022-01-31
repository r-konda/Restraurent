package com.example.demo;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.model.MorningMenu;
import com.example.demo.repository.MorningMenuRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MorningMenuRepoTest
{
	@Autowired
	private MorningMenuRepo morningMenuRepo;
	
	//Junit test for ListOfMorningMenu
	
	@Test
	public void getListOfMorningMenuTest()
	{
		List<MorningMenu> mList=morningMenuRepo.findAll();
		Assertions.assertThat(mList.size()).isGreaterThan(0);
	}
	

}
