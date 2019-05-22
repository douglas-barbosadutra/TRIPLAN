package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import it.contrader.dto.CityDTO;
import it.contrader.model.City;

@Component
public class CityConverter {

	
	
	public static City toEntity(CityDTO cityDTO) {
		City city = new City();
		if(cityDTO!=null) {
			city.setIdCity(cityDTO.getIdCity());
			city.setNamecity(cityDTO.getNamecity());
			city.setState(cityDTO.getState());
			
			
		}
		return city;
	}
	
	public static CityDTO toDTO(City city) {
		CityDTO cityDTO = new CityDTO();
		if(city!=null) {
			cityDTO.setIdCity(city.getIdCity());
			cityDTO.setNamecity(city.getNamecity());
			cityDTO.setState(city.getState());
			
		}
		return cityDTO;
	}
	
	public static List<CityDTO> toListDTO(List<City> list) {
		List<CityDTO> listCityDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (City city : list) {
				listCityDTO.add(CityConverter.toDTO(city));
			}
		}
		return listCityDTO;
	}

	public static List<City> toListEntity(List<CityDTO> listCityDTO) {
		List<City> list = new ArrayList<>();
		if (!listCityDTO.isEmpty()) {
			for (CityDTO cityDTO : listCityDTO) {
				list.add(CityConverter.toEntity(cityDTO));
			}
		}
		return list;
	}
}
