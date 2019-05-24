package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.PlacesDTO;
import it.contrader.service.PlacesService;

@CrossOrigin
@RestController
@RequestMapping("/Places")
public class PlacesController {

	private final PlacesService placesService;

	@Autowired
	public PlacesController(PlacesService placesService) {
		this.placesService = placesService;
	}
	
	@RequestMapping(value = "/placesManagement", method = RequestMethod.GET)
	public List<PlacesDTO> placesManagement() {
	return this.placesService.findAllPlacesDTO();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "idCity") int id) {
		this.placesService.deletePlacesById(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
		public void update(@RequestBody PlacesDTO places) {
			placesService.updatePlaces(places);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody PlacesDTO places) {
		placesService.insertPlaces(places);
	}
}

