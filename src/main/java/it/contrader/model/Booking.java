package it.contrader.model;

public class Booking {

	private int idBooking;
	private String usernameBooking;

	public Booking() {
	}

	public Booking(int idBooking, String usernameBooking) {
		this.idBooking = idBooking;
		this.usernameBooking = usernameBooking;
	}

	public int getIdBooking() {
		return idBooking;
	}

	public void setIdBooking(int idBooking) {
		this.idBooking = idBooking;
	}

	public String getUsernameBooking() {
		return usernameBooking;
	}

	public void setUsernameBooking(String usernameBooking) {
		this.usernameBooking = usernameBooking;
	}

	@Override
	public String toString() {
		return this.getIdBooking() + "\t" + this.getUsernameBooking();
	}

	public boolean equals(Booking bookingCompare) {
		if (!(this.getIdBooking() == bookingCompare.getIdBooking())) {
			return false;
		}
		if (!this.getUsernameBooking().equals(bookingCompare.getUsernameBooking())) {
				return false;
		}
		return true;

	}
}
