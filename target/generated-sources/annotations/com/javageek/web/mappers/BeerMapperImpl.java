package com.javageek.web.mappers;

import com.javageek.web.domain.Beer;
import com.javageek.web.domain.Beer.BeerBuilder;
import com.javageek.web.model.v2.BeerDtoV2;
import com.javageek.web.model.v2.BeerDtoV2.BeerDtoV2Builder;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-30T23:46:58+0530",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
@Component
public class BeerMapperImpl implements BeerMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public BeerDtoV2 BeerToBeerDto(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDtoV2Builder beerDtoV2 = BeerDtoV2.builder();

        beerDtoV2.id( beer.getId() );
        beerDtoV2.beerName( beer.getBeerName() );
        beerDtoV2.beerStyle( beer.getBeerStyle() );
        beerDtoV2.upc( beer.getUpc() );
        beerDtoV2.createdDateTime( dateMapper.asOffsetDateTime( beer.getCreatedDateTime() ) );

        return beerDtoV2.build();
    }

    @Override
    public Beer BeerDtoToBeer(BeerDtoV2 beerDto) {
        if ( beerDto == null ) {
            return null;
        }

        BeerBuilder beer = Beer.builder();

        beer.id( beerDto.getId() );
        beer.beerName( beerDto.getBeerName() );
        beer.beerStyle( beerDto.getBeerStyle() );
        beer.upc( beerDto.getUpc() );
        beer.createdDateTime( dateMapper.asTimestamp( beerDto.getCreatedDateTime() ) );

        return beer.build();
    }
}
