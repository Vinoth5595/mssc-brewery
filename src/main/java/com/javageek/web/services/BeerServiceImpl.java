package com.javageek.web.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.javageek.web.model.BeerDto;

import lombok.extern.slf4j.Slf4j;

@Deprecated
@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

	@Override
	public BeerDto getBeerById(UUID beerId) {
		return BeerDto.builder().id(UUID.randomUUID()).beerName("Beer 3").beerStyle("Beer Style 3").build();
	}

	@Override
	public BeerDto saveNewBeer(BeerDto beerDto) {
		return BeerDto.builder().id(UUID.randomUUID()).build();
	}

	@Override
	public void updateBeer(UUID beerId, BeerDto beerDto) {
		// TODO - to write update Beer DTO Code.
	}

	@Override
	public void deleteById(UUID beerId) {
		log.debug("Deleted :" + beerId.toString());
	}

}
