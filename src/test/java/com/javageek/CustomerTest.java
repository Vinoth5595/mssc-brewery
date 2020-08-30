package com.javageek;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javageek.web.controller.CustomerController;
import com.javageek.web.model.CustomerDto;
import com.javageek.web.services.CustomerService;

@WebMvcTest(CustomerController.class)
public class CustomerTest {

	@MockBean
	CustomerService customerService;
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	public void getBeerById() throws Exception{
		mockMvc.perform(
					get("/api/v1/customer/"+UUID.randomUUID().toString())
						.accept(MediaType.APPLICATION_JSON)
				).andExpect(status().isOk());
	}
	
	@Test
	public void saveNewCustomer() throws Exception {
		CustomerDto customerDto = CustomerDto.builder()
				.customerName("John Doe")
				.build();
		String beerDtoJson = objectMapper.writeValueAsString(customerDto);

		mockMvc.perform(
					post("/api/v1/customer")
						.contentType(MediaType.APPLICATION_JSON)
						.content(beerDtoJson)
					).andExpect(status().isCreated());
	}
}
