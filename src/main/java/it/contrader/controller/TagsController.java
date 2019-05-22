package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.TagsDTO;
import it.contrader.service.TagsService;

@Controller
@RequestMapping("/Tags")
public class TagsController {
	
	private final TagsService tagsService;

	@Autowired
	public TagsController(TagsService tagsService) {
		this.tagsService = tagsService;
	}
	
	@RequestMapping(value = "/cityManagement", method = RequestMethod.GET)
	public List<TagsDTO> eventiManagement() {
	return this.tagsService.findAllTagsDTO();
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


