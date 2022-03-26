package com.engrenelog.engrenemc.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.engrenelog.engrenemc.domains.City;
import com.engrenelog.engrenemc.dto.CityDTO;
import com.engrenelog.engrenemc.services.CityService;

@RestController
@RequestMapping(value="/cities")
public class CityResource {

	@Autowired
	private CityService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CityDTO>> findAll(){
		List<City> list = service.findAll();
		List<CityDTO> listDto = list.stream().map(obj -> new CityDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CityDTO>> findCitiesByStates(){
		List<City> list = service.findCity(null);
		List<CityDTO> listDto = list.stream().map(obj -> new CityDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}