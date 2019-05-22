package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {

	private Integer idHotel;

	private String namehotel;
	
	private double latitude;
	
	private double longitude;

	private int numerostelle;
	
	private CityDTO cityDTO;

	private UserDTO userDTO;


}
