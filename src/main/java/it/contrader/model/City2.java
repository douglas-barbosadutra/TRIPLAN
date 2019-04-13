package it.contrader.model;

public class City2 {

	private int idCity;
	private String name_City;

	public City2() {
	}

	public City2(int idCity, String nomeCity) {
		this.idCity = idCity;
		this.name_City = nomeCity;
	}

	public int getIdCity() {
		return idCity;
	}

	public void setIdCity(int idCity) {
		this.idCity = idCity;
	}

	public String getNomeCity() {
		return name_City;
	}

	public void setNomeCity(String nomeCity) {
		this.name_City = nomeCity;
	}

	@Override
	public String toString() {
		return this.getIdCity() + "\t" + this.getNomeCity();
	}

	public boolean equals(City2 cityCompare) {
		if (!(this.getIdCity() == cityCompare.getIdCity())) {
			return false;
		}
		if (!this.getNomeCity().equals(cityCompare.getNomeCity())) {
				return false;
		}
		return true;

	}
}
