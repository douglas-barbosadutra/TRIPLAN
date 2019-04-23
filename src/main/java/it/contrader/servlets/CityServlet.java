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

	private final CityService cityService = new CityService();
	private List<CityDTO> allCitys = new ArrayList<>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);
		
		switch (scelta) {

		case "CityManager":
			allCitys = this.cityService.getAllCity();
			request.setAttribute("allCity", allCitys);
			getServletContext().getRequestDispatcher("/city/manageCity.jsp").forward(request, response);
			break;
			
		case "insertRedirect":
			response.sendRedirect("user/insertUser.jsp");
			break;

		case "insert":
			// final Integer id = Integer.parseInt(request.getParameter("user_id"));
			final String namecity = request.getParameter("name_city");
			final CityDTO citys = new CityDTO(namecity);
			cityService.insertCity(citys);
			showAllCitys(request, response);
			break;

		case "updateRedirect":
			int id = Integer.parseInt(request.getParameter("id"));
			CityDTO cityUpdate = new CityDTO("");
			cityUpdate.setIdCity(id);

			cityUpdate = this.cityService.readCity(id);
			request.setAttribute("cityUpdate", cityUpdate);
			getServletContext().getRequestDispatcher("/user/updateCity.jsp").forward(request, response);

			break;

		case "update":
			final Integer idUpdate = Integer.parseInt(request.getParameter("idcity"));
			final String nomecityUpdate = request.getParameter("name_city");
			final CityDTO city = new CityDTO(nomecityUpdate);
			city.setIdCity(idUpdate);

			cityService.updateCity(city);
			showAllCitys(request, response);
			break;

		case "delete":
			final Integer deleteId = Integer.parseInt(request.getParameter("id"));

			final CityDTO citydelete = new CityDTO("");
			citydelete.setIdCity(deleteId);
			cityService.deleteCity(deleteId);
			showAllCitys(request, response);
			break;

		case "indietro":
			response.sendRedirect("homeAdmin.jsp");
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
		getServletContext().getRequestDispatcher("/user/manageCity.jsp").forward(request, response);
	}
}