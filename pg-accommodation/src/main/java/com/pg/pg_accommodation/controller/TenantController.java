package com.pg.pg_accommodation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pg.pg_accommodation.entity.Tenant;
import com.pg.pg_accommodation.service.TenantService;

@RestController
@RequestMapping("/tenant")
public class TenantController {

	@Autowired
	private TenantService service;
	
	@PostMapping("/addTenant")
	public Tenant addTenant(@RequestBody Tenant tenant) {
		return service.addTenant(tenant);
	}
	
	@GetMapping("/getTenant/{id}")
	public Tenant getTenantById(@PathVariable Long id) {
		return service.getTenantById(id);
	}
	
	@DeleteMapping("/deleteTenant/{id}")
	public void deleteTenantById(@PathVariable Long id) {
		service.deleteTenantById(id);
	}
}
