package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.EventiDTO;
import it.contrader.services.EventiService;

import java.util.List;

@Controller
@RequestMapping("/GestoreEventi")
public class GestoreEventiController {

	private final EventiService eventiService;
	@Autowired
	private HttpSession session;

	@Autowired
	public GestoreEventiController(EventiService eventiService) {
		this.eventiService = eventiService;
	}

	private void visualEventi(HttpServletRequest request) {
		List<EventiDTO> allEventi = this.eventiService.getListaEventiDTO();
		request.setAttribute("allEventiDTO", allEventi);
	}
	
	@RequestMapping(value = "/eventiManagement", method = RequestMethod.GET)
	public String eventiManagement(HttpServletRequest request) {
		visualEventi(request);
		return "gestoreEventi/manageEvento";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.eventiService.deleteEventiById(id);
		visualEventi(request);
		return "gestoreEventi/manageEvento";
	}

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insertRedirect(HttpServletRequest request) {
		return "gestoreEventi/insertEvento";
	}

	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		EventiDTO eventiUpdate = new EventiDTO();
		// userUpdate.setUserId(id);

		eventiUpdate = this.eventiService.getEventiDTOById(id);
		request.setAttribute("eventiUpdate", eventiUpdate);
		return "gestoreEventi/updateEvento";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		Integer idEvento = Integer.parseInt(request.getParameter("idEvento"));
		String name_eventoUpdate = request.getParameter("name_evento");
		String city_eventoUpdate = request.getParameter("city_evento");
		String gestore_eventoUpdate = request.getParameter("gestore_evento");
		
		EventiDTO eventi = new EventiDTO();
		eventi.setName_evento(name_eventoUpdate);
		eventi.setCity_evento(city_eventoUpdate);
		eventi.setGestore_evento(gestore_eventoUpdate);
		eventi.setIdEvento(idEvento);

		eventiService.updateEventi(eventi);
		visualEventi(request);
		return "gestoreEventi/manageEvento";
	}

	

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		String name_evento = request.getParameter("name_evento").toString();
		String city_evento = request.getParameter("city_evento").toString();
		String gestore_evento = request.getParameter("gestore_evento").toString();
		EventiDTO eventiObj = new EventiDTO();
		eventiObj.setName_evento(name_evento);
		eventiObj.setCity_evento(city_evento);
		eventiObj.setGestore_evento(gestore_evento);
		eventiService.insertEventi(eventiObj);

		visualEventi(request);
		return "gestoreEventi/manageEvento";
	}
	
	@RequestMapping(value = "/indietro", method = RequestMethod.GET)
	public String indistro(HttpServletRequest request) {
		visualEventi(request);
		return "homeGE";
	}


	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}
}
