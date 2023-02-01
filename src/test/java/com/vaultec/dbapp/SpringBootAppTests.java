package com.vaultec.dbapp;

import com.vaultec.dbapp.model.entity.Dweller;
import com.vaultec.dbapp.repository.ComplaintsRepository;
import com.vaultec.dbapp.repository.DwellerRepository;
import com.vaultec.dbapp.repository.view.DwellerViewRepo;
import com.vaultec.dbapp.services.DwellerService;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringBootAppTests {

	@Autowired
	DwellerRepository dwellerRepository;

	@Autowired
	ComplaintsRepository complaintsRepository;

	@Autowired
	DwellerViewRepo dwellerViewRepo;

	@Autowired
	DwellerService dwellerService;

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

		Assertions.assertEquals(dwellerRepository.findById(6L).orElse(new Dweller()).getDweller_id(), dweller.getDweller_id());

	}

	@Test
	void loginTest2() {

		String password = DigestUtils.sha256Hex("guwno");
		Dweller dweller = dwellerRepository.findByCredentials("huj", password);

		Assertions.assertEquals(dwellerRepository.findById(-1L).orElse(new Dweller()).getDweller_id(), dweller.getDweller_id());
	}

	@Test
	void complaintTest() {
		Assertions.assertEquals(complaintsRepository.findAllByDwellerId(6L).size(), 1);
	}

	@Test
	void complaintTest2() {
		Assertions.assertEquals(complaintsRepository.findAllByVerStatus("pending").size(), 1);
	}

	@Test
	void dwellerViewTest(){
		Assertions.assertEquals(dwellerViewRepo.findAll().size(), 11);
	}

	@Test
	void dwellerServiceTest(){
		Assertions.assertEquals(dwellerService.getDwellerRepository().findById(0L).get().getDweller_id(), 0L);
	}
}
