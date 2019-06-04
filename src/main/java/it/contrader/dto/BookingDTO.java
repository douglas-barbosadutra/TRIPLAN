package it.contrader.dto;

import java.text.DateFormat;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {

	private Integer idBooking;

	private String username;
	
	private String citybook;
	
	private DateFormat datefrom;
	
	private DateFormat dateto;
	
	private Integer costo;
	
	private Integer indice;
	
	private Integer people;
	
	private CityDTO cityDTO;
	
	private UserDTO userDTO;
	
	
	
	

	
}
