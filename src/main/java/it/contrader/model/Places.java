package it.contrader.model;

public class Places {

	private int idPlaces;
	private String nomePlaces;

	public Places() {
	}

	public Places(int idPlaces, String nomePlaces) {
		super();
		this.idPlaces = idPlaces;
		this.nomePlaces = nomePlaces;
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

	@Override
	public String toString() {
		return this.getIdPlaces() + "\t" + this.getNomePlaces();
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
