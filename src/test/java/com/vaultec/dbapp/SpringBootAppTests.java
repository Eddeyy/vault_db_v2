package com.vaultec.dbapp;

import com.vaultec.dbapp.model.Dweller;
import com.vaultec.dbapp.repository.ComplaintsRepository;
import com.vaultec.dbapp.repository.DwellerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import org.junit.After;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.orm.jpa.EntityManagerHolder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringBootAppTests {

	@Autowired
	DwellerRepository dwellerRepository;

	@Autowired
	ComplaintsRepository complaintsRepository;


	@BeforeAll
	public static void setUp(){
		System.setProperty("java.awt.headless", "false");
	}

	@AfterAll
	public static void tearDown(){
	}

	@Test
	void contextLoads() {
	}

	@Test
	void loginTest() {


		String password = DigestUtils.sha256Hex("belarus");
		Dweller dweller = dwellerRepository.findByCredentials("dimag", password);

		Assertions.assertEquals(dwellerRepository.findById(6L).orElse(new Dweller()), dweller);

	}

	@Test
	void loginTest2() {

		String password = DigestUtils.sha256Hex("guwno");
		Dweller dweller = dwellerRepository.findByCredentials("huj", password);

		Assertions.assertEquals(dwellerRepository.findById(-2L).orElse(new Dweller()), dweller);
	}

	@Test
	void complaintTest() {
		Assertions.assertEquals(complaintsRepository.findAllByDwellerId(6L).size(), 1);
	}

	@Test
	void complaintTest2() {
		Assertions.assertEquals(complaintsRepository.findAllByVerStatusStatus("pending").size(), 1);
	}
}
