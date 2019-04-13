package it.contrader.dto;

public class PlacesDTO {

	private int idplaces;
	private String nomeplaces;
	private double latplaces;
	private double longplaces;

	public PlacesDTO(String nomeplaces) {
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
	public double getLatPlaces() {
		return latplaces;
	}

	public void setLatPlaces(double latplaces) {
		this.latplaces = latplaces;
	}
	public double getLongPlaces() {
		return longplaces;
	}

	public void setLongPlaces(double longplaces) {
		this.longplaces = longplaces;
	}
}


