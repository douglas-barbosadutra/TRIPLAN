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
	
	public City getAllCityByIdCity(Integer idcity) {
		return cityRepository.findById(idcity).get();
	}
	
	public CityDTO getCityDTOById(Integer idcity) {
		return ConverterCity.toDTO(cityRepository.findById(idcity).get());
	}
	
	public boolean insertCity(CityDTO cityDTO) {
		return cityRepository.save(ConverterCity.toEntity(cityDTO)) != null;
	}

	public void updateCity(Integer idcity) {
		       cityRepository.insertCity(idcity);
	}
	
	public void deleteCity(Integer idcity) {
		   cityRepository.deleteCity(idcity);
	}
	
	public void readCity(Integer idcity) {
           cityRepository.readCity(idcity);
	}

	public List<CityDTO> getListCityDTO() {
		// TODO Auto-generated method stub
		return null;
	}
}