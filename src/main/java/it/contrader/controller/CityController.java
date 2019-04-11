package it.contrader.controller;

import java.util.List;

import it.contrader.dto.CityDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.City;
import it.contrader.service.CityService;

public class CityController implements Controller {

    private static String sub_package = "city.";
	private CityService cityService;
	

	public CityController() {
		this.cityService = new CityService();
	}

	public List<City> getAllCity() {
		return this.cityService.getAllCity();
	}

	public CityDTO readCity(int idcity) {
		return this.cityService.readCity(idcity);
	}

	public boolean insertCity(CityDTO cityDTO) {
		return this.cityService.insertCity(cityDTO);
	}

	public boolean updateCity(CityDTO cityDTO) {
		return this.cityService.updateCity(cityDTO);
	}

	public boolean deleteCity(Integer idcity) {
		return this.cityService.deleteCity(idcity);
	}

	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		if (mode == "menu") {
			MainDispatcher.getInstance().callView("City", null);
		} else {
			switch (choice.toUpperCase()) {
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "CityRead", null);
				break;
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "CityInsert", null);
				break;
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "CityUpdate", null);
				break;
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "CityDelete", null);
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