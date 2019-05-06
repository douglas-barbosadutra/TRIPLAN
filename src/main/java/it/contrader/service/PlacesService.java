package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.ConverterCity;
import it.contrader.converter.ConverterPlaces;
import it.contrader.dao.PlacesDAO;
import it.contrader.dto.CityDTO;
import it.contrader.dto.PlacesDTO;
import it.contrader.model.City;
import it.contrader.model.Places;

public class PlacesService {

	private PlacesDAO placesDAO;

	public PlacesService() {
		this.placesDAO = new PlacesDAO();
	}

	public List<PlacesDTO> getAllPlaces() {

		List<Places> list = placesDAO.getAllPlaces();
		List<PlacesDTO> listDTO = new ArrayList<>();

		for (Places places : list) {
			listDTO.add(ConverterPlaces.toDTO(places));
		}

		return listDTO;
	}

	public List<PlacesDTO> getCityPlaces(Integer idcity) {
		List<Places> list = placesDAO.CityPlaces(idcity);
		List<PlacesDTO> listDTO = new ArrayList<>();
		for (Places places : list) {
			listDTO.add(ConverterPlaces.toDTO(places));
		}

		return listDTO;
	}

	// modificare nome singolare.
	public boolean insertPlaces(PlacesDTO placesDTO) {
		return this.placesDAO.insertPlaces(ConverterPlaces.toEntity(placesDTO));
	}

	public PlacesDTO readPlaces(int idplaces) {
		return ConverterPlaces.toDTO(this.placesDAO.readPlaces(idplaces));
	}

	public boolean updatePlaces(PlacesDTO placesDTO) {
		return this.placesDAO.updatePlaces(ConverterPlaces.toEntity(placesDTO));
	}

	public boolean deletePlaces(int idplaces) {
		return this.placesDAO.deletePlaces(idplaces);
	}

	public PlacesDTO readPlaces2(int city_idcity) {
		return ConverterPlaces.toDTO(this.placesDAO.readPlaces(city_idcity));
	}

	public List<Places> getPlaces(Integer Idcity) {
		return this.placesDAO.Places(Idcity);
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
						
						System.out.println("PLACE 1" + places.get(0).getNomePlaces());
						System.out.println("PLACE 2" + places.get(i).getNomePlaces());
						System.out.println("DISTANCE: " + places.get(0).distanceTo(places.get(i)));
						
						bestDistance = places.get(0).distanceTo(places.get(i));
						posX = i;
					}else {
						
					}
				}
				System.out.println("PLACE TROVATO" + places.get(posX).getNomePlaces());
				System.out.println("PLACE MODIFICATO " + places.get(0).getNomePlaces());
				itinerary.add(places.get(posX));
				PlacesDTO trovato = places.get(posX);
				places.remove(trovato);
				places.set(0, trovato);
				
			}
		}
		
		return itinerary;
	}
}
