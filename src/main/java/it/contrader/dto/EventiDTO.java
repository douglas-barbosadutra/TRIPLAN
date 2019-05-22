package it.contrader.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EventiDTO {

	private Integer idEvento;
	
	private String nameevento;
	
	private String meseevento;
	
	private CityDTO cityDTO;
	
	private UserDTO userDTO;

}
	
	