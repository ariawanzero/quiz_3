package com.quiz.service;

import java.util.List;

import com.quiz.entity.Customer;
import com.quiz.entity.Item;

public interface BillCalculator {
	
	double calculateTotalPayableAmount(Customer customer, List<Item> items);
	
}
