package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Arrays;
=======
>>>>>>> 824db453a5990ab9392d5e94cf15068e80f7125d
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

<<<<<<< HEAD
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

=======
<<<<<<< HEAD
	private final UserService userService = new UserService();
	private List<UserDTO> allUsers = new ArrayList<>();
=======
	private final CityService cityService = new CityService();
	private List<CityDTO> allCitys = new ArrayList<>();
	private final PlacesService placesService = new PlacesService();
	private List<Places> CityPlacess = new ArrayList<>();
>>>>>>> f75a4ea3df5167a161313cd1f27983d32a2009b5
>>>>>>> 824db453a5990ab9392d5e94cf15068e80f7125d

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

<<<<<<< HEAD
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
=======
		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);
		switch (scelta) {

<<<<<<< HEAD
		case "UserManager":
			allUsers = this.userService.getAllUser();
			request.setAttribute("allUser", allUsers);
			getServletContext().getRequestDispatcher("/user/manageUser.jsp").forward(request, response);
			break;

		case "insertRedirect":
			response.sendRedirect("user/insertUser.jsp");
			break;

		case "insert":
			final String username = request.getParameter("user_user");
			final String password = request.getParameter("user_pass");
			final String usertype = request.getParameter("user_type");
			final UserDTO users = new UserDTO(username, password, usertype);
			userService.insertUser(users);
			showAllUsers(request, response);
			break;

		case "updateRedirect":
			int id = Integer.parseInt(request.getParameter("id"));
			UserDTO userUpdate = new UserDTO("", "", "");
			userUpdate.setUserId(id);
			userUpdate = this.userService.readUser(id);
			request.setAttribute("userUpdate", userUpdate);
			getServletContext().getRequestDispatcher("/user/updateUser.jsp").forward(request, response);

			break;

		case "update":
			final Integer idUpdate = Integer.parseInt(request.getParameter("user_id"));
			final String usernameUpdate = request.getParameter("user_user");
			final String passwordUpdate = request.getParameter("user_pass");
			final String usertypeUpdate = request.getParameter("user_type");
			final UserDTO user = new UserDTO(usernameUpdate, passwordUpdate, usertypeUpdate);
			user.setUserId(idUpdate);
			userService.updateUser(user);
			showAllUsers(request, response);
			break;

		case "delete":
			final Integer deleteId = Integer.parseInt(request.getParameter("id"));
			final UserDTO userdelete = new UserDTO("", "", "");
			userdelete.setUserId(deleteId);
			userService.deleteUser(deleteId);
			showAllUsers(request, response);
			break;

		case "indietro":
			response.sendRedirect("homeTO.jsp");
=======
		case "City":
			allCitys = this.cityService.getAllCity();
			request.setAttribute("allCity", allCitys);
			getServletContext().getRequestDispatcher("/user/Viaggia.jsp").forward(request, response);
			break;
			
			
		case "indietro":
			response.sendRedirect("homeUser.jsp");
>>>>>>> f75a4ea3df5167a161313cd1f27983d32a2009b5
>>>>>>> 824db453a5990ab9392d5e94cf15068e80f7125d
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;

		}
<<<<<<< HEAD
		
	}
}	
	
=======

	}

	private void showAllCitys(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allCitys = this.cityService.getAllCity();
		request.setAttribute("allCity", allCitys);
		getServletContext().getRequestDispatcher("/user/Viaggia.jsp").forward(request, response);
	}
}
>>>>>>> 824db453a5990ab9392d5e94cf15068e80f7125d
