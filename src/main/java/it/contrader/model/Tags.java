package it.contrader.model;

public class Tags {

	private int idTag;
	private String name_tag;
	private String name_place_tag;
	
	public Tags() {
	}

	public Tags(int idTag, String name_tag, String name_place_tag) {
		this.idTag = idTag;
		this.name_tag = name_tag;
		this.name_place_tag = name_place_tag;
	}

	public int getIdTag() {
		return idTag;
	}

	public void setIdTag(int idTag) {
		this.idTag = idTag;
	}

	public String getName_tag() {
		return name_tag;
	}

	public void setName_tag(String name_tag) {
		this.name_tag = name_tag;
	}
	public String getName_place_tag() {
		return name_place_tag;
	}

	public void setName_place_tag(String name_place_tag) {
		this.name_place_tag = name_place_tag;
	}

	@Override
	public String toString() {
		return this.getIdTag() + "\t" + this.getName_tag() + "\t" + this.getName_place_tag();
	}

	public boolean equals(Tags tagsCompare) {
		if (!(this.getIdTag() == tagsCompare.getIdTag())) {
			return false;
		}
		if (!this.getName_tag().equals(tagsCompare.getName_tag())) {
				return false;
		}
		if (!this.getName_place_tag().equals(tagsCompare.getName_place_tag())) {
			return false;
	}
		return true;

	}
}
