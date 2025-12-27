package com.pg.pg_accommodation.service;

import java.util.List;

import com.pg.pg_accommodation.entity.Admin;
import com.pg.pg_accommodation.entity.Owner;
import com.pg.pg_accommodation.entity.PgPlace;
import com.pg.pg_accommodation.entity.Tenant;

public interface AdminService {
	Admin addAdmin(Admin admin);
	List<Owner> getAllOwner();
	List<Tenant> getAllTenant();
	List<PgPlace> getAllPgPlace();
	void deleteOwner(Long ownerId);
	void deleteTenant(Long tenantId);
	void deletePgPlace(Long pgId);
}
