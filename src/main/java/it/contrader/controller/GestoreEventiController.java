package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.EventiDTO;
import it.contrader.service.EventiService;

@Controller
@RequestMapping("/GestoreEventi")
public class GestoreEventiController {

	private final EventiService eventiService;

	@Autowired
	public GestoreEventiController(EventiService eventiService) {
		this.eventiService = eventiService;
	}
	
	@RequestMapping(value = "/eventiManagement", method = RequestMethod.GET)
	public List<EventiDTO> eventiManagement() {
	return this.eventiService.findAllEventiDTO();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "idEventi") int id) {
		this.eventiService.deleteEventiById(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
		public void update(@RequestBody EventiDTO eventi) {
			eventiService.updateEventi(eventi);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody EventiDTO eventi) {
		eventiService.insertEventi(eventi);
	}
}
