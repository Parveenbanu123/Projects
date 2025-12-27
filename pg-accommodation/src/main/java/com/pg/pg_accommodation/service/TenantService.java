package com.pg.pg_accommodation.service;


import com.pg.pg_accommodation.entity.Tenant;

public interface TenantService {
	Tenant addTenant(Tenant tenant);
	Tenant getTenantById(Long id);
	public void deleteTenantById(Long id);
}
