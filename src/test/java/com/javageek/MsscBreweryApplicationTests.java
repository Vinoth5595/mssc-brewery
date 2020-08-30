package com.javageek;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javageek.web.controller.v2.BeerControllerV2;
import com.javageek.web.mappers.BeerMapper;
import com.javageek.web.model.v2.BeerDtoV2;
import com.javageek.web.model.v2.BeerStyleEnum;
import com.javageek.web.services.v2.BeerServiceV2;

@WebMvcTest(BeerControllerV2.class)
class MsscBreweryApplicationTests {
	
	@MockBean
	BeerServiceV2 beerServiceV2;
	
	@MockBean
	BeerMapper beerMapper;
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;

	@Test
	public void getBeerById() throws Exception{
		mockMvc.perform(
					get("/api/v2/beer/"+UUID.randomUUID().toString())
						.accept(MediaType.APPLICATION_JSON)
				).andExpect(status().isOk());
	}
	
	@Test
	public void saveNewBeer() throws Exception {
		BeerDtoV2 beerDto = BeerDtoV2.builder()
				.beerName("Beer Name 1")
				.beerStyle(BeerStyleEnum.MAX)
				.upc(123L)
				.build();
		String beerDtoJson = objectMapper.writeValueAsString(beerDto);
		
		mockMvc.perform(
					post("/api/v2/beer")
						.contentType(MediaType.APPLICATION_JSON)
						.content(beerDtoJson)
					).andExpect(status().isCreated());
	}
	
	@Test
	public void udpdateBeer() throws Exception {
		BeerDtoV2 beerDto = BeerDtoV2.builder()
				.beerName("Beer Name 1")
				.beerStyle(BeerStyleEnum.MAX)
				.upc(123L)
				.build();
		String beerDtoJson = objectMapper.writeValueAsString(beerDto);
		
		mockMvc.perform(
					post("/api/v2/beer")
						.contentType(MediaType.APPLICATION_JSON)
						.content(beerDtoJson)
					).andExpect(status().isCreated());
	}
	
	@Test
	public void updateBeer() throws Exception {
		BeerDtoV2 beerDto = BeerDtoV2.builder()
				.beerName("Beer Name 2")
				.beerStyle(BeerStyleEnum.MAX)
				.upc(124L)
				.build();
		String beerDtoJson = objectMapper.writeValueAsString(beerDto);
		
		mockMvc.perform(
					put("/api/v2/beer/"+UUID.randomUUID().toString())
						.contentType(MediaType.APPLICATION_JSON)
						.content(beerDtoJson)
					).andExpect(status().isNoContent());
	}
}
