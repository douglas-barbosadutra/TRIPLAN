package it.contrader.dto;

public class CityPlacesDTO {

	private int city_idcity;
	private String nomeplaces;
	

	public CityPlacesDTO(String nomeplaces) {
		this.city_idcity = city_idcity;
		this.nomeplaces = nomeplaces;
		
	}
	
	public CityPlacesDTO() {} 
	
	public int getCity_Idcity() {
		return city_idcity;
	}

	public void setCity_Idcity(int city_idcity) {
		this.city_idcity = city_idcity;
	}

	public String getNomePlaces() {
		return nomeplaces;
	}

	public void setNomePlaces(String nomeplaces) {
		this.nomeplaces = nomeplaces;
	}

}


