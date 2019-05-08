package it.contrader.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.contrader.dto.UserDTO;
import it.contrader.dto.CityDTO;
import it.contrader.services.CityService;
import it.contrader.services.UserService;
import it.contrader.model.City;

@Controller
@RequestMapping("/CityController") 
public class CityController {
	private final CityService cityService;
	private final UserService userService;
	private HttpSession session;	
	@Autowired
	public CityController(CityService cityService, UserService userService) {
		this.cityService = cityService;
		this.userService = userService;
		
	}
	private void visualCity(HttpServletRequest request){
		List<CityDTO> allCity = this.cityService.getListCityDTO();
		request.setAttribute("allCityDTO", allCity);}

	@RequestMapping(value = "/cityManage", method = RequestMethod.GET)
	public String cityManager(HttpServletRequest request) {
		session = request.getSession();
		int idcity = Integer.parseInt(request.getParameter("idcity"));
		session.setAttribute("idcity", idcity);
		visualCity(request);
		return "/city/cityManage";
	}
		@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
		public String insert(HttpServletRequest request) {
			visualCity(request);
			request.setAttribute("option", "insert");
			return "/city/insertCity";
	}
		@RequestMapping(value = "/insert", method = RequestMethod.POST)
		public String insertCity(HttpServletRequest request) {
			String idcity = request.getParameter("idcity").toString();
			String name_city = request.getParameter("name_city").toString();
			int idplace = (int) session.getAttribute("idcity");
			visualCity(request);
			return "/city/cityManage";
		}
		
		@RequestMapping(value = "/read", method = RequestMethod.GET)
		public String readCity(HttpServletRequest request) {
			int idcity = Integer.parseInt(request.getParameter("readIdCity"));
			CityDTO city = this.cityService.getCityDTOById(idcity);
			request.setAttribute("CityDTO", city);
			visualCity(request);
			return "/city/readCity";
		}
		
		@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
		public String updateRedirect(HttpServletRequest request) {
			int idcity = Integer.parseInt(request.getParameter("updateId"));
			CityDTO cityUpdate = new CityDTO();
			cityUpdate.setIdcity(idcity);

			cityUpdate = this.cityService.getCityDTOById(idcity);
			request.setAttribute("cityUpdate", cityUpdate);
			return "/city/updateCity";
		}

		@RequestMapping(value = "/update", method = RequestMethod.POST)
		public String update(HttpServletRequest request) {
			Integer idUpdate = Integer.parseInt(request.getParameter("idcity"));
			int idPlace = (int) session.getAttribute("idplace");
			cityService.updateCity(idUpdate);
			visualCity(request);
			return "/city/citymanage";
		}
		
		@RequestMapping(value = "/delete", method = RequestMethod.GET)
		public String delete(HttpServletRequest request) {
			int idcity = Integer.parseInt(request.getParameter("deleteIdcity"));
			request.setAttribute("idcity", idcity);
			this.cityService.deleteCity(idcity);
			visualCity(request);
			return "/city/citymanager";
		}

		@RequestMapping(value = "/user", method = RequestMethod.GET)
		public String user(HttpServletRequest request) {
			int idcity = Integer.parseInt(request.getParameter("idcity"));
			City city =cityService.getAllCityByIdCity(idcity);
			request.setAttribute("City", city);
			this.cityService.deleteCity(idcity);
			visualCity(request);
			return "/city/citymanager";

		}





}