package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.CityDTO;
import it.contrader.model.City;

public class ConverterCity {

	public static CityDTO toDTO(City city) {
		CityDTO cityDTO = null;
		if (city != null) {
			cityDTO = new CityDTO();
			cityDTO.setIdCity(city.getIdCity());
			cityDTO.setNamecity(city.getNamecity());
		}
		return cityDTO;
	}

	public static City toEntity(CityDTO cityDTO) {
		City city = null;
		if (cityDTO != null) {
			city = new City();
			city.setIdCity(cityDTO.getIdCity());
			city.setNamecity(cityDTO.getNamecity());
		}
		return city;
	}

	public static List<CityDTO> toListDTO(List<City> list) {
		List<CityDTO> listCityDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (City city : list) {
				listCityDTO.add(ConverterCity.toDTO(city));
			}
		}
		return listCityDTO;
	}

	public static List<City> toListEntity(List<CityDTO> listCityDTO) {
		List<City> list = new ArrayList<>();
		if (!listCityDTO.isEmpty()) {
			for (CityDTO cityDTO : listCityDTO) {
				list.add(ConverterCity.toEntity(cityDTO));
			}
		}
		return list;
	}
}
