package it.contrader.model;

public class Booking {

	private int idBooking;
	private String nomeBooking;

	public Booking() {
	}

	public Booking(int idBooking, String nomeBooking) {
		this.idBooking = idBooking;
		this.nomeBooking = nomeBooking;
	}

	public int getIdBooking() {
		return idBooking;
	}

	public void setIdBooking(int idBooking) {
		this.idBooking = idBooking;
	}

	public String getNomeBooking() {
		return nomeBooking;
	}

	public void setNomeBooking(String nomeBooking) {
		this.nomeBooking = nomeBooking;
	}

	@Override
	public String toString() {
		return this.getIdBooking() + "\t" + this.getNomeBooking();
	}

	public boolean equals(Booking bookingCompare) {
		if (!(this.getIdBooking() == bookingCompare.getIdBooking())) {
			return false;
		}
		if (!this.getNomeBooking().equals(bookingCompare.getNomeBooking())) {
				return false;
		}
		return true;

	}
}
