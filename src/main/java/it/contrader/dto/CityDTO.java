package it.contrader.dto;

public class CityDTO {

	private int idcity;
	private String name_city;
	

	public CityDTO(String name_city) {
		this.idcity = idcity;
		this.name_city = name_city;
		
	}
	
	public CityDTO() {} 
	
	public int getIdCity() {
		return idcity;
	}

	public void setIdCity(int idcity) {
		this.idcity = idcity;
	}

	public String getName_City() {
		return name_city;
	}

	public void setName_City(String name_city) {
		this.name_city = name_city;
	}

}


