package it.contrader.service;

import java.util.List;
import it.contrader.converter.ConverterPlaces;
import it.contrader.dao.PlacesDAO;
import it.contrader.dto.CityPlacesDTO;
import it.contrader.dto.PlacesDTO;
import it.contrader.model.Places;

public class PlacesService {
	
	
private PlacesDAO placesDAO;

		public PlacesService() {
			this.placesDAO = new PlacesDAO();
		}

		public List<Places> getAllPlaces() {
			return this.placesDAO.getAllPlaces();
		}

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
		
		//codice da eliminare se non va
		public List<Places> getCityPlaces(Integer idcity) {
			return this.placesDAO.CityPlaces(idcity);
		}	
		
		public PlacesDTO readPlaces2(int city_idcity) {
			return ConverterPlaces.toDTO(this.placesDAO.readPlaces(city_idcity));
		}
		
		public List<Places> getPlaces(Integer Idcity) {
			return this.placesDAO.Places(Idcity);
		}

}

