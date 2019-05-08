package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.HotelDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.HotelService;
import it.contrader.services.UserService;

@Controller
@RequestMapping("/HotelController")
public class HotelController {

	private final HotelService hotelService;

	@Autowired
	public HotelController(HotelService hotelService) {
		this.hotelService = hotelService;
	}

	@RequestMapping(value = "/hotelManagement", method = RequestMethod.GET)
	public String hotelManagement(HttpServletRequest request) {
		visualHotel(request);
		return "/hotel/managehotel";		
	}
	
	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualHotel(request);
		request.setAttribute("option", "insert");
		return "/hotel/inserthotel";
		
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertHotel(HttpServletRequest request) {
		String nomehotel = request.getParameter("nomehotel");
		String cityhotel = request.getParameter("cityhotel");
		Integer numerostelle = Integer.parseInt(request.getParameter("numerostelle"));
		Double latitude = Double.parseDouble(request.getParameter("latitude"));
		Double longitude = Double.parseDouble(request.getParameter("longitude"));
		String gestorehotel = request.getParameter("gestorehotel");
		HotelDTO hotelObj = new HotelDTO(0, nomehotel, cityhotel, numerostelle, latitude, longitude, gestorehotel);
		hotelService.insertHotel(hotelObj);
		visualHotel(request);
		return "/hotel/managehotel";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String readHotel(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("readId"));
		HotelDTO hotel = this.hotelService.getHotelDTOById(id);
		request.setAttribute("hotelDTO", hotel);
		visualHotel(request);
		return "/hotel/readHotel";
	}
	
	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("updateId"));
		HotelDTO hotelUpdate = new HotelDTO();
		// hotelUpdate.setHotelId(id);

		hotelUpdate = this.hotelService.getHotelDTOById(id);
		request.setAttribute("hotelUpdate", hotelUpdate);
		return "/hotel/updateHotel";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		Integer idUpdate = Integer.parseInt(request.getParameter("idHotel"));
		String nomehotel = request.getParameter("nomehotel");
		String cityhotel = request.getParameter("cityhotel");
		Integer numerostelle = Integer.parseInt(request.getParameter("numerostelle"));
		Double latitude = Double.parseDouble(request.getParameter("latitude"));
		Double longitude = Double.parseDouble(request.getParameter("longitude"));
		String gestorehotel = request.getParameter("gestorehotel");
		HotelDTO hotelObj = new HotelDTO(idUpdate, nomehotel, cityhotel, numerostelle, latitude, longitude, gestorehotel);
		hotelService.updateHotel(hotelObj);
		visualHotel(request);
		return "/hotel/manageHotel";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("deleteId"));
		request.setAttribute("id", id);
		this.hotelService.deleteHotelById(id);
		visualHotel(request);
		return "/hotel/manageHotel";
	}
	
	private void visualHotel(HttpServletRequest request){
		List<HotelDTO> allHotel = this.hotelService.getAllHotelDTO();
		request.setAttribute("allHotelDTO", allHotel);
	}
}
