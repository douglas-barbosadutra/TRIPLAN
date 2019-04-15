package it.contrader.model;

public class Places {

	private int idPlaces;
	private String nomePlaces;
<<<<<<< HEAD

	public Places() {
	}

	public Places(int idPlaces, String nomePlaces) {
		this.idPlaces = idPlaces;
		this.nomePlaces = nomePlaces;
=======
	private String latPlaces;
	private String longPlaces;

	
	public Places(int idPlaces, String nomePlaces, String latPlaces, String longPlaces) {
		this.idPlaces = idPlaces;
		this.nomePlaces = nomePlaces;
		this.latPlaces = latPlaces;
		this.longPlaces = longPlaces;
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f
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
<<<<<<< HEAD

	@Override
	public String toString() {
		return this.getIdPlaces() + "\t" + this.getNomePlaces();
=======
	
	public String getLatPlaces() {
		return latPlaces;
	}

	public void setLatPlaces(String latPlaces) {
		this.latPlaces = latPlaces;
	}
	
	public String getLongPlaces() {
		return longPlaces;
	}

	public void setLongPlaces(String longPlaces) {
		this.longPlaces = longPlaces;
	}	
	@Override
	public String toString() {
		return this.getIdPlaces() + "\t" + this.getNomePlaces() + "\t" + this.getLatPlaces() + "\t" + this.getLongPlaces();
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f
	}

	public boolean equals(Places placesCompare) {
		if (!(this.getIdPlaces() == placesCompare.getIdPlaces())) {
			return false;
		}
		if (!this.getNomePlaces().equals(placesCompare.getNomePlaces())) {
				return false;
<<<<<<< HEAD
		}
=======
	    }
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f
		return true;

	}
}
