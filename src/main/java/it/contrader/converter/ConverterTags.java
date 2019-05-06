package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.CityDTO;
import it.contrader.dto.TagsDTO;
import it.contrader.model.City;
import it.contrader.model.Tags;

public class ConverterTags {

	public static TagsDTO toDTO(Tags tags) {
		TagsDTO tagsDTO = null;
		if (tags != null) {
			tagsDTO = new TagsDTO();
			tagsDTO.setIdTag(tags.getIdTag());
			tagsDTO.setName_tag(tags.getName_tag());
			tagsDTO.setName_place_tag(tags.getName_place_tag());
		}
		return tagsDTO;
	}

	public static Tags toEntity(TagsDTO tagsDTO) {
		Tags tags = null;
		if (tagsDTO != null) {
			tags = new Tags();
			tags.setIdTag(tagsDTO.getIdTag());
			tags.setName_tag(tagsDTO.getName_tag());
			tags.setName_place_tag(tagsDTO.getName_place_tag());
		}
		return tags;
	}

	public static List<TagsDTO> toListDTO(List<Tags> list) {
		List<TagsDTO> listTagsDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Tags tags : list) {
				listTagsDTO.add(ConverterTags.toDTO(tags));
			}
		}
		return listTagsDTO;
	}

	public static List<Tags> toListEntity(List<TagsDTO> listTagsDTO) {
		List<Tags> list = new ArrayList<>();
		if (!listTagsDTO.isEmpty()) {
			for (TagsDTO tagsDTO : listTagsDTO) {
				list.add(ConverterTags.toEntity(tagsDTO));
			}
		}
		return list;
	}
}
