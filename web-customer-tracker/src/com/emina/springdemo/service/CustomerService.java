package com.emina.springdemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emina.springdemo.entity.Customer;

@Service
public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer c);

	public Customer getCustomer(int id);

}
