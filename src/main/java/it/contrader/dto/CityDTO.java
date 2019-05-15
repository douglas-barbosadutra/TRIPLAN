package it.contrader.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {

	private long idCity;

	private String namecity;
	
	private String state;
	
	
	private PlacesDTO placesDTO;
	private EventiDTO eventiDTO;
	private HotelDTO hotelDTO;
	
	
}
