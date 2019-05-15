package it.contrader.dto;

import it.contrader.model.User.UserType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class GestoreHotelDTO extends UserDTO {
	
	public GestoreHotelDTO(long idUser, String username, String password, UserType userType) {
		super(idUser, username, password, userType);
	}
}

