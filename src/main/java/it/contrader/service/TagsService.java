package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.TagsConverter;
import it.contrader.dao.TagsRepository;
import it.contrader.dto.TagsDTO;
import it.contrader.model.Tags;

@Service
public class TagsService {

	private final TagsRepository tagsRepository;

	@Autowired
	public TagsService(TagsRepository tagsRepository) {
		this.tagsRepository = tagsRepository;
	}

	public List<TagsDTO> getListaTagsDTO() {
		return TagsConverter.toListDTO((List<Tags>) tagsRepository.findAll());
	}

	public TagsDTO getTagsDTOById(Integer id) {
		return TagsConverter.toDTO(tagsRepository.findById(id).get()); 
	}


	public boolean insertTags(TagsDTO tagsDTO) {
		return tagsRepository.save(TagsConverter.toEntity(tagsDTO)) != null;
	}

	public boolean updateTags(TagsDTO tagsDTO) {
		return tagsRepository.save(TagsConverter.toEntity(tagsDTO)) != null;
	}
	
	public void deleteTagsById(Integer id) {
		tagsRepository.deleteById(id);
	}
	
	public List<TagsDTO> findAllTagsDTO() {

		List<Tags> list = tagsRepository.findAll();
		List<TagsDTO> tagsDTOs = new ArrayList<>();
		list.forEach(i -> tagsDTOs.add(TagsConverter.toDTO(i)));
		return tagsDTOs;
	}
}
