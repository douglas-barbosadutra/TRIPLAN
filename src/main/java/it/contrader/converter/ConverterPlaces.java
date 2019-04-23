package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.PlacesDTO;
import it.contrader.dto.PlacesDTO;
import it.contrader.model.Places;

public class ConverterPlaces {


	public static PlacesDTO toDTO(Places places) {
		PlacesDTO placesDTO = null;
		if (places != null) {
			placesDTO = new PlacesDTO();
			placesDTO.setIdPlaces(places.getIdPlaces());
			placesDTO.setNomePlaces(places.getNomePlaces());
			
		}
		return placesDTO;
	}

	public static Places toEntity(PlacesDTO placesDTO) {
		Places places = null;
		if (placesDTO != null) {
			places = new Places();
			places.setIdPlaces(placesDTO.getIdPlaces());
			places.setNomePlaces(placesDTO.getNomePlaces());
			
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