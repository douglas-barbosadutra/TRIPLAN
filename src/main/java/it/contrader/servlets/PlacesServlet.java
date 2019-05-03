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
import it.contrader.service.PlacesService;


public class PlacesServlet extends HttpServlet {

	private final PlacesService placesService = new PlacesService();
	private List<PlacesDTO> allPlacess = new ArrayList<>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);
		switch (scelta) {

		case "PlacesManager":
			allPlacess = this.placesService.getAllPlaces();
			request.setAttribute("allPlaces", allPlacess);
			getServletContext().getRequestDispatcher("/places/managePlaces.jsp").forward(request, response);
			break;

		case "insertRedirect":
			response.sendRedirect("places/insertPlaces.jsp");
			break;

		case "insert":
			final String nameplaces = request.getParameter("name_places");
			final PlacesDTO placess = new PlacesDTO(nameplaces);
			placesService.insertPlaces(placess);
			showAllPlacess(request, response);
			break;

		case "updateRedirect":
			int id = Integer.parseInt(request.getParameter("id"));
			PlacesDTO placesUpdate = new PlacesDTO("");
			placesUpdate.setIdPlaces(id);
			placesUpdate = this.placesService.readPlaces(id);
			request.setAttribute("placesUpdate", placesUpdate);
			getServletContext().getRequestDispatcher("/places/updatePlaces.jsp").forward(request, response);

			break;

		case "update":
			final Integer idUpdate = Integer.parseInt(request.getParameter("idplaces"));
			final String nameplacesUpdate = request.getParameter("name_places");
			final PlacesDTO places = new PlacesDTO(nameplacesUpdate);
			places.setIdPlaces(idUpdate);
			placesService.updatePlaces(places);
			showAllPlacess(request, response);
			break;

		case "delete":
			final Integer deleteId = Integer.parseInt(request.getParameter("id"));
			final PlacesDTO placesdelete = new PlacesDTO("");
			placesdelete.setIdPlaces(deleteId);
			placesService.deletePlaces(deleteId);
			showAllPlacess(request, response);
			break;


		case "indietro":
			response.sendRedirect("homeTO.jsp");
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;

		}

	}

	private void showAllPlacess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allPlacess = this.placesService.getAllPlaces();
		request.setAttribute("allPlaces", allPlacess);
		getServletContext().getRequestDispatcher("/places/managePlaces.jsp").forward(request, response);
	}
}