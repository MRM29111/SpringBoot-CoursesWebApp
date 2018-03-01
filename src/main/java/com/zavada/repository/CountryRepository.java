package com.zavada.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zavada.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>{

}
