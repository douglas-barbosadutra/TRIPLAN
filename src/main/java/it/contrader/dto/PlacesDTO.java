package it.contrader.dto;

public class PlacesDTO {

	private int idplaces;
	private String nomeplaces;
<<<<<<< HEAD
	

	public PlacesDTO(String nomeplaces) {
		this.idplaces = idplaces;
		this.nomeplaces = nomeplaces;
		
=======
	private String latplaces;
	private String longplaces;

	public PlacesDTO(String nomeplaces, String latplaces, String longplaces) {
		this.idplaces = idplaces;
		this.nomeplaces = nomeplaces;
		this.latplaces = latplaces;
		this.longplaces = longplaces;
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f
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
<<<<<<< HEAD

=======
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
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f
}


