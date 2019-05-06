package it.contrader.model;

public class Hotel {

	private int idHotel;
	private String nomeHotel;
	private String cityHotel;
	private int numeroStelle;
	public Double latitude;
	public Double longitude;
	private String gestoreHotel;
	private static final double R= 6378.1370D;
	private static final double CONVERT_DEGREE_TO_RADIANS = Math.PI/180D;

	public Hotel() {
	}
	
	public Hotel(String nomeHotel, String cityHotel, int numeroStelle, Double latitude, Double longitude, String gestoreHotel) {
		this.idHotel = idHotel;
		this.nomeHotel = nomeHotel;
		this.cityHotel = cityHotel;
		this.numeroStelle = numeroStelle;
		this.latitude = latitude * CONVERT_DEGREE_TO_RADIANS;
		this.longitude = longitude * CONVERT_DEGREE_TO_RADIANS;
		this.gestoreHotel = gestoreHotel;
	}

	public int getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}

	public String getNomeHotel() {
		return nomeHotel;
	}

	public void setNomeHotel(String nomeHotel) {
		this.nomeHotel = nomeHotel;
	}
	
	public String getCityHotel() {
		return cityHotel;
	}

	public void setCityHotel(String cityHotel) {
		this.cityHotel = cityHotel;
	}
	
	public int getNumeroStelle() {
		return numeroStelle;
	}

	public void setNumeroStelle(int numeroStelle) {
		this.numeroStelle = numeroStelle;
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
	
	public String getGestoreHotel() {
		return gestoreHotel;
	}
	
	public void setGestoreHotel(String gestoreHotel) {
		this.gestoreHotel = gestoreHotel;
	}

	
	@Override
	public String toString() {
		return this.getIdHotel() + "\t" + this.getNomeHotel() + "\t" + this.getCityHotel() + "\t" + this.getNumeroStelle()  + "\t" + this.getLatitude() + "\t" + this.getLongitude() + "\t" + this.getGestoreHotel();
	}

	public boolean equals(Hotel hotelCompare) {
		if (!(this.getIdHotel() == hotelCompare.getIdHotel())) {
			return false;
		}
		
		if (!this.getNomeHotel().equals(hotelCompare.getNomeHotel())) {
				return false;
		}
		
		if (!this.getCityHotel().equals(hotelCompare.getCityHotel())) {
			return false;
		}
		
		if (!(this.getNumeroStelle() == hotelCompare.getNumeroStelle())) {
			return false;
		}
		
		if (!this.getLatitude().equals(hotelCompare.getLatitude())) {
			return false;
		}
		
		if (!this.getLongitude().equals(hotelCompare.getLongitude())) {
			return false;
		}
		
		if (!this.getGestoreHotel().equals(hotelCompare.getGestoreHotel())) {
			return false;
		}
		
		return true;

	}
	

	
	public double distanceTo(Hotel b){
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
