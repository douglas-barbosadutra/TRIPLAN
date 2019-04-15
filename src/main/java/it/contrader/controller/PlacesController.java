package it.contrader.controller;

import java.util.List;

<<<<<<< HEAD
import it.contrader.dto.CityPlacesDTO;
import it.contrader.dto.PlacesDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Places;
=======
import it.contrader.dto.PlacesDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Places;
import it.contrader.model.Places2;
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f
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
<<<<<<< HEAD
=======
	
	public List<Places2> getSelectPlaces() {
		return this.placesService.getSelectPlaces();
	}
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f

	public PlacesDTO readPlaces(int idplaces) {
		return this.placesService.readPlaces(idplaces);
	}
<<<<<<< HEAD

=======
	
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f
	public boolean insertPlaces(PlacesDTO placesDTO) {
		return this.placesService.insertPlaces(placesDTO);
	}

	public boolean updatePlaces(PlacesDTO placesDTO) {
		return this.placesService.updatePlaces(placesDTO);
	}

	public boolean deletePlaces(Integer idplaces) {
		return this.placesService.deletePlaces(idplaces);
	}

<<<<<<< HEAD

=======
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f
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
<<<<<<< HEAD
			case "Z":
				Integer id = (Integer) request.get("id");
				MainDispatcher.getInstance().callView("Places2", null);
				break;
=======
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f
			default:
				MainDispatcher.getInstance().callView("Login", null);
				break;
			}
		}
	}

<<<<<<< HEAD

=======
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f
}