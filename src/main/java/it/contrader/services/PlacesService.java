package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.contrader.converter.ConverterPlaces;
import it.contrader.dao.PlacesRepository;
import it.contrader.dto.PlacesDTO;
import it.contrader.model.Places;

@Service
public class PlacesService {

	private final PlacesRepository placesRepository;

	@Autowired
	public PlacesService(PlacesRepository placesRepository) {
		this.placesRepository = placesRepository;
	}

	public List<PlacesDTO> getListaPlacesDTO() {
		return ConverterPlaces.toListDTO((List<Places>) placesRepository.findAll());
	}

	public PlacesDTO getPlacesDTOById(Integer id) {
		return ConverterPlaces.toDTO(placesRepository.findById(id).get()); 
	}


	public boolean insertPlaces(PlacesDTO placesDTO) {
		return placesRepository.save(ConverterPlaces.toEntity(placesDTO)) != null;
	}

	public boolean updatePlaces(PlacesDTO placesDTO) {
		return placesRepository.save(ConverterPlaces.toEntity(placesDTO)) != null;
	}
	
	public void deletePlacesById(Integer id) {
		placesRepository.deleteById(id);
	}
	
	public List<PlacesDTO> findPlacesDTOByNamePlaces(String nameplaces) {
		
		final List<Places> list = placesRepository.findAllByNameplaces(nameplaces);
		final List<PlacesDTO> placesDTOs = new ArrayList<>();
		list.forEach(i -> placesDTOs.add(ConverterPlaces.toDTO(i)));
		return placesDTOs;
		
	
	}
}
