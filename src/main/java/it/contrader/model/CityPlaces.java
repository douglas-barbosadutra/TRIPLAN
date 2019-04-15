package it.contrader.model;

public class CityPlaces {

	private int City_Idcity;
	private String nomePlaces;

	public CityPlaces() {
	}

	public CityPlaces(int City_Idcity, String nomePlaces) {
		this.City_Idcity = City_Idcity;
		this.nomePlaces = nomePlaces;
	}

	public int getIdCityPlaces() {
		return City_Idcity;
	}

	public void setCity_Idcity(int City_Idcity) {
		this.City_Idcity = City_Idcity;
	}

	public String getNomePlaces() {
		return nomePlaces;
	}

	public void setNomePlaces(String nomePlaces) {
		this.nomePlaces = nomePlaces;
	}

	@Override
	public String toString() {
		return this.getIdCityPlaces() + "\t" + this.getNomePlaces();
	}

	public boolean equals(CityPlaces placesCompare) {
		if (!(this.getIdCityPlaces() == placesCompare.getIdCityPlaces())) {
			return false;
		}
		if (!this.getNomePlaces().equals(placesCompare.getNomePlaces())) {
				return false;
		}
		return true;

	}
}
