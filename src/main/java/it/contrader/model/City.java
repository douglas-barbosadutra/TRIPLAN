package it.contrader.model;

public class City {

	private int idCity;
	private String nameCity;

	public City() {
	}

	public City(int idCity, String nameCity) {
		this.idCity = idCity;
		this.nameCity = nameCity;
	}

	public int getIdCity() {
		return idCity;
	}

	public void setIdCity(int idCity) {
		this.idCity = idCity;
	}

	public String getNameCity() {
		return nameCity;
	}

	public void setNameCity(String nameCity) {
		this.nameCity = nameCity;
	}

	@Override
	public String toString() {
		return this.getIdCity() + "\t" + this.getNameCity();
	}

	public boolean equals(City cityCompare) {
		if (!(this.getIdCity() == cityCompare.getIdCity())) {
			return false;
		}
		if (!this.getNameCity().equals(cityCompare.getNameCity())) {
				return false;
		}
		return true;

	}
}
