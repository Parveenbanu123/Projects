package com.pg.pg_accommodation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pg.pg_accommodation.entity.Admin;
import com.pg.pg_accommodation.entity.Owner;
import com.pg.pg_accommodation.entity.PgPlace;
import com.pg.pg_accommodation.entity.Tenant;
import com.pg.pg_accommodation.exception.ResourceNotFoundException;
import com.pg.pg_accommodation.repository.AdminRepository;
import com.pg.pg_accommodation.repository.OwnerRepository;
import com.pg.pg_accommodation.repository.PgPlaceRepository;
import com.pg.pg_accommodation.repository.TenantRepository;
import com.pg.pg_accommodation.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminRepository adminrepo;
	@Autowired
	OwnerRepository ownerrepo;
	@Autowired
	TenantRepository tenantrepo;
	@Autowired
	PgPlaceRepository pgPlacerepo;
	@Override
	public Admin addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminrepo.save(admin);
	}

	@Override
	public List<Owner> getAllOwner() {
		// TODO Auto-generated method stub
		return ownerrepo.findAll();
	}

	@Override
	public List<Tenant> getAllTenant() {
		// TODO Auto-generated method stub
		return tenantrepo.findAll();
	}

	@Override
	public List<PgPlace> getAllPgPlace() {
		// TODO Auto-generated method stub
		return pgPlacerepo.findAll();
	}

	@Override
	public void deleteOwner(Long ownerId) {
		// TODO Auto-generated method stub
		ownerrepo.findById(ownerId).orElseThrow(()-> new ResourceNotFoundException("Owner Not Found"));
		ownerrepo.deleteById(ownerId);
	}

	@Override
	public void deleteTenant(Long tenantId) {
		// TODO Auto-generated method stub
		tenantrepo.findById(tenantId).orElseThrow(()->new ResourceNotFoundException("Tenant Not Found"));
		tenantrepo.deleteById(tenantId);
	}

	@Override
	public void deletePgPlace(Long pgId) {
		// TODO Auto-generated method stub
		pgPlacerepo.findById(pgId).orElseThrow(()->new ResourceNotFoundException("PG Not Found"));
		pgPlacerepo.deleteById(pgId);
	}

}
