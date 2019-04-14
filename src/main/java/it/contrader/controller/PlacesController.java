package it.contrader.controller;

import java.util.List;

import it.contrader.dto.PlacesDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Places;
import it.contrader.model.Places2;
import it.contrader.service.PlacesService;

public class PlacesController implements Controller {

    private static String sub_package = "places.";
	private PlacesService placesService;
	

	public PlacesController() {
		this.placesService = new PlacesService();
	}

	public List<Places> getAllPlaces() {
		return this.placesService.getAllPlaces();
	}
	
	public List<Places2> getSelectPlaces() {
		return this.placesService.getSelectPlaces();
	}

	public PlacesDTO readPlaces(int idplaces) {
		return this.placesService.readPlaces(idplaces);
	}
	
	public boolean insertPlaces(PlacesDTO placesDTO) {
		return this.placesService.insertPlaces(placesDTO);
	}

	public boolean updatePlaces(PlacesDTO placesDTO) {
		return this.placesService.updatePlaces(placesDTO);
	}

	public boolean deletePlaces(Integer idplaces) {
		return this.placesService.deletePlaces(idplaces);
	}

	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		if (mode == "menu") {
			MainDispatcher.getInstance().callView("Places", null);
		} else {
			switch (choice.toUpperCase()) {
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "PlacesRead", null);
				break;
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "PlacesInsert", null);
				break;
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "PlacesUpdate", null);
				break;
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "PlacesDelete", null);
				break;
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			default:
				MainDispatcher.getInstance().callView("Login", null);
				break;
			}
		}
	}

}