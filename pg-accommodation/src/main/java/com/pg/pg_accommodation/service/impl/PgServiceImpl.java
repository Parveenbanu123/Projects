package com.pg.pg_accommodation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pg.pg_accommodation.entity.AvailabilityStatus;
import com.pg.pg_accommodation.entity.PgPlace;
import com.pg.pg_accommodation.exception.ResourceNotFoundException;
import com.pg.pg_accommodation.repository.PgPlaceRepository;
import com.pg.pg_accommodation.service.PgService;

@Service
public class PgServiceImpl implements PgService{

	@Autowired
	private PgPlaceRepository repository;
	

	@Override
	public List<PgPlace> getPgByCity(String city) {
		// TODO Auto-generated method stub
		return repository.findByCityAndStatus(city, AvailabilityStatus.AVAILABLE);
	}

	@Override
	public List<PgPlace> getPgByLocality(String locality) {
		// TODO Auto-generated method stub
		return repository.findByLocalityAndStatus(locality, AvailabilityStatus.AVAILABLE);
	}

	@Override
	public PgPlace getPgDetails(Long id) {
		// TODO Auto-generated method stub
		PgPlace place=repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("PG Place not found with ID:"+id));
		place.setVisitorCount(place.getVisitorCount()+1);
		return repository.save(place);
	}

	@Override
	public PgPlace addPgPlace(PgPlace place) {
		// TODO Auto-generated method stub
		place.setStatus(AvailabilityStatus.AVAILABLE);
		return repository.save(place);
	}

	@Override
	public List<PgPlace> getOwnerPlaces(Long ownerId) {
		// TODO Auto-generated method stub
		return repository.findByOwnerId(ownerId);
	}

	@Override
	public PgPlace changeStatus(Long id) {
		// TODO Auto-generated method stub
		PgPlace place=repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("PG Place not found with ID:"+id));
		place.setStatus(place.getStatus()==AvailabilityStatus.AVAILABLE?AvailabilityStatus.OCCUPIED:AvailabilityStatus.AVAILABLE);
		return repository.save(place);
	}

}
