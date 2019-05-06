package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.CityDTO;
import it.contrader.dto.PlacesDTO;
import it.contrader.dto.TagsDTO;
import it.contrader.service.CityService;
import it.contrader.service.TagsService;


public class TagsServlet extends HttpServlet {

	private final TagsService tagsService = new TagsService();
	private List<TagsDTO> AllTagss = new ArrayList<>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);
		switch (scelta) {

		case "TagsManager":
			AllTagss = this.tagsService.getAllTags();
			request.setAttribute("AllTags", AllTagss);
			getServletContext().getRequestDispatcher("/tags/manageTags.jsp").forward(request, response);
			break;

		case "insertRedirect":
			response.sendRedirect("tags/insertTags.jsp");
			break;

		case "insert":
			final String name_tag = request.getParameter("name_tag");
			final String name_place_tag = request.getParameter("name_place_tag");
			final TagsDTO tagss = new TagsDTO(name_tag, name_place_tag);
			tagsService.insertTags(tagss);
			showAllTagss(request, response);
			break;

		case "updateRedirect":
			int id = Integer.parseInt(request.getParameter("id"));
			TagsDTO tagsUpdate = new TagsDTO("", "");
			tagsUpdate.setIdTag(id);
			tagsUpdate = this.tagsService.readTags(id);
			request.setAttribute("tagsUpdate", tagsUpdate);
			getServletContext().getRequestDispatcher("/tags/updateTags.jsp").forward(request, response);
			break;

		case "update":
			final Integer idUpdate = Integer.parseInt(request.getParameter("idtag"));
			final String nametagsUpdate = request.getParameter("name_tag");
			final String nameplacetagsUpdate = request.getParameter("name_place_tag");
			final TagsDTO tags = new TagsDTO(nametagsUpdate, nameplacetagsUpdate);
			tags.setIdTag(idUpdate);
			tagsService.updateTags(tags);
			showAllTagss(request, response);
			break;
			
		case "delete":
			final Integer deleteId = Integer.parseInt(request.getParameter("id"));
			final TagsDTO tagsdelete = new TagsDTO("","");
			tagsdelete.setIdTag(deleteId);
			tagsService.deleteTags(deleteId);
			showAllTagss(request, response);
			break;


		case "indietro":
			response.sendRedirect("homeTO.jsp");
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;

		}

	}

	private void showAllTagss(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AllTagss = this.tagsService.getAllTags();
		request.setAttribute("AllTags", AllTagss);
		getServletContext().getRequestDispatcher("/tags/manageTags.jsp").forward(request, response);
	}
}