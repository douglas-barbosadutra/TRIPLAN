package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.UserDTO;
import it.contrader.services.UserService;

import java.util.List;

@Controller
@RequestMapping("/Login")
public class LoginController {

	private final UserService userService;
	@Autowired
	private HttpSession session;

	@Autowired
	public LoginController(UserService userService) {
		this.userService = userService;
	}

	private void visualUser(HttpServletRequest request) {
		//UserDTO userDTO = (UserDTO) session.getAttribute("utente");
		List<UserDTO> allUser = this.userService.getListaUserDTO();
		request.setAttribute("allUserDTO", allUser);
	}



	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginControl(HttpServletRequest request) {

		session = request.getSession();
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		final UserDTO userDTO = userService.getUserByUserUserAndUserPass(username, password);
		final String userType = userDTO.getUserType();
		if (!StringUtils.isEmpty(userType)) {
			session.setAttribute("utenteCollegato", userDTO);
			if (userType.equals("superuser")) {
				return "homeSU";
			} else if (userType.equals("touroperator")) {
				return "homeTO";
			} else if (userType.equals("gestorehotel")) {
				return "homeGH";
			} else if (userType.equals("user")) {
				return "homeUser";
			}else if (userType.equals("gestoreevento")) {
				return "homeGE";
			}
		}
		return "index";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}
}
