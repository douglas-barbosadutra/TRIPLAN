package it.contrader.dto;


import java.util.Date;
import it.contrader.model.User.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PlacesDTO {

	private long idPlaces;
	
	private String nameplaces;
	
	private String cityplaces;

	private double latitude;
	
	private double longitude;
	
	private String type;
	
	List<CityDTO> cityDTO;
	
	
	
	
	private Date birthdate;
	
	private String ccc;
	
	private boolean paymentStatus;
	
	public PlacesDTO cast() {
		PlacesDTO userDTO;
		switch (userType){
		case SUPERUSER:
			userDTO = new SuperuserDTO();
			break;
		case OPERATOR:
			userDTO = new OperatorDTO();
			break;
		case TUTOR:
			userDTO = new TutorDTO();
			break;
		case TESTUSER: 
			userDTO = new TestuserDTO();
			break;
		default:
			userDTO = null;
		}
		
		userDTO.setId(id);
		userDTO.setUsername(username);
		userDTO.setPassword(password);
		userDTO.setUserType(userType);
		userDTO.setName(name);
		userDTO.setSurname(surname);
		userDTO.setEmail(email);
		userDTO.setAddress(address);
		userDTO.setTelnumber(telnumber);
		userDTO.setBirthdate(birthdate);
		userDTO.setCcc(ccc);
		userDTO.setPaymentStatus(paymentStatus);
		
		return userDTO;
	}
}
