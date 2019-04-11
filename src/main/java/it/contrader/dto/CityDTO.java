package it.contrader.dto;

public class CityDTO {

	private int idcity;
	private String namecity;
	

	public CityDTO(String namecity) {
		this.idcity = idcity;
		this.namecity = namecity;
		
	}
	
	public CityDTO() {} 
	
	public int getIdCity() {
		return idcity;
	}

	public void setIdCity(int idcity) {
		this.idcity = idcity;
	}

	public String getNameCity() {
		return namecity;
	}

	public void setNameCity(String namecity) {
		this.namecity = namecity;
	}

}


