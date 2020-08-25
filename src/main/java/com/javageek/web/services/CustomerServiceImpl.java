package com.javageek.web.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.javageek.web.model.CustomerDto;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDto getCustomerById(UUID customerId) {
		return CustomerDto.builder().customerId(UUID.randomUUID())
				.customerName("John Doe").build();
	}

	@Override
	public CustomerDto saveCustomer(CustomerDto customerDto) {
		return CustomerDto.builder().customerId(UUID.randomUUID()).customerName(customerDto.getCustomerName()).build();
	}

	@Override
	public void updateCustomerById(UUID customerId, CustomerDto customerDto) {
		//TODO - Code to update Customer DTO.
	}

	@Override
	public void deleteById(UUID customerId) {
		//TODO - Code to delete customer by Id.
	}

}
