package it.contrader.dto;

public class PlacesDTO {

	private int idplaces;
	private String name_places;
	private String city_places;
	private Double latitude;
	private Double longitude;
	
	public PlacesDTO(String name_places, String city_places, Double latitude, Double longitude) {
		this.idplaces = idplaces;
		this.name_places = name_places;
		this.city_places = city_places;
		this.latitude = latitude;
		this.longitude = longitude;
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

	public void setCityPlaces(String city_places) {
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
}


