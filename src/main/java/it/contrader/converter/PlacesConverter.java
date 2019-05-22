package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.PlacesDTO;
import it.contrader.model.Places;

@Component
public class PlacesConverter {

	@Autowired
	private static CityConverter cityConverter;
	

	public static Places toEntity(PlacesDTO placesDTO) {
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

	
	
	public static PlacesDTO toDTO(Places places) {
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
	public static List<PlacesDTO> toListDTO(List<Places> list) {
		List<PlacesDTO> listPlacesDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Places places : list) {
				listPlacesDTO.add(PlacesConverter.toDTO(places));
			}
		}
		return listPlacesDTO;
	}

	public static List<Places> toListEntity(List<PlacesDTO> listPlacesDTO) {
		List<Places> list = new ArrayList<>();
		if (!listPlacesDTO.isEmpty()) {
			for (PlacesDTO placesDTO : listPlacesDTO) {
				list.add(PlacesConverter.toEntity(placesDTO));
			}
		}
		return list;
	}
}