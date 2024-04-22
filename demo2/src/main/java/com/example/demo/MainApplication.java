package com.example.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot main class and controller for BOGO offers
 */
@SpringBootApplication
@RestController
public class MainApplication {

	static final Logger log = LoggerFactory.getLogger(MainApplication.class);

	@Autowired
	private BogoService bogoService;

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@GetMapping("/bogo")
	public String helloApi() {
		return "Hello from Bogo Get Method API";
	}

	/*
	 * Post method for BOGO offer 1
	 */
	@PostMapping(value = "/bogoOffer1", consumes = { "application/json" })
	public BogoResponse applyBOGOOffer1(@RequestBody List<Integer> priceList) {

		return bogoService.applyBOGOOffer1(priceList);
	}

	/*
	 * Post method for BOGO offer 2
	 */
	@PostMapping(value = "/bogoOffer2", consumes = { "application/json" })
	public BogoResponse applyBOGOOffer2(@RequestBody List<Integer> priceList) {

		return bogoService.applyBOGOOffer2(priceList);
	}

	/*
	 * Post method for BOGO offer 3
	 */
	@PostMapping(value = "/bogoOffer3", consumes = { "application/json" })
	public BogoResponse applyBOGOOffer3(@RequestBody List<Integer> priceList) {

		return bogoService.applyBOGOOffer3(priceList);
	}

}
