package it.contrader.dto;

public class PlacesDTO {

	private int idplaces;
	private String nomeplaces;
	

	public PlacesDTO(String nomeplaces) {
		this.idplaces = idplaces;
		this.nomeplaces = nomeplaces;
		
	}
	
	public PlacesDTO() {} 
	
	public int getIdPlaces() {
		return idplaces;
	}

	public void setIdPlaces(int idplaces) {
		this.idplaces = idplaces;
	}

	public String getNomePlaces() {
		return nomeplaces;
	}

	public void setNomePlaces(String nomeplaces) {
		this.nomeplaces = nomeplaces;
	}

}


