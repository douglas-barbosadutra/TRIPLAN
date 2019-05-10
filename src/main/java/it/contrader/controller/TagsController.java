package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.TagsDTO;
import it.contrader.services.TagsService;

import java.util.List;

@Controller
@RequestMapping("/Tags")
public class TagsController {

	private final TagsService tagsService;
	@Autowired
	private HttpSession session;

	@Autowired
	public TagsController(TagsService tagsService) {
		this.tagsService = tagsService;
	}

	private void visualTags(HttpServletRequest request) {
		List<TagsDTO> allTags = this.tagsService.getListaTagsDTO();
		request.setAttribute("allTagsDTO", allTags);
	}
	
	@RequestMapping(value = "/tagsManagement", method = RequestMethod.GET)
	public String cityManagement(HttpServletRequest request) {
		visualTags(request);
		return "tags/manageTags";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.tagsService.deleteTagsById(id);
		visualTags(request);
		return "tags/manageTags";
	}

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insertRedirect(HttpServletRequest request) {
		return "tags/insertTags";
	}

	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		TagsDTO tagsUpdate = new TagsDTO();
		tagsUpdate = this.tagsService.getTagsDTOById(id);
		request.setAttribute("tagsUpdate", tagsUpdate);
		return "tags/updateTags";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		Integer idUpdate = Integer.parseInt(request.getParameter("idtag"));
		String nametagUpdate = request.getParameter("nametag");
		String nameplacetagUpdate = request.getParameter("nameplacetag");

		TagsDTO tags = new TagsDTO();
		tags.setNametag(nametagUpdate);
		tags.setNameplacetag(nameplacetagUpdate);
		tags.setIdtag(idUpdate);
		tagsService.updateTags(tags);
		visualTags(request);
		return "tags/manageTags";
	}


	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		String nametag = request.getParameter("nametag").toString();
		String nameplacetag = request.getParameter("nameplacetag").toString();
		TagsDTO tagsObj = new TagsDTO();
		tagsObj.setNametag(nametag);
		tagsObj.setNameplacetag(nameplacetag);
		tagsService.insertTags(tagsObj);
		visualTags(request);
		return "tags/manageTags";
	}
	
	@RequestMapping(value = "/indietro", method = RequestMethod.GET)
	public String indistro(HttpServletRequest request) {;
		return "homeTO";
	}


	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}
}

