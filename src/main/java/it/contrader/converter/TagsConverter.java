package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.TagsDTO;
import it.contrader.model.Tags;

public class TagsConverter {

	public static TagsDTO toDTO(Tags tags) {
		TagsDTO tagsDTO = null;
		if (tags != null) {
			tagsDTO = new TagsDTO();
			tagsDTO.setIdTag(tags.getIdtag());
			tagsDTO.setNametag(tags.getNametag());
			tagsDTO.setNameplacetag(tags.getNameplacetag());

		}
		return tagsDTO;
	}

	public static Tags toEntity(TagsDTO tagsDTO) {
		Tags tags = null;
		if (tagsDTO != null) {
			tags = new Tags();
			tags.setIdtag(tagsDTO.getIdTag());
			tags.setNametag(tagsDTO.getNametag());
		    tags.setNameplacetag(tagsDTO.getNameplacetag());
		}
		return tags;
	}

	public static List<TagsDTO> toListDTO(List<Tags> list) {
		List<TagsDTO> listTagsDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Tags tags : list) {
				listTagsDTO.add(TagsConverter.toDTO(tags));
			}
		}
		return listTagsDTO;
	}

	public static List<Tags> toListEntity(List<TagsDTO> listTagsDTO) {
		List<Tags> list = new ArrayList<>();
		if (!listTagsDTO.isEmpty()) {
			for (TagsDTO tagsDTO : listTagsDTO) {
				list.add(TagsConverter.toEntity(tagsDTO));
			}
		}
		return list;
	}
}
