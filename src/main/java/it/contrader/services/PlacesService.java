package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterCity;
import it.contrader.converter.ConverterPlaces;
import it.contrader.dao.PlacesRepository;
import it.contrader.dto.CityDTO;
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
	
	public List<PlacesDTO> findOrderDTOByCity(CityDTO cityDTO) {
		final List<Places> listPlaces = placesRepository.findAllByCity(ConverterCity.toEntity(cityDTO));
		final List<PlacesDTO> listPlacesDTO = new ArrayList<>();
		listPlaces.forEach(i -> listPlacesDTO.add(ConverterPlaces.toDTO(i)));
		return listPlacesDTO;
	}
	
	public List<PlacesDTO> getItinerary(List<PlacesDTO> places) {
		List<PlacesDTO> itinerary = new ArrayList<>();
		double bestDistance;
		int posX = 0;
		itinerary.add(places.get(0));
		if (places.size() > 1) {
			while (places.size() > 1) {
				posX = 0;
				bestDistance = 999999999999.00;
				for (int i = 1; i < places.size(); i++) {
					if (places.get(0).distanceTo(places.get(i)) < bestDistance) {
						
						System.out.println("PLACE 1" + places.get(0).getNameplaces());
						System.out.println("PLACE 2" + places.get(i).getNameplaces());
						System.out.println("DISTANCE: " + places.get(0).distanceTo(places.get(i)));
						
						bestDistance = places.get(0).distanceTo(places.get(i));
						posX = i;
					}else {
						
					}
				}
				System.out.println("PLACE TROVATO" + places.get(posX).getNameplaces());
				System.out.println("PLACE MODIFICATO " + places.get(0).getNameplaces());
				itinerary.add(places.get(posX));
				PlacesDTO trovato = places.get(posX);
				places.remove(trovato);
				places.set(0, trovato);
				
			}
		}
		
		return itinerary;
	}
}
