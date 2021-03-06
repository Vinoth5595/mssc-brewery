package com.javageek.web.controller.v2;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javageek.web.mappers.BeerMapper;
import com.javageek.web.model.v2.BeerDtoV2;
import com.javageek.web.services.v2.BeerServiceV2;

@Validated
@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {
	
	@Autowired
	BeerMapper beerMapper;
	
	private final BeerServiceV2 beerServiceV2;
	
	public BeerControllerV2(BeerServiceV2 beerServiceV2) {
		this.beerServiceV2 = beerServiceV2;
	}

	@GetMapping({"/{beerId}"})
	public ResponseEntity<BeerDtoV2> getBeer(@NotNull @PathVariable UUID beerId){
		return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity handlePost(@Valid @NotNull @RequestBody BeerDtoV2 beerDto) {
		BeerDtoV2 saveDto = beerServiceV2.saveNewBeer(beerDto);
		HttpHeaders headers = new  HttpHeaders();
		//headers.add("Location", "/api/v1/beer/"+saveDto.getId().toString());
		return new ResponseEntity(headers,HttpStatus.CREATED);
	}
	
	@PutMapping({"/{beerId}"})
	public ResponseEntity handleUpdate(@PathVariable @NotNull UUID beerId,@Valid @NotNull @RequestBody BeerDtoV2 beerDto) {
		beerServiceV2.updateBeer(beerId, beerDto);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping({"/{beerId}"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable UUID beerId) {
		beerServiceV2.deleteById(beerId);
	}
	
}
