package it.contrader.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.UserDTO;
import it.contrader.service.UserService;
import it.contrader.utils.GestoreEccezioni;

public class LoginServlet extends HttpServlet {

	private final UserService userServiceDTO = new UserService();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final HttpSession session = request.getSession();
		session.setAttribute("utente", null);

		if (request != null) {
			try {
			final String nomeUtente = request.getParameter("username").toString().trim();
			final String password = request.getParameter("password").toString().trim();
			// recuperiamo l'utente
			final UserDTO userDTO = userServiceDTO.getUserByUsernameAndPasword(nomeUtente, password);

			if (userDTO != null)
				session.setAttribute("utente", userDTO);
			final int idU = userDTO.getUserId();
			final int idTO = userDTO.getUserId();
<<<<<<< HEAD
=======
			final int idSU = userDTO.getUserId();
>>>>>>> f75a4ea3df5167a161313cd1f27983d32a2009b5


			// verifichiamo che tipo di ruolo ha all'interno dell'applicazione
			// e lo reindirizziamo nella jsp opportuna
			try {
			switch (userDTO.getUsertype().toLowerCase()) {
<<<<<<< HEAD
=======
			case "superuser":
				request.setAttribute("idSU", idSU);
				getServletContext().getRequestDispatcher("/homeSU.jsp").forward(request, response);
				break;
>>>>>>> f75a4ea3df5167a161313cd1f27983d32a2009b5
			case "touroperator":
				request.setAttribute("idTO", idTO);
				getServletContext().getRequestDispatcher("/homeTO.jsp").forward(request, response);
				break;
			case "user":
				request.setAttribute("idU", idU);
				getServletContext().getRequestDispatcher("/homeUser.jsp").forward(request, response);
				break;
			default:
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				break;
			}
			} catch (Exception e) {
				
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
			
			}catch (Exception e) {
				
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
	
		}
	}


