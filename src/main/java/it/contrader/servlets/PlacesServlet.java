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
<<<<<<< HEAD
			final PlacesDTO placess = new PlacesDTO(nameplaces);
=======
			final String cityplaces = request.getParameter("city_places");
			final double latitude = Double.parseDouble(request.getParameter("latitude"));
			final double longitude = Double.parseDouble(request.getParameter("longitude"));
			final PlacesDTO placess = new PlacesDTO(nameplaces, cityplaces, latitude, longitude);
>>>>>>> f75a4ea3df5167a161313cd1f27983d32a2009b5
			placesService.insertPlaces(placess);
			showAllPlacess(request, response);
			break;

		case "updateRedirect":
			int id = Integer.parseInt(request.getParameter("id"));
<<<<<<< HEAD
			PlacesDTO placesUpdate = new PlacesDTO("");
=======
			PlacesDTO placesUpdate = new PlacesDTO("", "", null , null);
>>>>>>> f75a4ea3df5167a161313cd1f27983d32a2009b5
			placesUpdate.setIdPlaces(id);
			placesUpdate = this.placesService.readPlaces(id);
			request.setAttribute("placesUpdate", placesUpdate);
			getServletContext().getRequestDispatcher("/places/updatePlaces.jsp").forward(request, response);

			break;

		case "update":
			final Integer idUpdate = Integer.parseInt(request.getParameter("idplaces"));
			final String nameplacesUpdate = request.getParameter("name_places");
<<<<<<< HEAD
			final PlacesDTO places = new PlacesDTO(nameplacesUpdate);
=======
			final String cityplacesUpdate = request.getParameter("city_places");
			final Double latitudeUpdate = Double.parseDouble(request.getParameter("latitude"));
			final Double longitudeUpdate = Double.parseDouble(request.getParameter("longitude"));
			final PlacesDTO places = new PlacesDTO(nameplacesUpdate, cityplacesUpdate, latitudeUpdate, longitudeUpdate);
>>>>>>> f75a4ea3df5167a161313cd1f27983d32a2009b5
			places.setIdPlaces(idUpdate);
			placesService.updatePlaces(places);
			showAllPlacess(request, response);
			break;

		case "delete":
			final Integer deleteId = Integer.parseInt(request.getParameter("id"));
<<<<<<< HEAD
			final PlacesDTO placesdelete = new PlacesDTO("");
=======
			final PlacesDTO placesdelete = new PlacesDTO("", "", null, null);
>>>>>>> f75a4ea3df5167a161313cd1f27983d32a2009b5
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