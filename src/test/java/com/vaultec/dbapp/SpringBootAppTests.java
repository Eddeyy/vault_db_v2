package com.vaultec.dbapp;

import com.vaultec.dbapp.model.Dweller;
import com.vaultec.dbapp.repository.DwellerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;

@SpringBootTest
class SpringBootAppTests {

	@Autowired
	DwellerRepository dwellerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void loginTest() {


		String password = DigestUtils.sha256Hex("belarus");
		Dweller dweller = dwellerRepository.findByCredentials("dimag", password);

		Assertions.assertEquals(dwellerRepository.findById(6L).orElse(new Dweller()), dweller);

	}

}
