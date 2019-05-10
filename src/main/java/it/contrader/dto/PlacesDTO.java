package it.contrader.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlacesDTO {
	private static final double R= 6378.1370D;
	private static final double CONVERT_DEGREE_TO_RADIANS = Math.PI/180D;

	private Integer idPlaces;

	private String nameplaces;
	
	private String cityplaces;
	
	private Double latitude;
	
	private Double longitude;
	
	private Integer cityidcity;

public double distanceTo(PlacesDTO y){
	double deltaLat = (y.latitude - this.latitude);
	double deltaLon = (y.longitude - this.longitude);
	 double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)
	            + Math.cos(this.latitude) * Math.cos(y.latitude)
	            * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
	 double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	 double distance = R * c * 1000;
	 return Math.sqrt(distance);
}
}