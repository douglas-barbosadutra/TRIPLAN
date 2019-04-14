package it.contrader.dto;

public class PlacesDTO {

	private int idplaces;
	private String nomeplaces;
	private String latplaces;
	private String longplaces;

	public PlacesDTO(String nomeplaces, String latplaces, String longplaces) {
		this.idplaces = idplaces;
		this.nomeplaces = nomeplaces;
		this.latplaces = latplaces;
		this.longplaces = longplaces;
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
	public String getLatPlaces() {
		return latplaces;
	}

	public void setLatPlaces(String latplaces) {
		this.latplaces = latplaces;
	}
	public String getLongPlaces() {
		return longplaces;
	}

	public void setLongPlaces(String longplaces) {
		this.longplaces = longplaces;
	}
}


