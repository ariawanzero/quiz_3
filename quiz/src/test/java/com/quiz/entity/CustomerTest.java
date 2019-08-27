package com.quiz.entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.quiz.builder.BillingSystem;

public class CustomerTest {
	
	@Test
	public void shouldReturnTrueForMoreThanTwoYearOldRegistration() {
		Customer customer = BillingSystem.getCustomerWithMoreThanTwoYearOldRegistration();
		assertTrue(customer.isAvailableForLoyaltyDiscount());
	}
	
	@Test
	public void shouldReturnFalseForNonEmployee() {
		Customer customer = BillingSystem.getAffiliateCustomer();
		assertFalse(customer.isAvailableForLoyaltyDiscount());
	}
	
	@Test
	public void shouldReturnFalseForLessThanTwoYearOldRegistration() {
		Customer customer = BillingSystem.getCustomerWithLessThanTwoYearOldRegistration();
		assertFalse(customer.isAvailableForLoyaltyDiscount());
	}
}
