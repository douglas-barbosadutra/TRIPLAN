package it.contrader.dto;

public class TagsDTO {

	private int idtag;
	private String name_tag;
	private String name_place_tag;

	public TagsDTO(String name_tag, String name_place_tag) {
		this.idtag = idtag;
		this.name_tag = name_tag;
		this.name_place_tag = name_place_tag;
	}
	
	
	public TagsDTO() {

	}


	public int getIdTag() {
		return idtag;
	}

	public void setIdTag(int idtag) {
		this.idtag = idtag;
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
}


