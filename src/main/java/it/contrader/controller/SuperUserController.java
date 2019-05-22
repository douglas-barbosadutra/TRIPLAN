package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.UserDTO;
import it.contrader.service.UserService;

@Controller
@RequestMapping("/Superuser")
public class SuperUserController {

	private final UserService userService;

	@Autowired
	public SuperUserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/touroperatorManagement", method = RequestMethod.GET)
	public List<UserDTO> touroperatorManagement() {
	return this.userService.findAllUserDTO();
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

