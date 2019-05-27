package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.CityDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.CityService;

@CrossOrigin
@RestController
@RequestMapping("/City")
public class CityController {

	private final CityService cityService;

	@Autowired
	public CityController(CityService cityService) {
		this.cityService = cityService;
	}
	
	@RequestMapping(value="/showCity" , method= RequestMethod.GET)
	public List<CityDTO> showCity() {		
		return cityService.getAllCity();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "idCity") int id) {
		this.cityService.deleteCityById(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
		public void update(@RequestBody CityDTO city) {
			cityService.updateCity(city);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody CityDTO city) {
		cityService.insertCity(city);
	}
}

