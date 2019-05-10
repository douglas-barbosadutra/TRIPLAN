package it.contrader.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlacesDTO {

	private Integer idPlaces;

	private String nameplaces;
	
	private String cityplaces;
	
	private Double latitude;
	
	private Double longitude;
	
	private Integer cityidcity;
}
