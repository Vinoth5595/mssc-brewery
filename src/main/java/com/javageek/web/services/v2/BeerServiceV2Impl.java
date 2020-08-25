package com.javageek.web.services.v2;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.javageek.web.model.BeerDto;
import com.javageek.web.model.v2.BeerDtoV2;
import com.javageek.web.model.v2.BeerStyleEnum;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {

	@Override
	public BeerDtoV2 getBeerById(UUID beerId) {
		return BeerDtoV2.builder().id(UUID.randomUUID()).beerName("Beer 3").beerStyle(BeerStyleEnum.MAX).build();
	}

	@Override
	public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {
		return BeerDtoV2.builder().id(UUID.randomUUID()).build();
	}

	@Override
	public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {
		// TODO - to write update Beer DTO Code.
	}

	@Override
	public void deleteById(UUID beerId) {
		log.debug("Deleted :" + beerId.toString());
	}

}
