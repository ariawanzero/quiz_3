package com.quiz.builder;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import com.quiz.entity.Customer;
import com.quiz.entity.CustomerType;
import com.quiz.entity.Item;
import com.quiz.entity.Product;

public class BillingSystem {
	
	private static final int CUSTOMER_LOYALTY_TIME_PERIOD_IN_YRS = 2;
	
	public static Product getDiscountableProduct() {
		Product product = new Product();
		product.setSku("SBE11111");
		product.setName("Hologram");
		product.setDiscountable(Boolean.TRUE);
		product.setPrice(1000);
		
		return product;
	}
	
	public static Product getNonDiscountableProduct() {
		Product product = new Product();
		product.setSku("SBE222222");
		product.setName("Porstek");
		product.setDiscountable(Boolean.FALSE);
		product.setPrice(2000);
		
		return product;
	}
	
	public static Customer getAffiliateCustomer() {
		Customer customer = new Customer(CustomerType.AFFILIATE, "dummyCust1", "Ray", new DateTime().minusYears(3));
		return customer;
	}
	
	public static Customer getEmployeeCustomer() {
		Customer customer = new Customer(CustomerType.EMPLOYEE, "dummyCust2", "Nick", new DateTime().minusYears(3));
		return customer;
	}
	
	public static Customer getCustomerWithMoreThanTwoYearOldRegistration() {
		Customer customer = new Customer(CustomerType.CUSTOMER, "dummyCust3", "Peter", new DateTime().minusYears(CUSTOMER_LOYALTY_TIME_PERIOD_IN_YRS).minusDays(1));
		return customer;
	}
	
	public static Customer getCustomerWithLessThanTwoYearOldRegistration() {
		Customer customer = new Customer(CustomerType.CUSTOMER, "dummyCust4", "Gal", new DateTime().minusYears(CUSTOMER_LOYALTY_TIME_PERIOD_IN_YRS).plusDays(1));
		return customer;
	}
	
	public static Item getItemWithDiscountableProduct(int quantity) {
		return new Item(getDiscountableProduct(), quantity);
	}
	
	public static Item getItemWithNonDiscountableProduct(int quantity) {
		return new Item(getNonDiscountableProduct(), quantity);
	}
	
	public static List<Item> getItemListWithMultipleProducts() {
		List<Item> items = new ArrayList<Item>();
		items.add(getItemWithDiscountableProduct(10));
		items.add(getItemWithNonDiscountableProduct(5));
		return items;
	}
}
