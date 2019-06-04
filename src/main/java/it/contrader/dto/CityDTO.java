package it.contrader.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {

	private Integer idCity;

	private String namecity;
	
	private String type;
	
	private List<PlacesDTO> placesDTO;
	
	private List<BookingDTO> bookingDTO;
	
}
