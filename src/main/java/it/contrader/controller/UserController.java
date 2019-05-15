package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.LoginDTO;
import it.contrader.dto.TourOperatorDTO;
import it.contrader.dto.SuperuserDTO;
import it.contrader.dto.TestUserDTO;
import it.contrader.dto.GestoreHotelDTO;
import it.contrader.dto.GestoreEventiDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;
import it.contrader.model.User.UserType;
import it.contrader.service.TourOperatorService;
import it.contrader.service.SuperUserService;
import it.contrader.service.GestoreHotelService;
import it.contrader.service.GestoreEventiService;
import it.contrader.service.TestUserService;
import it.contrader.service.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController extends AbstractController<User, UserDTO>{
	
	@Autowired
	private UserService userService;
	@Autowired
	private SuperUserService superuserService;
	@Autowired
	private TourOperatorService touroperatorService;
	@Autowired
	private GestoreHotelService gestorehotelService;
	@Autowired
	private GestoreEventiService gestoreeventiService;
	
	//POST Angular a different DTO depending on UserType
	@PostMapping(value = "/login")
	public UserDTO login( @RequestBody LoginDTO loginDTO ) {
		UserDTO userdto = userService.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
		UserType userType = userdto.getUserType();
		switch(userType){
		case SUPERUSER:
			SuperuserDTO superuser = (SuperuserDTO) userdto.cast();
			return superuser;
		case TOUROPERATOR:
			TourOperatorDTO touroperator = (TourOperatorDTO) userdto.cast();
			return touroperator;
		case GESTOREHOTEL:
			GestoreHotelDTO gestorehotel = (GestoreHotelDTO)  userdto.cast();
			return gestorehotel;
		case GESTOREEVENTI:
			GestoreHotelDTO gestoreeventi = (GestoreHotelDTO)  userdto.cast();
			return gestoreeventi;
		case TESTUSER:
			TestUserDTO testuser = (TestUserDTO)  userdto.cast();
			return testuser;
		default: break;
		}
		return null;

	}
	
	//INSERT a different DTO depending on UserType
	@Override
	@PostMapping(value = "/insert")
	public UserDTO insert(@RequestBody UserDTO userDTO) {
		UserType userType = userDTO.getUserType();
		
		switch(userType) {
		case SUPERUSER:
			superuserService.insert((SuperuserDTO)userDTO.cast());
			break;
		case TOUROPERATOR:
			touroperatorService.insert((TourOperatorDTO)userDTO.cast());
			break;
		case GESTOREHOTEL:
			gestorehotelService.insert((GestoreHotelDTO)userDTO.cast());
			break;
		case GESTOREEVENTI:
			gestoreeventiService.insert((GestoreEventiDTO)userDTO.cast());
			break;
		default:
		}
		
		return userDTO;
	}
}