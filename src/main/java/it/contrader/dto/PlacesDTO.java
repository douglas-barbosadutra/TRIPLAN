package it.contrader.dto;

public class PlacesDTO {

	private int idplaces;
	private String name_places;
	

	public PlacesDTO(String name_places) {
		this.idplaces = idplaces;
		this.name_places = name_places;
		
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

}


