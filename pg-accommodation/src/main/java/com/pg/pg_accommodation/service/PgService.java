package com.pg.pg_accommodation.service;

import java.util.List;

import com.pg.pg_accommodation.entity.PgPlace;

public interface PgService {
	List<PgPlace> getPgByCity(String city);
	List<PgPlace> getPgByLocality(String locality);
	PgPlace getPgDetails(Long id);
	PgPlace addPgPlace(PgPlace place);
	List<PgPlace> getOwnerPlaces(Long ownerId);
	PgPlace changeStatus(Long id);
}
