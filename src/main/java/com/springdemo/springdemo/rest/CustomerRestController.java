package com.springdemo.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.springdemo.entity.Customer;
import com.springdemo.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	@Autowired
	CustomerService theCustomerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers() {


		return theCustomerService.getCustomers();

	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		
		
		return theCustomerService.getCustomer(customerId);
		
	}

}
