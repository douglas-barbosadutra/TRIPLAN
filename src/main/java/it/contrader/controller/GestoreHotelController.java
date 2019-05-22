package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.HotelDTO;
import it.contrader.service.HotelService;

@Controller
@RequestMapping("/GestoreHotel")
public class GestoreHotelController {

	private final HotelService hotelService;

	@Autowired
	public GestoreHotelController(HotelService hotelService) {
		this.hotelService = hotelService;
	}
	
	@RequestMapping(value = "/hotelManagement", method = RequestMethod.GET)
	public List<HotelDTO> hotelManagement() {
	return this.hotelService.findAllHotelDTO();
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

