package it.contrader.services;

import java.util.ArrayList;
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

	public List<CityDTO> getListaCityDTO() {
		return ConverterCity.toListDTO((List<City>) cityRepository.findAll());
	}

	public CityDTO getCityDTOById(Integer id) {
		return ConverterCity.toDTO(cityRepository.findById(id).get()); 
	}


	public boolean insertCity(CityDTO cityDTO) {
		return cityRepository.save(ConverterCity.toEntity(cityDTO)) != null;
	}

	public boolean updateCity(CityDTO cityDTO) {
		return cityRepository.save(ConverterCity.toEntity(cityDTO)) != null;
	}
	
	public void deleteCityById(Integer id) {
		cityRepository.deleteById(id);
	}
	
	public List<CityDTO> findCityDTOByNameCity(String namecity) {
		
		final List<City> list = cityRepository.findAllByNamecity(namecity);
		final List<CityDTO> cityDTOs = new ArrayList<>();
		list.forEach(i -> cityDTOs.add(ConverterCity.toDTO(i)));
		return cityDTOs;
		
	
	}
}
