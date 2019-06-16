package com.quiz.entity;

import org.junit.Test;

import com.quiz.builder.BillingSystem;

import junit.framework.Assert;

public class ItemTest {
	
	@Test
	public void shouldGetNoDiscountForNonDiscountableProduct() {
		Product product = BillingSystem.getNonDiscountableProduct();
		Item item = new Item(product, 4);
		Assert.assertEquals(8000, item.getDiscountedPrice(5), 0);
	}
	
	@Test
	public void shouldGetDiscountedPriceForDiscountableProduct() {
		Product product = BillingSystem.getDiscountableProduct();
		Item item = new Item(product, 4);
		Assert.assertEquals(3800, item.getDiscountedPrice(5), 0.1);
	}
	
	@Test
	public void shouldGetNoDiscountForZeroDiscountPercentage() {
		Product product = BillingSystem.getDiscountableProduct();
		Item item = new Item(product, 4);
		Assert.assertEquals(4000, item.getDiscountedPrice(0), 0);
		
	}
	
}
