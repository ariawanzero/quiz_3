package com.quiz.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.quiz.builder.BillingSystem;
import com.quiz.entity.Customer;
import com.quiz.entity.Item;

public class BillCalculatorImplTest {
	
	private BillCalculator billCalculatorService;
	private List<Item> items;
	
	@Before
	public void setUp() {
		billCalculatorService = new BillCalculatorImpl();
		items = BillingSystem.getItemListWithMultipleProducts();
	}
	
	@Test
	public void shouldCalculateBillForDiscountEligibleCustomer() {
		Customer customer = BillingSystem.getCustomerWithMoreThanTwoYearOldRegistration();
		assertEquals(18525, billCalculatorService.calculateTotalPayableAmount(customer, items), 0);
	}
	
	@Test
	public void shouldCalculateBillForNonEligibleCustomer() {
		Customer customer = BillingSystem.getCustomerWithLessThanTwoYearOldRegistration();
		assertEquals(19000, billCalculatorService.calculateTotalPayableAmount(customer, items), 0);
	}
	
	@Test
	public void shouldCalculateBillforAffiliateCustomer() {
		Customer affiliateCustomer = BillingSystem.getAffiliateCustomer();
		assertEquals(18050, billCalculatorService.calculateTotalPayableAmount(affiliateCustomer, items), 0);
	}
	
	@Test
	public void shouldCalculateBillForEmployeeCustomer() {
		Customer employeeCustomer = BillingSystem.getEmployeeCustomer();
		assertEquals(16150, billCalculatorService.calculateTotalPayableAmount(employeeCustomer, items), 0);
	}
}
