package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/showUser" , method= RequestMethod.GET)
	public List<UserDTO> showUser() {		
		return userService.getAllUsers();
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "idUser") int id) {
		this.userService.deleteUserById(id);
	}

	@RequestMapping(value="/insertUser", method= RequestMethod.POST)
	public UserDTO insertUser(@RequestBody UserDTO user) {
		return userService.insertUser(user);
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
	public void update(@RequestBody UserDTO user) {
		userService.updateUser(user);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public UserDTO loginControl(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		final UserDTO userDTO = userService.getUserByUsernameAndPassword(username, password);
		final String userType = userDTO.getUserType();
		if (!StringUtils.isEmpty(userType)) {
			return userDTO;
		}
		return null;
	}
}

