package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.CityDTO;
import it.contrader.model.City;

@Component
public class CityConverter extends AbstractConverter<City, CityDTO> {

	
	
	@Override
	public City toEntity(CityDTO cityDTO) {
		City city = new City();
		if(cityDTO!=null) {
			city.setIdCity(cityDTO.getIdCity());
			city.setNamecity(cityDTO.getNamecity());
			city.setState(cityDTO.getState());
			
			
		}
		return city;
	}

	
	@Override
	public CityDTO toDTO(City city) {
		CityDTO cityDTO = new CityDTO();
		if(city!=null) {
			cityDTO.setIdCity(city.getIdCity());
			cityDTO.setNamecity(city.getNamecity());
			cityDTO.setState(city.getState());
			
		}
		return cityDTO;
	}
}
