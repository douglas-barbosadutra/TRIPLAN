package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.HotelDTO;
import it.contrader.service.HotelService;

@CrossOrigin
@RestController
@RequestMapping("/Hotel")
public class HotelController {

	private final HotelService hotelService;

	@Autowired
	public HotelController(HotelService hotelService) {
		this.hotelService = hotelService;
	}
	
	@RequestMapping(value="/showHotel" , method= RequestMethod.GET)
	public List<HotelDTO> showPlaces() {		
		return hotelService.getAllHotel();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "idHotel") int id) {
		this.hotelService.deleteHotelById(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
		public void update(@RequestBody HotelDTO hotel) {
		hotelService.updateHotel(hotel);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody HotelDTO hotel) {
		hotelService.insertHotel(hotel);
	}
}

