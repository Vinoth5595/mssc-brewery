package com.javageek.web.mappers;

import org.mapstruct.Mapper;

import com.javageek.web.domain.Customer;
import com.javageek.web.model.CustomerDto;

@Mapper
public interface CustomerMapper {
	CustomerDto CustomerToCustomerDto(Customer customer);
	
	Customer CustomerDtoToCustomer(CustomerDto customerDto);
}
