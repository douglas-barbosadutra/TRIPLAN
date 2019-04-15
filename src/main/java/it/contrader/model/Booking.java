package it.contrader.model;

public class Booking {

	private int idBooking;
<<<<<<< HEAD
	private String nomeBooking;
=======
	private String usernameBooking;
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f

	public Booking() {
	}

<<<<<<< HEAD
	public Booking(int idBooking, String nomeBooking) {
		this.idBooking = idBooking;
		this.nomeBooking = nomeBooking;
=======
	public Booking(int idBooking, String usernameBooking) {
		this.idBooking = idBooking;
		this.usernameBooking = usernameBooking;
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f
	}

	public int getIdBooking() {
		return idBooking;
	}

	public void setIdBooking(int idBooking) {
		this.idBooking = idBooking;
	}

<<<<<<< HEAD
	public String getNomeBooking() {
		return nomeBooking;
	}

	public void setNomeBooking(String nomeBooking) {
		this.nomeBooking = nomeBooking;
=======
	public String getUsernameBooking() {
		return usernameBooking;
	}

	public void setUsernameBooking(String usernameBooking) {
		this.usernameBooking = usernameBooking;
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return this.getIdBooking() + "\t" + this.getNomeBooking();
=======
		return this.getIdBooking() + "\t" + this.getUsernameBooking();
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f
	}

	public boolean equals(Booking bookingCompare) {
		if (!(this.getIdBooking() == bookingCompare.getIdBooking())) {
			return false;
		}
<<<<<<< HEAD
		if (!this.getNomeBooking().equals(bookingCompare.getNomeBooking())) {
=======
		if (!this.getUsernameBooking().equals(bookingCompare.getUsernameBooking())) {
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f
				return false;
		}
		return true;

	}
}
