package com.javageek.web.mappers;

import com.javageek.web.domain.Customer;
import com.javageek.web.domain.Customer.CustomerBuilder;
import com.javageek.web.model.CustomerDto;
import com.javageek.web.model.CustomerDto.CustomerDtoBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-30T23:46:58+0530",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDto CustomerToCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDtoBuilder customerDto = CustomerDto.builder();

        customerDto.customerId( customer.getCustomerId() );
        customerDto.customerName( customer.getCustomerName() );

        return customerDto.build();
    }

    @Override
    public Customer CustomerDtoToCustomer(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        CustomerBuilder customer = Customer.builder();

        customer.customerId( customerDto.getCustomerId() );
        customer.customerName( customerDto.getCustomerName() );

        return customer.build();
    }
}
