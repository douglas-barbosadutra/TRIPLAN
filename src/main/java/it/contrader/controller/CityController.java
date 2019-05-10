package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.CityDTO;
import it.contrader.services.CityService;

import java.util.List;

@Controller
@RequestMapping("/City")
public class CityController {

	private final CityService cityService;
	@Autowired
	private HttpSession session;

	@Autowired
	public CityController(CityService cityService) {
		this.cityService = cityService;
	}

	private void visualCity(HttpServletRequest request) {
		List<CityDTO> allCity = this.cityService.getListaCityDTO();
		request.setAttribute("allCityDTO", allCity);
	}
	
	@RequestMapping(value = "/cityManagement", method = RequestMethod.GET)
	public String cityManagement(HttpServletRequest request) {
		visualCity(request);
		return "city/manageCity";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.cityService.deleteCityById(id);
		visualCity(request);
		return "city/manageCity";
	}

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insertRedirect(HttpServletRequest request) {
		return "city/insertCity";
	}

	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		CityDTO cityUpdate = new CityDTO();
		cityUpdate = this.cityService.getCityDTOById(id);
		request.setAttribute("cityUpdate", cityUpdate);
		return "city/updateCity";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		Integer idUpdate = Integer.parseInt(request.getParameter("idcity"));
		String namecityUpdate = request.getParameter("name_city");
		String statoUpdate = request.getParameter("state");

		CityDTO city = new CityDTO();
		city.setNamecity(namecityUpdate);
		city.setState(statoUpdate);
		city.setIdCity(idUpdate);
		cityService.updateCity(city);
		visualCity(request);
		return "city/manageCity";
	}

	@RequestMapping(value = "/cercaUser", method = RequestMethod.GET)
	public String cercaUser(HttpServletRequest request) {

		final String content = request.getParameter("search");
		List<CityDTO> allUser = this.cityService.findCityDTOByNameCity(content);
		request.setAttribute("allUserDTO", allUser);
		return "superuser/manageTouroperator";

	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		String namecity = request.getParameter("name_city").toString();
		String state = request.getParameter("state").toString();
		CityDTO cityObj = new CityDTO();
		cityObj.setNamecity(namecity);
		cityObj.setState(state);
		cityService.insertCity(cityObj);
		visualCity(request);
		return "city/manageCity";
	}
	
	@RequestMapping(value ="/selectCity", method = RequestMethod.GET)
	public String selectCity(HttpServletRequest request) {
		visualCity(request);
		return "itinerary/SelectCity";
	}	
	
	@RequestMapping(value = "/indietro", method = RequestMethod.GET)
	public String indistro(HttpServletRequest request) {;
		return "homeTO";
	}


	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}
}

