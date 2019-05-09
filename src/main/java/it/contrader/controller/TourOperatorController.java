package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.UserDTO;
import it.contrader.services.UserService;

import java.util.List;

@Controller
@RequestMapping("/Touroperator")
public class TourOperatorController {

	private final UserService userService;
	@Autowired
	private HttpSession session;

	@Autowired
	public TourOperatorController(UserService userService) {
		this.userService = userService;
	}

	private void visualUser(HttpServletRequest request) {
		List<UserDTO> allUser = this.userService.getListaUserDTO();
		request.setAttribute("allUserDTO", allUser);
	}
	
	@RequestMapping(value = "/userManagement", method = RequestMethod.GET)
	public String userManagement(HttpServletRequest request) {
		visualUser(request);
		return "touroperator/manageUser";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.userService.deleteUserById(id);
		visualUser(request);
		return "touroperator/manageUser";
	}

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insertRedirect(HttpServletRequest request) {
		return "touroperator/insertUser";
	}

	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		UserDTO userUpdate = new UserDTO();
		// userUpdate.setUserId(id);

		userUpdate = this.userService.getUserDTOById(id);
		request.setAttribute("userUpdate", userUpdate);
		return "touroperator/updateUser";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		Integer idUpdate = Integer.parseInt(request.getParameter("id_user"));
		String usernameUpdate = request.getParameter("username");
		String passwordUpdate = request.getParameter("password");
		String usertypeUpdate = request.getParameter("user_type");
		
		UserDTO user = new UserDTO();
		user.setUsername(usernameUpdate);
		user.setPassword(passwordUpdate);
		user.setUserType(usertypeUpdate);
		user.setIdUser(idUpdate);

		userService.updateUser(user);
		visualUser(request);
		return "touroperator/manageUser";
	}

	@RequestMapping(value = "/cercaUser", method = RequestMethod.GET)
	public String cercaUser(HttpServletRequest request) {

		final String content = request.getParameter("search");
		List<UserDTO> allUser = this.userService.findUserDTOByUserUser(content);
		request.setAttribute("allUserDTO", allUser);
		return "touroperator/manageUser";

	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		String username = request.getParameter("user_user").toString();
		String password = request.getParameter("user_pass").toString();
		String userType = request.getParameter("user_type").toString();
		UserDTO userObj = new UserDTO();
		userObj.setUsername(username);
		userObj.setPassword(password);
		userObj.setUserType(userType);
		userService.insertUser(userObj);

		visualUser(request);
		return "touroperator/manageUser";
	}
	
	@RequestMapping(value = "/indietro", method = RequestMethod.GET)
	public String indistro(HttpServletRequest request) {
		visualUser(request);
		return "homeTO";
	}


	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}
}
