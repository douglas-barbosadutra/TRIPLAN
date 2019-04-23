package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.PlacesDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.PlacesService;

/** 
 * La servlet si occupa di parlare con la JSP e utilizza i servizi opportuni.
 * Per chi farà User dovrà anche occuparsi del Login che abbiamo lasciato come
 * struttura e va modificata in modo opportuno
 *
 */
public class PlacesServlet extends HttpServlet {

	private final PlacesService placesService = new PlacesService();
	private List<PlacesDTO> allPlaces = new ArrayList<>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final int idU = Integer.parseInt(request.getParameter("idU"));
		
		
		
		final HttpSession session = request.getSession(true);

		switch (scelta) {


		case "insertRedirect":
			request.setAttribute("idU", idU);
			request.setAttribute("id",Integer.parseInt(request.getParameter("id")));
			getServletContext().getRequestDispatcher("/progetto/insertPlaces.jsp").forward(request, response);
			break;

		case "insert":
			request.setAttribute("idU", idU);
			final String nomePlaces = request.getParameter("nomePlaces");
			final PlacesDTO places = new PlacesDTO(nomePlaces);
			placesService.insertPlaces(places);
			showAllPlaces(request, response);
			break;

		case "updateRedirect":
			request.setAttribute("idU", idU);
			int id = Integer.parseInt(request.getParameter("updateId"));
			PlacesDTO placesUpdate = new PlacesDTO("");
			placesUpdate.setIdPlaces(id);

			placesUpdate = this.placesService.readPlaces(id);
			request.setAttribute("placesUpdate", placesUpdate);
			getServletContext().getRequestDispatcher("/places/updatePlaces.jsp").forward(request, response);

			break;

		case "update":
			request.setAttribute("idU", idU);
			// System.out.println("ID: " +
			// Integer.parseInt(request.getParameter("user_id")));
			// System.out.println("username: " + request.getParameter("user_user"));
			// System.out.println("password: " + request.getParameter("user_pass"));
			// System.out.println("Tipo utente: " + request.getParameter("user_type"));

			final Integer idplacesUpdate = Integer.parseInt(request.getParameter("idPlaces"));
			final String nomeplacesUpdate = request.getParameter("nomePlaces");
		    

			final PlacesDTO placesUp = new PlacesDTO(nomeplacesUpdate);
			placesUp.setIdPlaces(idplacesUpdate);
			placesService.updatePlaces(placesUp);
			showAllPlaces(request, response);
			break;

		case "delete":
			request.setAttribute("idU", idU);
			final Integer deleteId = Integer.parseInt(request.getParameter("deleteId"));
			placesService.deletePlaces(deleteId);
			showAllPlaces(request, response);
			break;

		case "indietro":
			request.setAttribute("idU", idU);
			getServletContext().getRequestDispatcher("homeUser.jsp").forward(request, response);
		
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;

		}

	}

	
	private void showAllPlaces(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		final int idU = Integer.parseInt(request.getParameter("idU"));
		request.setAttribute("idU", idU);
		request.setAttribute("allPlaces", allPlaces);
		getServletContext().getRequestDispatcher("/places/managePlaces.jsp").forward(request, response);
	}
}