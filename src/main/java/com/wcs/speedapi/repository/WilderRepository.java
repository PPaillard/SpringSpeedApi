package com.wcs.speedapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcs.speedapi.model.Wilder;

@Repository
public interface WilderRepository extends JpaRepository<Wilder, Long>{

	Wilder findByFirstname(String name);
}
