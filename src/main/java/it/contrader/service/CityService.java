package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.CityConverter;
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
		return CityConverter.toListDTO((List<City>) cityRepository.findAll());
	}

	public CityDTO getCityDTOById(Integer id) {
		return CityConverter.toDTO(cityRepository.findById(id).get()); 
	}


	public boolean insertCity(CityDTO cityDTO) {
		return cityRepository.save(CityConverter.toEntity(cityDTO)) != null;
	}

	public boolean updateCity(CityDTO cityDTO) {
		return cityRepository.save(CityConverter.toEntity(cityDTO)) != null;
	}
	
	public void deleteCityById(Integer id) {
		cityRepository.deleteById(id);
	}
	
	public List<CityDTO> findAllCityDTO() {

		List<City> list = cityRepository.findAll();
		List<CityDTO> cityDTOs = new ArrayList<>();
		list.forEach(i -> cityDTOs.add(CityConverter.toDTO(i)));
		return cityDTOs;
	}
}
