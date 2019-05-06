package it.contrader.service;

import java.util.ArrayList;
import java.util.List;
import it.contrader.converter.ConverterCity;
import it.contrader.converter.ConverterTags;
import it.contrader.converter.ConverterUser;
import it.contrader.dao.CityDAO;
import it.contrader.dao.TagsDAO;
import it.contrader.dto.CityDTO;
import it.contrader.dto.TagsDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.City;
import it.contrader.model.Tags;
import it.contrader.model.User;

public class TagsService {
	
	
private TagsDAO tagsDAO;

public TagsService() {
	this.tagsDAO = new TagsDAO();
}


public List<TagsDTO> getAllTags() {

	List<Tags> list = tagsDAO.getAllTags();
	List<TagsDTO> listDTO = new ArrayList<>();

	for (Tags tags : list) {
		listDTO.add(ConverterTags.toDTO(tags));
	}

	return listDTO;
}

		public  boolean insertTags(TagsDTO TagsDTO) {
			return this.tagsDAO.insertTags(ConverterTags.toEntity(TagsDTO));
		}
		
		public TagsDTO readTags(int idtag) {
			return ConverterTags.toDTO(this.tagsDAO.readTags(idtag));
		}
		
		public boolean updateTags(TagsDTO tagsDTO) {
			return this.tagsDAO.updateTags(ConverterTags.toEntity(tagsDTO));
		}
		
		public boolean deleteTags(int idtag) {
			return this.tagsDAO.deleteTags(idtag);
		}
	
		}

	
		
		
		
	

