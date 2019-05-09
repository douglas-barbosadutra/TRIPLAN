package it.contrader.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterCity;
import it.contrader.dao.CityRepository;
import it.contrader.dto.CityDTO;

import it.contrader.model.City;

@Service
public class CityService {

	private final CityRepository cityRepository;

	@Autowired
	public CityService(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}
	
	public List<CityDTO> getAllCityByIdCity(Integer idcity) {
		return cityRepository.findAllCityByIdCity(idcity);
	}
	
	public CityDTO getCityDTOById(Integer idcity) {
		return ConverterCity.toDTO(cityRepository.findById(idcity).get());
	}
	
	public void insertCity(CityDTO cityDTO) {
		 cityRepository.save(ConverterCity.toEntity(cityDTO));
	}

	public void updateCity(CityDTO cityDTO ) {
		      cityRepository.save(ConverterCity.toEntity(cityDTO));
	}
	
	public void deleteCity(Integer idcity) {
		   cityRepository.deleteById(idcity);
	}
	
	

	
	
}