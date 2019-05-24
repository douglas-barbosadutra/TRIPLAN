package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.UserDTO;
import it.contrader.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/Touroperator")
public class TourOperatorController {

	private final UserService userService;

	@Autowired
	public TourOperatorController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/showUser" , method= RequestMethod.GET)
	public List<UserDTO> showUser() {		
		return userService.getAllUsers();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "idUser") int id) {
		this.userService.deleteUserById(id);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody UserDTO user) {
		userService.insertUser(user);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody UserDTO user) {
		userService.updateUser(user);
	}
	
}