package com.javageek.web.services;

import java.util.UUID;

import com.javageek.web.model.BeerDto;

@Deprecated
public interface BeerService {
	BeerDto getBeerById(UUID beerId);

	BeerDto saveNewBeer(BeerDto beerDto);

	void updateBeer(UUID beerId, BeerDto beerDto);

	void deleteById(UUID beerId);
}
