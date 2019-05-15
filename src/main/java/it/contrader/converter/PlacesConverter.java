package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.PlacesDTO;
import it.contrader.model.Places;

@Component
public class PlacesConverter extends AbstractConverter<Places, PlacesDTO> {

	@Autowired
	private CityConverter cityConverter;
	
	@Override
	public Places toEntity(PlacesDTO placesDTO) {
		Places places = new Places();
		if(placesDTO!=null) {
			places.setIdPlaces(placesDTO.getIdPlaces());
			places.setNameplaces(placesDTO.getNameplaces());
			places.setCityplaces(placesDTO.getCityplaces());
			places.setLatitude(placesDTO.getLatitude());
			places.setLongitude(placesDTO.getLongitude());
			places.setType(placesDTO.getType());
			places.setCity(cityConverter.toEntity(placesDTO.getCityDTO()));
			
		}
		return places;
	}

	
	@Override
	public PlacesDTO toDTO(Places places) {
		PlacesDTO placesDTO = new PlacesDTO();
		if(places!=null) {
			placesDTO.setIdPlaces(places.getIdPlaces());
			placesDTO.setNameplaces(places.getNameplaces());
			placesDTO.setCityplaces(places.getCityplaces());
		    placesDTO.setLatitude(places.getLatitude());
			placesDTO.setLongitude(places.getLongitude());
			placesDTO.setType(places.getType());
			placesDTO.setCityDTO(cityConverter.toDTO(places.getCity()));
		
		
		
		}
		return placesDTO;
	}
}
