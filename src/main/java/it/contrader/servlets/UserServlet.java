package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.CityDTO;
import it.contrader.dto.PlacesDTO;
import it.contrader.model.Places;
import it.contrader.service.CityService;
import it.contrader.service.PlacesService;



public class UserServlet extends HttpServlet {

	private final CityService cityService = new CityService();
	private List<CityDTO> allCitys = new ArrayList<>();
	private final PlacesService placesService = new PlacesService();
	private List<PlacesDTO> CityPlacess = new ArrayList<>();
	private List<PlacesDTO> Itinerary = new ArrayList<>();
	static int idCityPlaces;
	
	public void setIdCityPlaces(int idCityPlaces) {
		this.idCityPlaces = idCityPlaces;
	}

	public int getIdCityPlaces() {
		return idCityPlaces;
	}


	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");		
		final HttpSession session = request.getSession(true);
		int i;
		switch (scelta) {
		//modificare per CityServlet
		case "City":
			allCitys = this.cityService.getAllCity();
			request.setAttribute("allCity", allCitys);
			getServletContext().getRequestDispatcher("/user/SelectCity.jsp").forward(request, response);
			break;
			//modificare per PlacesServlet			
		case "Places":
			int idPlaces = Integer.parseInt(request.getParameter("idcity").toString());
			CityPlacess = this.placesService.getCityPlaces(idPlaces);
			request.setAttribute("CityPlaces", CityPlacess);
			getServletContext().getRequestDispatcher("/user/SelectPlaces.jsp").forward(request, response);
			break;
			//modificare per PlacesServlet	
		case "Itinerary":
			  
			   String listIdPlaces[] = request.getParameterValues("idcityplaces");
			   for (String id : listIdPlaces) {
				   Itinerary.add(this.placesService.readPlaces(Integer.parseInt(id)));
			   }
			   Itinerary = this.placesService.getItinerary(Itinerary);
		       request.setAttribute("listaPlacesScelto", Itinerary);
			   getServletContext().getRequestDispatcher("/user/Itinerary.jsp").forward(request, response);
			   break;
			
		case "indietro":
			response.sendRedirect("homeUser.jsp");
			break;
			
		case "indietroC":
			response.sendRedirect("/user/SelectCity.jsp");
			break;
			
		case "indietroP":
			response.sendRedirect("/user/SelectPlaces.jsp");
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;

		}
		
	}
}	
	