package it.contrader.model;

public class Places {

	private int idPlaces;
	private String nomePlaces;
	private double latPlaces;
	private double longPlaces;
	
	public Places(int idPlaces, String nomePlaces, double latPlaces, double longPlaces) {
		this.idPlaces = idPlaces;
		this.nomePlaces = nomePlaces;
		this.latPlaces = latPlaces;
		this.longPlaces = longPlaces;
	}

	public Places() {
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
	
	public double getLatPlaces() {
		return latPlaces;
	}

	public void setLatPlaces(double latPlaces) {
		this.latPlaces = latPlaces;
	}
	
	public double getLongPlaces() {
		return longPlaces;
	}

	public void setLongPlaces(double longPlaces) {
		this.longPlaces = longPlaces;
	}	
	@Override
	public String toString() {
		return this.getIdPlaces() + "\t" + this.getNomePlaces() + "\t" + this.getLatPlaces() + "\t" + this.getLongPlaces();
	}

	public boolean equals(Places placesCompare) {
		if (!(this.getIdPlaces() == placesCompare.getIdPlaces())) {
			return false;
		}
		if (!this.getNomePlaces().equals(placesCompare.getNomePlaces())) {
				return false;
	    }
		return true;

	}
}
