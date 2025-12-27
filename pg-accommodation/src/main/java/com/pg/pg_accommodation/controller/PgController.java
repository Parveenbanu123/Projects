package com.pg.pg_accommodation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pg.pg_accommodation.entity.PgPlace;
import com.pg.pg_accommodation.service.PgService;

@RestController
@RequestMapping("/pg")
public class PgController {

	private final PgService service;

	public PgController(PgService service) {
		this.service = service;
	}
	
	@GetMapping("/{city}")
	public List<PgPlace> getByCity(@PathVariable String city){
		return service.getPgByCity(city);
	}
	
	@GetMapping("/locality/{locality}")
	public List<PgPlace> getByLocation(@PathVariable String locality){
		return service.getPgByLocality(locality);
	}
	
	@GetMapping("/details/{id}")
	public PgPlace getDetails(@PathVariable Long id) {
		return service.getPgDetails(id);
	}
}
