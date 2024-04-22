/**
 * 
 */
package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test cases for BOGO offers
 */
@SpringBootTest
class MainApplicationTest {

	static final Logger log = LoggerFactory.getLogger(MainApplicationTest.class);

	@Autowired
	private BogoService bogoService;

	/**
	 * Test method for BOGO Offer 1 - Example 1
	 */
	@Test
	void testApplyBOGOOffer1Example1() {
		List<Integer> priceList = Arrays.asList(10, 20, 30, 40, 50, 60);

		List<Integer> discountedListTest = Arrays.asList(50, 30, 10);
		List<Integer> payableListTest = Arrays.asList(60, 40, 20);

		BogoResponse resp = bogoService.applyBOGOOffer1(priceList);

		List<Integer> discountedListResp = resp.getDiscountedList();
		List<Integer> payableListResp = resp.getPayableList();

		log.info("BOGO Offer 1 example 1 tests started *");
		// Example 1
		assertTrue(discountedListResp.size() == discountedListTest.size()
				&& discountedListResp.containsAll(discountedListTest)
				&& discountedListTest.containsAll(discountedListResp));

		assertTrue(payableListResp.size() == payableListTest.size() && payableListResp.containsAll(payableListTest)
				&& payableListTest.containsAll(payableListResp));
		
		log.info("BOGO Offer 1 example 1 tests done ***");
	}
	
	/**
	 * Test method for BOGO Offer 1 - Example 2
	 */
	@Test
	void testApplyBOGOOffer1Example2() {
		List<Integer> priceList = Arrays.asList(10,20,30,40,50,50,60);

		List<Integer> discountedListTest = Arrays.asList(50, 40, 20);
		List<Integer> payableListTest = Arrays.asList(60, 50, 30, 10);

		BogoResponse resp = bogoService.applyBOGOOffer1(priceList);

		List<Integer> discountedListResp = resp.getDiscountedList();
		List<Integer> payableListResp = resp.getPayableList();

		log.info("BOGO Offer 1 example 2 tests started *");
		// Example 1
		assertTrue(discountedListResp.size() == discountedListTest.size()
				&& discountedListResp.containsAll(discountedListTest)
				&& discountedListTest.containsAll(discountedListResp));

		assertTrue(payableListResp.size() == payableListTest.size() && payableListResp.containsAll(payableListTest)
				&& payableListTest.containsAll(payableListResp));
		
		log.info("BOGO Offer 1 example 2 tests done ***");
	}

	/**
	 * Test method for BOGO Offer 2 Example 1
	 */
	@Test
	void testApplyBOGOOffer2Example1() {
		List<Integer> priceList = Arrays.asList(10,20,30,40,40,50,60,60);

		List<Integer> discountedListTest = Arrays.asList(50,40,30,10);
		List<Integer> payableListTest = Arrays.asList(60,60,40,20);

		BogoResponse resp = bogoService.applyBOGOOffer2(priceList);

		List<Integer> discountedListResp = resp.getDiscountedList();
		List<Integer> payableListResp = resp.getPayableList();

		log.info("BOGO Offer 2 example 1 tests started *");
		// Example 1
		assertTrue(discountedListResp.size() == discountedListTest.size()
				&& discountedListResp.containsAll(discountedListTest)
				&& discountedListTest.containsAll(discountedListResp));

		assertTrue(payableListResp.size() == payableListTest.size() && payableListResp.containsAll(payableListTest)
				&& payableListTest.containsAll(payableListResp));
		
		log.info("BOGO Offer 2 example 1 tests done ***");
	}
	
	/**
	 * Test method for BOGO Offer 2 Example 2
	 */
	@Test
	void testApplyBOGOOffer2Example2() {
		List<Integer> priceList = Arrays.asList(10,20,30,40,50,50,50,60 );

		List<Integer> discountedListTest = Arrays.asList(50, 40, 30, 10);
		List<Integer> payableListTest = Arrays.asList(60, 50, 50, 20);

		BogoResponse resp = bogoService.applyBOGOOffer2(priceList);

		List<Integer> discountedListResp = resp.getDiscountedList();
		List<Integer> payableListResp = resp.getPayableList();

		log.info("BOGO Offer 2 example 2 tests started *");
		// Example 1
		assertTrue(discountedListResp.size() == discountedListTest.size()
				&& discountedListResp.containsAll(discountedListTest)
				&& discountedListTest.containsAll(discountedListResp));

		assertTrue(payableListResp.size() == payableListTest.size() && payableListResp.containsAll(payableListTest)
				&& payableListTest.containsAll(payableListResp));
		
		log.info("BOGO Offer 2 example 2 tests done ***");
	}

	/**
	 * Test method for BOGO Offer 3 Example 1
	 */
	@Test
	void testApplyBOGOOffer3Example1() {
		List<Integer> priceList = Arrays.asList(10,20,30,40,40,50,60,60);

		List<Integer> discountedListTest = Arrays.asList(50,40,30,10);
		List<Integer> payableListTest = Arrays.asList(60,60,40,20);

		BogoResponse resp = bogoService.applyBOGOOffer3(priceList);

		List<Integer> discountedListResp = resp.getDiscountedList();
		List<Integer> payableListResp = resp.getPayableList();

		log.info("BOGO Offer 3 tests example 1 started *");
		// Example 1
		assertTrue(discountedListResp.size() == discountedListTest.size()
				&& discountedListResp.containsAll(discountedListTest)
				&& discountedListTest.containsAll(discountedListResp));

		assertTrue(payableListResp.size() == payableListTest.size() && payableListResp.containsAll(payableListTest)
				&& payableListTest.containsAll(payableListResp));
		
		log.info("BOGO Offer 3 tests example 1 done ***");
	}
	
	/**
	 * Test method for BOGO Offer 3 Example 2
	 */
	@Test
	void testApplyBOGOOffer3Example2() {
		List<Integer> priceList = Arrays.asList(5,5,10,20,30,40,50,50,50,60);

		List<Integer> discountedListTest = Arrays.asList(50, 40, 30, 10);
		List<Integer> payableListTest = Arrays.asList(60,50,50,20,5,5);

		BogoResponse resp = bogoService.applyBOGOOffer3(priceList);

		List<Integer> discountedListResp = resp.getDiscountedList();
		List<Integer> payableListResp = resp.getPayableList();

		log.info("BOGO Offer 3 tests example 1 started *");
		// Example 1
		assertTrue(discountedListResp.size() == discountedListTest.size()
				&& discountedListResp.containsAll(discountedListTest)
				&& discountedListTest.containsAll(discountedListResp));

		assertTrue(payableListResp.size() == payableListTest.size() && payableListResp.containsAll(payableListTest)
				&& payableListTest.containsAll(payableListResp));
		
		log.info("BOGO Offer 3 tests example 2 done ***");
	}

}
