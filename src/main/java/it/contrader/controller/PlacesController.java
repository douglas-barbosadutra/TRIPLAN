package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.CityDTO;
import it.contrader.dto.PlacesDTO;
import it.contrader.services.PlacesService;

import java.util.List;

@Controller
@RequestMapping("/Places")
public class PlacesController {

	
	private PlacesService placesService;
	@Autowired
	private HttpSession session;

	@Autowired
	public PlacesController(PlacesService placesService) {
		this.placesService = placesService;
	}

	private void visualPlaces(HttpServletRequest request) {
		List<PlacesDTO> allPlaces = this.placesService.getListaPlacesDTO();
		request.setAttribute("allPlacesDTO", allPlaces);
	}
	
	private void selectPlaces(HttpServletRequest request) {
		CityDTO cityDTO = (CityDTO) session.getAttribute("città");
		List<PlacesDTO> selectCity = this.placesService.findOrderDTOByCity(cityDTO);
		request.setAttribute("selectCityDTO", selectCity);
	}
	
	
	@RequestMapping(value = "/placesManagement", method = RequestMethod.GET)
	public String placesManagement(HttpServletRequest request) {
		visualPlaces(request);
		return "places/managePlaces";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.placesService.deletePlacesById(id);
		visualPlaces(request);
		return "places/managePlaces";
	}

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insertRedirect(HttpServletRequest request) {
		return "places/insertPlaces";
	}

	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		PlacesDTO placesUpdate = new PlacesDTO();
		placesUpdate = this.placesService.getPlacesDTOById(id);
		request.setAttribute("placesUpdate", placesUpdate);
		return "places/updatePlaces";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		Integer idUpdate = Integer.parseInt(request.getParameter("idplaces"));
		String nameplacesUpdate = request.getParameter("name_places");
		String cityplacesUpdate = request.getParameter("city_places");
		Double latitudeUpdate = Double.parseDouble(request.getParameter("latitude"));
		Double longitudeUpdate = Double.parseDouble(request.getParameter("longitude"));
		Integer cityidcityUpdate = Integer.parseInt(request.getParameter("city_idcity"));
		String typeUpdate = request.getParameter("type");
		
		PlacesDTO places = new PlacesDTO();
		places.setNameplaces(nameplacesUpdate);
		places.setCityplaces(cityplacesUpdate);
		places.setLatitude(latitudeUpdate);
		places.setLongitude(longitudeUpdate);
		places.setCityidcity(cityidcityUpdate);
		places.setIdPlaces(idUpdate);
		places.setType(typeUpdate);
		placesService.updatePlaces(places);
		visualPlaces(request);
		return "places/managePlaces";
	}

	

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		String nameplaces = request.getParameter("name_places").toString();
		String cityplaces = request.getParameter("city_places").toString();
		Double latitude = Double.parseDouble(request.getParameter("latitude"));
		Double longitude = Double.parseDouble(request.getParameter("longitude"));
		Integer cityidcity = Integer.parseInt(request.getParameter("city_idcity"));
		String type = request.getParameter("type").toString();
		PlacesDTO placesObj = new PlacesDTO();
		placesObj.setNameplaces(nameplaces);
		placesObj.setCityplaces(cityplaces);
		placesObj.setLatitude(latitude);
		placesObj.setLongitude(longitude);
		placesObj.setCityidcity(cityidcity);
		placesObj.setType(type);
		placesService.insertPlaces(placesObj);
		visualPlaces(request);
		return "places/managePlaces";
	}
	
	@RequestMapping(value= "/SelectPlaces",method = RequestMethod.POST)
	public String Selectplaces(HttpServletRequest request) {
			selectPlaces(request);
			return "itinerary/SelectPlaces";
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

