package it.contrader.model;

public class Places2 {

	private int idPlaces;
	private String nomePlaces;
	
	public Places2(int idPlaces, String nomePlaces) {
		this.idPlaces = idPlaces;
		this.nomePlaces = nomePlaces;
	}

	public Places2() {
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

	public boolean equals(Places2 placesCompare) {
		if (!(this.getIdPlaces() == placesCompare.getIdPlaces())) {
			return false;
		}
		if (!this.getNomePlaces().equals(placesCompare.getNomePlaces())) {
				return false;
	    }
		return true;

	}

<<<<<<< HEAD
=======
	public void setIdPlaces2(int idPlaces2) {
		// TODO Auto-generated method stub
		
	}
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f
}
