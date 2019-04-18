package it.contrader.model;

public class City {

	private int idCity;
	private String nomeCity;

	public City() {
	}

	public City(int idCity, String nomeCity) {
		this.idCity = idCity;
		this.nomeCity = nomeCity;
	}

	public int getIdCity() {
		return idCity;
	}

	public void setIdCity(int idCity) {
		this.idCity = idCity;
	}

	public String getNomeCity() {
		return nomeCity;
	}

	public void setNomeCity(String nomeCity) {
		this.nomeCity = nomeCity;
	}

	@Override
	public String toString() {
		return this.getIdCity() + "\t" + this.getNomeCity();
	}

	public boolean equals(City cityCompare) {
		if (!(this.getIdCity() == cityCompare.getIdCity())) {
			return false;
		}
		if (!this.getNomeCity().equals(cityCompare.getNomeCity())) {
				return false;
		}
		return true;

	}
}
