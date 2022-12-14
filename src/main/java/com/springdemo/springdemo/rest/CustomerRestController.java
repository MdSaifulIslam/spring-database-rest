package com.springdemo.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		
		Customer customer = theCustomerService.getCustomer(customerId);
		
		if(customer == null) {
			throw new CustomerNotFoundException("Customer id[" + customerId + "] not found");
		}
		
		return customer;
		
	}
	@PostMapping("/customers")
	public Customer saveCustomer(@RequestBody Customer customer) {
		
		customer.setId(0);
		
		theCustomerService.saveCustomer(customer);
		
		return customer;
		
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		
		theCustomerService.saveCustomer(customer);
		
		return customer;
		
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		
		theCustomerService.deleteCustomer(customerId);
		
		return "Deleted customer successfully, id[" + customerId + "]";
		
	}

}
