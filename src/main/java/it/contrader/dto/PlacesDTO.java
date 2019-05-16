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

public class PlacesDTO {

	private long idPlaces;
	
	private String nameplaces;
	
	private String cityplaces;

	private double latitude;
	
	private double longitude;
	
	private String type;
	
	private CityDTO cityDTO;

}
	
	