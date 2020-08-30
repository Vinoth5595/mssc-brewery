package com.javageek.web.mappers;

import org.mapstruct.Mapper;

import com.javageek.web.domain.Beer;
import com.javageek.web.model.v2.BeerDtoV2;

@Mapper (uses = DateMapper.class)
public interface BeerMapper {
	
	BeerDtoV2 BeerToBeerDto(Beer beer);
	
	Beer BeerDtoToBeer(BeerDtoV2 beerDto);
}
