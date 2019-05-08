package it.contrader.controller;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.contrader.dto.CityDTO;
import it.contrader.services.CityService;


@Controller
@RequestMapping("/CityController") 
public class CityController {
	private final CityService cityService;
	private HttpSession session;	
	@Autowired
	public CityController(CityService cityService) {
		this.cityService = cityService;
		
		
	}
	private void visualCity(HttpServletRequest request){
		int idcity=Integer.parseInt(request.getParameter("idcity"));
		List<CityDTO> allCity = this.cityService.getAllCityByIdCity(idcity);
		request.setAttribute("allCityDTO", allCity);}

	@RequestMapping(value = "/manageCity", method = RequestMethod.GET)
	public String cityManager(HttpServletRequest request) {
		session = request.getSession();
		int idcity = Integer.parseInt(request.getParameter("idcity"));
		session.setAttribute("idcity", idcity);
		visualCity(request);
		return "/city/manageCity";
	}
		@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
		public String insert(HttpServletRequest request) {
			int idcity=Integer.parseInt(request.getParameter("idcity"));
			CityDTO city =this.cityService.getCityDTOById(idcity);
			visualCity(request);
			request.setAttribute("option", city);
			return "/city/insertCity";
	}
		@RequestMapping(value = "/insertCity", method = RequestMethod.POST)
		public String insertCity(HttpServletRequest request) {
			int idcity = Integer.parseInt(request.getParameter("updateIdcity"));
			visualCity(request);
			request.setAttribute("idcity", idcity);
			return "/city/manageCity";
	}
		
		
		
		@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
		public String updateRedirect(HttpServletRequest request) {
			int idcity = Integer.parseInt(request.getParameter("idcity"));
			CityDTO cityUpdate = new CityDTO();
			cityUpdate.setIdcity(idcity);
            cityUpdate = this.cityService.getCityDTOById(idcity);
			request.setAttribute("cityUpdate", cityUpdate);
			return "/city/updateCity";
		}

		@RequestMapping(value = "/updateCity", method = RequestMethod.POST)
		public String update(HttpServletRequest request) {
			 int idcity = (int) session.getAttribute("cityUpdate");
			visualCity(request);
			return "/city/citymanage";
		}
		
		@RequestMapping(value = "/deleteCity", method = RequestMethod.GET)
		public String delete(HttpServletRequest request) {
			int idcity = Integer.parseInt(request.getParameter("deleteIdcity"));
			request.setAttribute("idcity", idcity);
			this.cityService.deleteCity(idcity);
			visualCity(request);
			return "/city/manageCity";
		}

		

		





}