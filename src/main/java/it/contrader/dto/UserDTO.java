package it.contrader.dto;

import java.util.Date;
import it.contrader.model.User.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {

	private long idUser;
	
	private String username;
	
	private String password;

	private UserType userType;

	
	public UserDTO cast() {
		UserDTO userDTO;
		switch (userType){
		case SUPERUSER:
			userDTO = new SuperuserDTO();
			break;
		case TOUROPERATOR:
			userDTO = new TourOperatorDTO();
			break;
		case GESTOREHOTEL:
			userDTO = new GestoreHotelDTO();
			break;
		case GESTOREEVENTI: 
			userDTO = new GestoreEventiDTO();
			break;
		case TESTUSER: 
			userDTO = new TestUserDTO();
			break;
		default:
			userDTO = null;
		}
		
		userDTO.setIdUser(idUser);
		userDTO.setUsername(username);
		userDTO.setPassword(password);
		userDTO.setUserType(userType);
		
		return userDTO;
	}
}
