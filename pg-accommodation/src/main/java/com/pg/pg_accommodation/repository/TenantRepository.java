package com.pg.pg_accommodation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pg.pg_accommodation.entity.Tenant;

public interface TenantRepository extends JpaRepository<Tenant, Long>{

}
