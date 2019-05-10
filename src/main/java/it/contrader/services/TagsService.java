package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.contrader.converter.ConverterTags;
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
		return ConverterTags.toListDTO((List<Tags>) tagsRepository.findAll());
	}

	public TagsDTO getTagsDTOById(Integer id) {
		return ConverterTags.toDTO(tagsRepository.findById(id).get()); 
	}


	public boolean insertTags(TagsDTO tagsDTO) {
		return tagsRepository.save(ConverterTags.toEntity(tagsDTO)) != null;
	}

	public boolean updateTags(TagsDTO tagsDTO) {
		return tagsRepository.save(ConverterTags.toEntity(tagsDTO)) != null;
	}
	
	public void deleteTagsById(Integer id) {
		tagsRepository.deleteById(id);
	}
	
	public List<TagsDTO> findTagsDTOByNameTag(String nametag) {
		
		final List<Tags> list = tagsRepository.findAllByNametag(nametag);
		final List<TagsDTO> tagsDTOs = new ArrayList<>();
		list.forEach(i -> tagsDTOs.add(ConverterTags.toDTO(i)));
		return tagsDTOs;
		
	
	}
}
