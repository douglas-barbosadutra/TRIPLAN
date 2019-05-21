package it.contrader.dto;


import java.util.Date;
import java.util.List;

import it.contrader.model.User.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EventiDTO {

	private long idEvento;
	
	private String nameevento;
	
	private String meseevento;
	
	private CityDTO cityDTO;
	
	private GestoreEventiDTO gestoreeventiDTO;	
}
	
	