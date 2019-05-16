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
	
	private List<PlacesDTO> placesDTO;
	
	private List<EventiDTO> eventiDTO;
	
	private List<HotelDTO> hotelDTO;
	
}
