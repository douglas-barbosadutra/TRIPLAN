package it.contrader.dto;

import it.contrader.model.User.UserType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class TourOperatorDTO extends UserDTO {
	
	public TourOperatorDTO(long idUser, String username, String password, UserType userType) {
		super(idUser, username, password, userType);
	}
}

