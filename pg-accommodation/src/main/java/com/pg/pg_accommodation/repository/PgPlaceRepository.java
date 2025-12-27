package com.pg.pg_accommodation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pg.pg_accommodation.entity.AvailabilityStatus;
import com.pg.pg_accommodation.entity.PgPlace;

public interface PgPlaceRepository extends JpaRepository<PgPlace, Long>{

	List<PgPlace> findByCityAndStatus(String city,AvailabilityStatus status);
	List<PgPlace> findByLocalityAndStatus(String locality,AvailabilityStatus status);
	List<PgPlace> findByOwnerId(Long ownerId);
}
