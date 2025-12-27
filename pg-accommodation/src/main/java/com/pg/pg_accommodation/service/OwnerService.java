package com.pg.pg_accommodation.service;

import com.pg.pg_accommodation.entity.Owner;

public interface OwnerService {
	Owner getOwnerById(Long ownerId);
	Owner saveOwner(Owner owner);
}
