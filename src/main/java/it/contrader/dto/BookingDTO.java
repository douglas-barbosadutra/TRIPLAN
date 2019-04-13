package it.contrader.dto;

public class BookingDTO {

	private int idbooking;
	private String usernamebooking;

	public BookingDTO(String usernamebooking) {
	this.idbooking = idbooking;
	this.usernamebooking = usernamebooking;
		
	}

	public BookingDTO() {} 
	
	public int getIdBooking() {
		return idbooking;
	}

	public void setIdBooking(int idbooking) {
		this.idbooking = idbooking;
	}

	public String getUsernameBooking() {
		return usernamebooking;
	}

	public void setUsernameBooking(String usernamebooking) {
		this.usernamebooking = usernamebooking;
	}

}


