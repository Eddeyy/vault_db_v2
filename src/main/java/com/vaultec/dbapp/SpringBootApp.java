package com.vaultec.dbapp;

import com.vaultec.dbapp.repository.*;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.awt.*;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {
		"com.vaultec.dbapp"
})
@EntityScan(basePackages = "com.vaultec.dbapp.")
public class SpringBootApp{

	public static ApplicationContext apc;

	public static void main(String[] args) {
		apc = new SpringApplicationBuilder(SpringBootApp.class).headless(false).run(args);

		for(String bean : apc.getBeanDefinitionNames())
		{
			System.out.println(bean);
		}
	}

	@Bean
	public static ApplicationContext getApc() {
		return apc;
	}
}
