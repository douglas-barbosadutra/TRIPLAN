package it.contrader.model;

public class Itinerary {

	private int idPlaces;
	private String nomePlaces;
	private String cityPlaces;
	private Double latitude;
	private Double longitude;
	private static final double R= 6378.1370D;
	private static final double CONVERT_DEGREE_TO_RADIANS = Math.PI/180D;

	public Itinerary() {
	}
	
	public Itinerary(int idPlaces, String nomePlaces, String cityPlaces, Double latitude, Double longitude) {
		this.idPlaces = idPlaces;
		this.nomePlaces = nomePlaces;
		this.cityPlaces = cityPlaces;
		this.latitude = latitude * CONVERT_DEGREE_TO_RADIANS;
		this.longitude = longitude * CONVERT_DEGREE_TO_RADIANS;
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
	
	public String getCPlaces() {
		return cityPlaces;
	}

	public void setCPlaces(String cityPlaces) {
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
		return this.getIdPlaces() + "\t" + this.getNomePlaces() + "\t" + this.getCPlaces()  + "\t" + this.getLatitude() + "\t" + this.getLongitude();
	}

	public boolean equals(Itinerary placesCompare) {
		if (!(this.getIdPlaces() == placesCompare.getIdPlaces())) {
			return false;
		}
		if (!this.getNomePlaces().equals(placesCompare.getNomePlaces())) {
				return false;
		}
		if (!this.getCPlaces().equals(placesCompare.getCPlaces())) {
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
	

	
	public double distanceTo(Itinerary b){
		double deltaLat = (b.latitude - this.latitude);
		double deltaLon = (b.longitude - this.longitude);
		 double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)
		            + Math.cos(this.latitude) * Math.cos(b.latitude)
		            * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
		 double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		 double distance = R * c * 1000;
		 return Math.sqrt(distance);
	}
}
