package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.PlacesDTO;
import it.contrader.model.Places;

public class ConverterPlaces {

	public static PlacesDTO toDTO(Places places) {
		PlacesDTO placesDTO = null;
		if (places != null) {
			placesDTO = new PlacesDTO();
			placesDTO.setIdPlaces(places.getIdPlaces());
			placesDTO.setNameplaces(places.getNameplaces());
			placesDTO.setCityplaces(places.getCityplaces());
			placesDTO.setLatitude(places.getLatitude());
			placesDTO.setLongitude(places.getLongitude());
			placesDTO.setCityidcity(places.getCityidcity());
			placesDTO.setType(places.getType());
		}
		return placesDTO;
	}

	public static Places toEntity(PlacesDTO placesDTO) {
		Places places = null;
		if (placesDTO != null) {
			places = new Places();
			places.setIdPlaces(placesDTO.getIdPlaces());
			places.setNameplaces(placesDTO.getNameplaces());
			places.setCityplaces(placesDTO.getCityplaces());
			places.setLatitude(placesDTO.getLatitude());
			places.setLongitude(placesDTO.getLongitude());
			places.setCityidcity(placesDTO.getCityidcity());
			places.setType(placesDTO.getType());
		}
		return places;
	}

	public static List<PlacesDTO> toListDTO(List<Places> list) {
		List<PlacesDTO> listPlacesDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Places places : list) {
				listPlacesDTO.add(ConverterPlaces.toDTO(places));
			}
		}
		return listPlacesDTO;
	}

	public static List<Places> toListEntity(List<PlacesDTO> listPlacesDTO) {
		List<Places> list = new ArrayList<>();
		if (!listPlacesDTO.isEmpty()) {
			for (PlacesDTO placesDTO : listPlacesDTO) {
				list.add(ConverterPlaces.toEntity(placesDTO));
			}
		}
		return list;
	}
}
