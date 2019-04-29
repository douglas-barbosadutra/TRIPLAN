package it.contrader.model;

public class Places {

	private int idPlaces;
	private String nomePlaces;
	private String cityPlaces;
	private Double latitude;
	private Double longitude;

	public Places() {
	}

	public Places(int idPlaces, String nomePlaces, String cityPlaces, Double latitude, Double longitude) {
		this.idPlaces = idPlaces;
		this.nomePlaces = nomePlaces;
		this.cityPlaces = cityPlaces;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getIdPlaces() {
		return idPlaces;
	}

	public void setIdPlaces(int idPlaces) {
		this.idPlaces = idPlaces;
	}

	public String getNomePlaces() {
		return nomePlaces;
	}

	public void setNomePlaces(String nomePlaces) {
		this.nomePlaces = nomePlaces;
	}
	
	public String getCityPlaces() {
		return cityPlaces;
	}

	public void setCityPlaces(String cityPlaces) {
		this.cityPlaces = cityPlaces;
	}
	
	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return this.getIdPlaces() + "\t" + this.getNomePlaces() + "\t" + this.getCityPlaces()  + "\t" + this.getLatitude() + "\t" + this.getLongitude();
	}

	public boolean equals(Places placesCompare) {
		if (!(this.getIdPlaces() == placesCompare.getIdPlaces())) {
			return false;
		}
		if (!this.getNomePlaces().equals(placesCompare.getNomePlaces())) {
				return false;
		}
		if (!this.getCityPlaces().equals(placesCompare.getCityPlaces())) {
			return false;
		}
		if (!this.getLatitude().equals(placesCompare.getLatitude())) {
			return false;
		}
		if (!this.getLongitude().equals(placesCompare.getLongitude())) {
			return false;
		}
		return true;

	}
}
