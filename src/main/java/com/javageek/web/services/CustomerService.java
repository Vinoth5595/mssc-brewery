package com.javageek.web.services;

import java.util.UUID;

import com.javageek.web.model.CustomerDto;

public interface CustomerService {
	CustomerDto getCustomerById(UUID customerId);

	CustomerDto saveCustomer(CustomerDto customerDto);

	void updateCustomerById(UUID customerId, CustomerDto customerDto);

	void deleteById(UUID customerId);
}
