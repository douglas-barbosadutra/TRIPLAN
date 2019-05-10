package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.HotelDTO;
import it.contrader.services.HotelService;

import java.util.List;

@Controller
@RequestMapping("/Hotel")
public class GestoreHotelController {

	private final HotelService hotelService;
	@Autowired
	private HttpSession session;

	@Autowired
	public GestoreHotelController(HotelService hotelService) {
		this.hotelService = hotelService;
	}

	private void visualHotel(HttpServletRequest request) {
		List<HotelDTO> allHotel = this.hotelService.getListaHotelDTO();
		request.setAttribute("allhotelDTO", allHotel);
	}
	
	@RequestMapping(value = "/hotelManagement", method = RequestMethod.GET)
	public String hotelManagement(HttpServletRequest request) {
		visualHotel(request);
		return "hotel/manageHotel";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.hotelService.deleteHotelById(id);
		visualHotel(request);
		return "hotel/manageHotel";
	}

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insertRedirect(HttpServletRequest request) {
		return "city/insertCity";
	}

	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		HotelDTO hotelUpdate = new HotelDTO();
		hotelUpdate = this.hotelService.getHotelDTOById(id);
		request.setAttribute("hotelUpdate", hotelUpdate);
		return "hotel/updateHotel";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		Integer idUpdate = Integer.parseInt(request.getParameter("idhotel"));
		String namehotelUpdate = request.getParameter("nomehotel");
		String cityhotelUpdate = request.getParameter("cityhotel");
		Integer numerostelleUpdate = Integer.parseInt(request.getParameter("numerostelle"));
		Double latitude = Double.parseDouble(request.getParameter("latitude"));
		Double longitude = Double.parseDouble(request.getParameter("longitude"));
		String gestorehotelUpdate = request.getParameter("gestorehotel");
		HotelDTO hotel = new HotelDTO();
		hotel.setNomehotel(namehotelUpdate);
		hotel.setCityhotel(cityhotelUpdate);
		hotel.setIdhotel(idUpdate);
		hotel.setLatitude(latitude);
		hotel.setLongitude(longitude);
		hotel.setGestorehotel(gestorehotelUpdate);
		hotel.setNumerostelle(numerostelleUpdate);
		hotelService.updateHotel(hotel);
		visualHotel(request);
		return "hotel/manageHotel";
	}
	

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		String nomehotel = request.getParameter("nomehotel").toString();
		String cityhotel = request.getParameter("cityhotel").toString();
		Integer numerostelle = Integer.parseInt(request.getParameter("numerostelle"));
		Double latitude = Double.parseDouble(request.getParameter("latitude"));
		Double longitude = Double.parseDouble(request.getParameter("longitude"));
		String gestorehotel = request.getParameter("gestorehotel");
		HotelDTO hotelObj = new HotelDTO();
		hotelObj.setNomehotel(nomehotel);
		hotelObj.setNumerostelle(numerostelle);
		hotelObj.setCityhotel(cityhotel);
		hotelObj.setLatitude(latitude);
		hotelObj.setLongitude(longitude);
		hotelObj.setGestorehotel(gestorehotel);
		hotelService.insertHotel(hotelObj);
		visualHotel(request);
		return "hotel/manageHotel";
	}
	
	@RequestMapping(value = "/indietro", method = RequestMethod.GET)
	public String indistro(HttpServletRequest request) {;
		return "homeGH";
	}


	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}
}

