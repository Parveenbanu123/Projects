package com.pg.pg_accommodation.service.impl;

import org.springframework.stereotype.Service;

import com.pg.pg_accommodation.entity.Owner;
import com.pg.pg_accommodation.repository.OwnerRepository;
import com.pg.pg_accommodation.service.OwnerService;

@Service
public class OwnerServiceImpl implements OwnerService{

	private final OwnerRepository repository;
	
	public OwnerServiceImpl(OwnerRepository repository) {
		this.repository = repository;
	}

	@Override
	public Owner getOwnerById(Long ownerId) {
		// TODO Auto-generated method stub
		return repository.findById(ownerId).orElseThrow();
	}

	@Override
	public Owner saveOwner(Owner owner) {
		// TODO Auto-generated method stub
		return repository.save(owner);
	}

}
