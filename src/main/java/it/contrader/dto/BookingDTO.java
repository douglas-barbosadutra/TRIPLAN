package it.contrader.dto;

public class BookingDTO {

	private int idbooking;
	private String nomebooking;

	public BookingDTO(String nomebooking) {
	this.idbooking = idbooking;
	this.nomebooking = nomebooking;
		
	}

	public BookingDTO() {} 
	
	public int getIdBooking() {
		return idbooking;
	}

	public void setIdBooking(int idbooking) {
		this.idbooking = idbooking;
	}

	public String getNomeBooking() {
		return nomebooking;
	}

	public void setNomeBooking(String nomebooking) {
		this.nomebooking = nomebooking;
	}

}


