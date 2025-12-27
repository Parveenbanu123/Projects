package com.pg.pg_accommodation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pg.pg_accommodation.entity.Owner;
import com.pg.pg_accommodation.entity.PgPlace;
import com.pg.pg_accommodation.service.OwnerService;
import com.pg.pg_accommodation.service.PgService;

@RestController
@RequestMapping("/owner/places")
public class OwnerController {

	@Autowired
	private PgService pgservice;
	@Autowired
	private OwnerService ownerService;
	
	@PostMapping("/register")
	public Owner registerOwner(@RequestBody Owner owner) {
		return ownerService.saveOwner(owner);
	}
	
	@PostMapping("/add")
	public PgPlace addPlace(@RequestBody PgPlace place) {
		return pgservice.addPgPlace(place);
	}

	
	@GetMapping
	public List<PgPlace> ownerPlaces(@RequestParam Long ownerId){
		return pgservice.getOwnerPlaces(ownerId);
	}
	@PutMapping("/{id}")
	public PgPlace changeStatus(@PathVariable Long id) {
		return pgservice.changeStatus(id);
	}
	
	
	
}
