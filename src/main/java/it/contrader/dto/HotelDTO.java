package it.contrader.dto;

public class HotelDTO {
	private int idHotel;
	private String nomeHotel;
	private String cityHotel;
	private int numeroStelle;
	public Double latitude;
	public Double longitude;
	private String gestoreHotel;



	public HotelDTO(String nomeHotel, String cityHotel, int numeroStelle, Double latitude, Double longitude, String gestoreHotel) {
		this.nomeHotel = nomeHotel;
		this.cityHotel = cityHotel;
		this.numeroStelle = numeroStelle;
		this.latitude = latitude;
		this.longitude = longitude;
		this.gestoreHotel = gestoreHotel;
	}
	
	public HotelDTO() {}

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
}
