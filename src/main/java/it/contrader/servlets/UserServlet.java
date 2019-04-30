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
import it.contrader.dto.PlacesDTO;
import it.contrader.model.Places;
import it.contrader.service.CityService;
import it.contrader.service.PlacesService;



public class UserServlet extends HttpServlet {

	private final CityService cityService = new CityService();
	private List<CityDTO> allCitys = new ArrayList<>();
	private final PlacesService placesService = new PlacesService();
	private List<Places> CityPlacess = new ArrayList<>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);
		switch (scelta) {

		case "City":
			allCitys = this.cityService.getAllCity();
			request.setAttribute("allCity", allCitys);
			getServletContext().getRequestDispatcher("/user/Viaggia.jsp").forward(request, response);
			break;
			
			
		case "indietro":
			response.sendRedirect("homeUser.jsp");
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;

		}

	}

	private void showAllCitys(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allCitys = this.cityService.getAllCity();
		request.setAttribute("allCity", allCitys);
		getServletContext().getRequestDispatcher("/user/Viaggia.jsp").forward(request, response);
	}
}