package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Service class for BOGO offers
 */
@Service
public class BogoService {

	static final Logger log = LoggerFactory.getLogger(BogoService.class);

	/*
	 * Offer Rule 1: Customers can buy one product and get another product for free as long as the
	 * price of the product is equal to or less than the price of the first product.
	 * 
	 * Customer Objective: Discount maximization for Customers. The customer’s
	 * objective is to create a pair of 2 items so that the discount is maximized.
	 * 
	 */
	public BogoResponse applyBOGOOffer1(List<Integer> priceList) {
		validate(priceList);
		
		List<Integer> discountedList = new ArrayList<>();
		List<Integer> payableList = new ArrayList<>();

		// Sort the price list in descending order
		List<Integer> sortedPriceList = new ArrayList<>();
		for (int price : priceList) {
			sortedPriceList.add(price);
		}
		Collections.sort(sortedPriceList, Collections.reverseOrder());

		StringBuilder sb = new StringBuilder();
		sortedPriceList.forEach(n -> sb.append(" :").append(n));
		log.info("Offer1 Sorted List - {}", sb);

		// To find discounted and payable items
		for (int i = 0; i < sortedPriceList.size(); i++) {
			int currentItem = sortedPriceList.get(i);
			payableList.add(currentItem);
			for (int j = i + 1; j < sortedPriceList.size(); j++) {
				if (currentItem >= sortedPriceList.get(j)) {
					discountedList.add(sortedPriceList.get(j));
					// log.info("||j: {} - sortedPriceList.remove(): {}", j, sortedPriceList.get(j));
					sortedPriceList.remove(j);
					break;
				}
			}
		}

		Collections.sort(payableList, Collections.reverseOrder());

		log.info("Offer1- Discounted List: {}", discountedList);
		log.info("Offer1- Payable List: {}", payableList);

		return new BogoResponse(discountedList, payableList);
	}

	/*
	 * Offer Rule 2: Customers can buy one product and get another product for free
	 * as long as the price of the product is less than the price of the
	 * corresponding product in pairs.
	 */
	public BogoResponse applyBOGOOffer2(List<Integer> priceList) {
		validate(priceList);
		
		List<Integer> discountedList = new ArrayList<>();
		List<Integer> payableList = new ArrayList<>();

		List<Integer> sortedPriceList = new ArrayList<>();
		for (int price : priceList) {
			sortedPriceList.add(price);
		}
		Collections.sort(sortedPriceList);

		StringBuilder sb = new StringBuilder();
		sortedPriceList.forEach(n -> sb.append(" :").append(n));
		log.info("Offer2 Sorted List - {}", sb);

		int i = sortedPriceList.size() - 1;
		while (i >= 1) {
			if ((sortedPriceList.get(i) == sortedPriceList.get(i - 1)) && (i > 2)) {
				payableList.add(sortedPriceList.get(i));
				payableList.add(sortedPriceList.get(i - 1));
				i -= 2;
				if((sortedPriceList.get(i+2) > sortedPriceList.get(i)) && (sortedPriceList.get(i+2) > sortedPriceList.get(i)) ) {
					discountedList.add(sortedPriceList.get(i));
					discountedList.add(sortedPriceList.get(i - 1));
					i -= 2;
				}
			} else {
					payableList.add(sortedPriceList.get(i));
					discountedList.add(sortedPriceList.get(i - 1));
				i -= 2;
			}
		}

		log.info("Offer2- Discounted List: {}", discountedList);
		log.info("Offer2- Payable List: {}", payableList);

		return new BogoResponse(discountedList, payableList);
	}

	/*
	 * Offer Rule 3: Customers can buy two products and get two products for free as
	 * long as the price of the product is less than the price of the first product.
	 */
	public BogoResponse applyBOGOOffer3(List<Integer> priceList) {
		validate(priceList);
		
		List<Integer> discountedList = new ArrayList<>();
		List<Integer> payableList = new ArrayList<>();

		List<Integer> sortedPriceList = new ArrayList<>();
		for (int price : priceList) {
			sortedPriceList.add(price);
		}
		Collections.sort(sortedPriceList);

		StringBuilder sb = new StringBuilder();
		sortedPriceList.forEach(n -> sb.append(" :").append(n));
		log.info("Offer3 Sorted List - {}", sb);

		int i = sortedPriceList.size() - 1;
		while (i >= 1) {
			if (Objects.equals(sortedPriceList.get(i), sortedPriceList.get(i - 1)) && (i > 2)) {
				payableList.add(sortedPriceList.get(i));
				payableList.add(sortedPriceList.get(i - 1));
				i -= 2;
				if(sortedPriceList.get(i+1) > sortedPriceList.get(i)) {
					discountedList.add(sortedPriceList.get(i));
					discountedList.add(sortedPriceList.get(i - 1));
					i -= 2;
				}
			} else {
				if( (sortedPriceList.get(i) > sortedPriceList.get(i-1)) ) {
					payableList.add(sortedPriceList.get(i));
					discountedList.add(sortedPriceList.get(i - 1));
				} else {
					payableList.add(sortedPriceList.get(i));
					payableList.add(sortedPriceList.get(i - 1));
				}
				i -= 2;
			}
		}
		if (i == 0) {
			payableList.add(sortedPriceList.get(i));
		}

		log.info("Offer3- Discounted List: {}", discountedList);
		log.info("Offer3- Payable List: {}", payableList);

		return new BogoResponse(discountedList, payableList);
	}
	
	/*
	 * Validations on input
	 */
	public void validate(List<Integer> priceList) {
		if(priceList == null || priceList.isEmpty()) {
			log.info("priceList is empty **");
			throw new CustomException("Price list input should not be empty");
		}
	}
}
