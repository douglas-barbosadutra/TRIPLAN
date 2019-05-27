package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.PlacesDTO;
import it.contrader.dto.TagsDTO;
import it.contrader.service.TagsService;

@CrossOrigin
@RestController
@RequestMapping("/Tags")
public class TagsController {
	
	private final TagsService tagsService;

	@Autowired
	public TagsController(TagsService tagsService) {
		this.tagsService = tagsService;
	}
	
	@RequestMapping(value="/showTgas" , method= RequestMethod.GET)
	public List<TagsDTO> showTags() {		
		return tagsService.getAllTags();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "idTag") int id) {
		this.tagsService.deleteTagsById(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
		public void update(@RequestBody TagsDTO tags) {
			tagsService.updateTags(tags);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody TagsDTO tags) {
		tagsService.insertTags(tags);
	}
}


