package com.quiz.entity;

import org.junit.Test;

import com.quiz.builder.BillingSystem;

import junit.framework.Assert;

public class CustomerTest {
	
	@Test
	public void shouldReturnTrueForMoreThanTwoYearOldRegistration() {
		Customer customer = BillingSystem.getCustomerWithMoreThanTwoYearOldRegistration();
		Assert.assertTrue(customer.isAvailableForLoyaltyDiscount());
	}
	
	@Test
	public void shouldReturnFalseForNonEmployee() {
		Customer customer = BillingSystem.getAffiliateCustomer();
		Assert.assertFalse(customer.isAvailableForLoyaltyDiscount());
	}
	
	@Test
	public void shouldReturnFalseForLessThanTwoYearOldRegistration() {
		Customer customer = BillingSystem.getCustomerWithLessThanTwoYearOldRegistration();
		Assert.assertFalse(customer.isAvailableForLoyaltyDiscount());
	}
}
