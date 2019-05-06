package it.contrader.dto;

import it.contrader.model.Places;

public class PlacesDTO {

	private int idplaces;
	private String name_places;
	private String city_places;
	private Double latitude;
	private Double longitude;
	private int idCityPlaces;
	private static final double R= 6378.1370D;
	private static final double CONVERT_DEGREE_TO_RADIANS = Math.PI/180D;
	
	public PlacesDTO(String name_places, String city_places, Double latitude, Double longitude) {
		this.idplaces = idplaces;
		this.name_places = name_places;
		this.city_places = city_places;
		this.latitude = latitude*CONVERT_DEGREE_TO_RADIANS;
		this.longitude = longitude*CONVERT_DEGREE_TO_RADIANS;
	    
	}
	
	public PlacesDTO() {} 
	
	public int getIdPlaces() {
		return idplaces;
	}

	public void setIdPlaces(int idplaces) {
		this.idplaces = idplaces;
	}

	public String getNomePlaces() {
		return name_places;
	}

	public void setNomePlaces(String name_places) {
		this.name_places = name_places;
	}
	
	public String getCityPlaces() {
		return city_places;
	}

	public void setCPlaces(String city_places) {
		this.city_places = city_places;
	}
	
	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public int getIdCityPlaces() {
		return idCityPlaces;
	}

	public void setIdCityPlaces(int idCityPlaces) {
		this.idCityPlaces = idCityPlaces;
	}

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



