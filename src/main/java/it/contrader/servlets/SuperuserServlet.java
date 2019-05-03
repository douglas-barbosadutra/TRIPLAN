package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.UserDTO;
import it.contrader.service.UserService;


public class SuperuserServlet extends HttpServlet {

	private final UserService userService = new UserService();
	private List<UserDTO> allTours = new ArrayList<>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);
		switch (scelta) {

		case "SuperUserManager":
			allTours = this.userService.getAllTour();
			request.setAttribute("allTour", allTours);
			getServletContext().getRequestDispatcher("/superuser/manageTouroperator.jsp").forward(request, response);
			break;

		case "insertRedirect":
			response.sendRedirect("superuser/insertTouroperator.jsp");
			break;

		case "insert":
			final String username = request.getParameter("user_user");
			final String password = request.getParameter("user_pass");
			final String usertype = request.getParameter("user_type");
			final UserDTO users = new UserDTO(username, password, usertype);
			userService.insertUser(users);
			showAllTours(request, response);
			break;

		case "updateRedirect":
			int id = Integer.parseInt(request.getParameter("id"));
			UserDTO userUpdate = new UserDTO("", "", "");
			userUpdate.setUserId(id);
			userUpdate = this.userService.readUser(id);
			request.setAttribute("userUpdate", userUpdate);
			getServletContext().getRequestDispatcher("/superuser/updateTouroperator.jsp").forward(request, response);

			break;

		case "update":
			final Integer idUpdate = Integer.parseInt(request.getParameter("user_id"));
			final String usernameUpdate = request.getParameter("user_user");
			final String passwordUpdate = request.getParameter("user_pass");
			final String usertypeUpdate = request.getParameter("user_type");
			final UserDTO user = new UserDTO(usernameUpdate, passwordUpdate, usertypeUpdate);
			user.setUserId(idUpdate);
			userService.updateUser(user);
			showAllTours(request, response);
			break;

		case "delete":
			final Integer deleteId = Integer.parseInt(request.getParameter("id"));
			final UserDTO userdelete = new UserDTO("", "", "");
			userdelete.setUserId(deleteId);
			userService.deleteUser(deleteId);
			showAllTours(request, response);
			break;

		case "indietro":
			response.sendRedirect("homeSU.jsp");
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;

		}

	}

	private void showAllTours(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allTours = this.userService.getAllTour();
		request.setAttribute("allTour", allTours);
		getServletContext().getRequestDispatcher("/superuser/manageTouroperator.jsp").forward(request, response);
	}
}