package com.zavada.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zavada.entity.Country;
import com.zavada.repository.CountryRepository;
import com.zavada.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired private CountryRepository countryRepository;
	
	@Override
	public void saveCountry(Country country) {
		countryRepository.save(country);
	}

	@Override
	public List<Country> findAllCountries() {
		return countryRepository.findAll();
	}

	@Override
	public Country findCountryById(int id) {
		return countryRepository.findOne(id);
	}

}
