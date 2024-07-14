package com.example.PlooxaCompanyAndEmployee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "CompanyController,"+"CompanyService")
@EnableJpaRepositories(basePackages = "CompanyAndIdAndCompanyNameRepository")
// @EntityScan("CompanyAndIdAndCompanyName")
public class PlooxaCompanyAndEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlooxaCompanyAndEmployeeApplication.class, args);
	}

}
