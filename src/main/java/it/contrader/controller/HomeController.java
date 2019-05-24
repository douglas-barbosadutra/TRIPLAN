package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.UserDTO;
import it.contrader.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/Home")
public class HomeController {

	private final UserService userService;
	
	private HttpSession session;

	@Autowired
	HomeController(UserService userService) {
		this.userService=userService;
		;
	}
	
	@RequestMapping(value = "/homesu", method = RequestMethod.GET)
	public String homeAdmin(HttpServletRequest request) {
		List<UserDTO> allUser = this.userService.getListaUserDTO();
		request.setAttribute("allUserDTO", allUser);
		return "homesu";
	}

}
