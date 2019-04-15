package it.contrader.dto;

public class BookingDTO {

	private int idbooking;
<<<<<<< HEAD
	private String nomebooking;

	public BookingDTO(String nomebooking) {
	this.idbooking = idbooking;
	this.nomebooking = nomebooking;
=======
	private String usernamebooking;

	public BookingDTO(String usernamebooking) {
	this.idbooking = idbooking;
	this.usernamebooking = usernamebooking;
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f
		
	}

	public BookingDTO() {} 
	
	public int getIdBooking() {
		return idbooking;
	}

	public void setIdBooking(int idbooking) {
		this.idbooking = idbooking;
	}

<<<<<<< HEAD
	public String getNomeBooking() {
		return nomebooking;
	}

	public void setNomeBooking(String nomebooking) {
		this.nomebooking = nomebooking;
=======
	public String getUsernameBooking() {
		return usernamebooking;
	}

	public void setUsernameBooking(String usernamebooking) {
		this.usernamebooking = usernamebooking;
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f
	}

}


