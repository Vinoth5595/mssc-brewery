package com.javageek.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javageek.web.model.CustomerDto;
import com.javageek.web.services.CustomerService;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping({ "/{customerId}" })
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerId) {
		return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity createNewCustomer(@Valid @RequestBody CustomerDto customerDto) {
		CustomerDto saveDto = customerService.saveCustomer(customerDto);

		HttpHeaders header = new HttpHeaders();
		//header.add("Location", "/api/v1/customer/" + saveDto.getCustomerId().toString());
		return new ResponseEntity(header, HttpStatus.CREATED);
	}

	@PutMapping({ "/{customerId}" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateCustomer(@PathVariable UUID customerId, @Valid @RequestBody CustomerDto customerDto) {
		customerService.updateCustomerById(customerId, customerDto);
	}
	
	@DeleteMapping({ "/{customerId}" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable UUID customerId) {
		customerService.deleteById(customerId);
	}
	
}
