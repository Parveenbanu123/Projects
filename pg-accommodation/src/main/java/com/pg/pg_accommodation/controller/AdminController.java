package com.pg.pg_accommodation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pg.pg_accommodation.entity.Admin;
import com.pg.pg_accommodation.entity.Owner;
import com.pg.pg_accommodation.entity.PgPlace;
import com.pg.pg_accommodation.entity.Tenant;
import com.pg.pg_accommodation.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@PostMapping("/addAdmin")
	public Admin addAdmin(@RequestBody Admin admin) {
		return adminService.addAdmin(admin);
	}
	
	@GetMapping("/getOwners")
	public List<Owner> getOwners(){
		return adminService.getAllOwner();
	}
	
	@GetMapping("/getTenant")
	public List<Tenant> getTenant(){
		return adminService.getAllTenant();
	}
	
	@GetMapping("/getPgPlace")
	public List<PgPlace> getPgPlace(){
		return adminService.getAllPgPlace();
	}
	
	@DeleteMapping("/deleteOwner/{id}")
	public void deleteOwner(@PathVariable Long id) {
		adminService.deleteOwner(id);
	}
	
	@DeleteMapping("/deleteTenant/{id}")
	public void deleteTenant(@PathVariable Long id) {
		adminService.deleteTenant(id);
	}
	
	@DeleteMapping("/deletePgPlace/{id}")
	public void deletePgPlace(@PathVariable Long id) {
		adminService.deletePgPlace(id);
	}
}
