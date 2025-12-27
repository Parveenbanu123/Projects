package com.pg.pg_accommodation.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pg.pg_accommodation.entity.Tenant;
import com.pg.pg_accommodation.repository.TenantRepository;
import com.pg.pg_accommodation.service.TenantService;

@Service
public class TenantServiceImpl implements TenantService{

	@Autowired
	TenantRepository repository;
	@Override
	public Tenant addTenant(Tenant tenant) {
		// TODO Auto-generated method stub
		return repository.save(tenant);
	}

	@Override
	public Tenant getTenantById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElseThrow();
		
	}

	@Override
	public void deleteTenantById(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
