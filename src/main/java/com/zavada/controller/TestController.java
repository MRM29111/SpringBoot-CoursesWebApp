package com.zavada.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zavada.entity.Country;
import com.zavada.service.CountryService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/generate")
@Slf4j
public class TestController {

	@Autowired CountryService countryService;
	
	@GetMapping("/countries")
	public String saveCountry() {
		log.debug("Generate Countries list");
		
		LinkedHashMap<String, String> countries = new LinkedHashMap<>();
		countries.put("Ukraine", "UA");
		countries.put("Turkey", "TR");
		countries.put("Thailand", "TH");
		countries.put("Spain", "ES");
		countries.put("Singapore", "SG");
		countries.put("Romania", "RO");
		countries.put("Poland", "PL");
		countries.put("Mexico", "MX");
		countries.put("Italy", "IT");
		countries.put("India", "IN");
		countries.put("Greece", "GR");
		countries.put("Germany", "DE");
		countries.put("France", "FR");
		countries.put("Finland", "FI");
		countries.put("Estonia", "EE");
		countries.put("Denmark", "DK");
		countries.put("Cyprus", "CY");
		countries.put("Brazil", "BR");
		
		for(Map.Entry<String, String> c : countries.entrySet()) {
			Country country = new Country();
			country.setName(c.getKey());
			country.setShortName(c.getValue());
			countryService.saveCountry(country);
		}
		
		return "redirect:/";
	}
	
}
