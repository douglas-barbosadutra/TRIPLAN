package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.CityDTO;

import it.contrader.dto.UserDTO;
import it.contrader.model.City;
import it.contrader.service.CityService;


public class CityServlet extends HttpServlet {

	/**
	 * 
	 */
	
	private final CityService cityService = new CityService();
	private List<CityDTO> allCity = new ArrayList<>();
		
	public void service(HttpServletRequest request, HttpServletResponse response, CityDTO idcity) throws ServletException, IOException {

		final String scelta = request.getParameter("");
		final HttpSession session = request.getSession(true);
		switch (scelta) {

		case "TourOperator":
			
			request.setAttribute("idcity", idcity);
			request.setAttribute("allCity", allCity);
			getServletContext().getRequestDispatcher("/city/manageCity.jsp").forward(request, response);
			break;
			
		case "modifica":
			request.setAttribute("idcity", idcity);
			request.setAttribute("idcity",Integer.parseInt(request.getParameter("idcity")));
			getServletContext().getRequestDispatcher("/city/insertCity.jsp").forward(request, response);
			break;
			
		case "inserisci":
			request.setAttribute("idcity", idcity);
			final String name_city = request.getParameter("name_city");
			final String stato = request.getParameter("Stato");
			
			
			final CityDTO city = new CityDTO();
			cityService.insertCity(idcity);
			showAllCity(request, response,idcity);
			break;
			
		case "cancella":
			request.setAttribute("idcity", idcity);
			final Integer deleteId = Integer.parseInt(request.getParameter("deleteId"));
			cityService.deleteCity(deleteId);
			showAllCity(request, response, idcity);
			break;
			
		case "esci":
			response.sendRedirect("index.jsp");
			break;
		}	}}

	
	 		
		
		
		
		
		

















