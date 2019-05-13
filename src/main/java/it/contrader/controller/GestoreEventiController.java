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
		return "gestoreeventi/manageEventi";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.eventiService.deleteEventiById(id);
		visualEventi(request);
		return "gestoreeventi/manageEventi";
	}

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insertRedirect(HttpServletRequest request) {
		return "gestoreeventi/insertEventi";
	}

	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		EventiDTO eventiUpdate = new EventiDTO();
		

		eventiUpdate = this.eventiService.getEventiDTOById(id);
		request.setAttribute("eventiUpdate", eventiUpdate);
		return "gestoreeventi/updateEventi";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		Integer idUpdate = Integer.parseInt(request.getParameter("idevento"));
		String nameeventoUpdate = request.getParameter("nameevento");
		String cityeventoUpdate = request.getParameter("cityevento");
		String gestoreeventoUpdate = request.getParameter("gestoreevento");
		String meseevento= request.getParameter("meseevento").toString();
		EventiDTO eventi = new EventiDTO();
		eventi.setNameevento(nameeventoUpdate);
		eventi.setCityevento(cityeventoUpdate);
		eventi.setGestoreevento(gestoreeventoUpdate);
		eventi.setIdevento(idUpdate);
        eventi.setMeseevento(meseevento);
		eventiService.updateEventi(eventi);
		visualEventi(request);
		return "gestoreeventi/manageEventi";
	}

	

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		String nameevento = request.getParameter("nameevento").toString();
		String cityevento = request.getParameter("cityevento").toString();
		String gestoreevento = request.getParameter("gestoreevento").toString();
		String meseevento= request.getParameter("meseevento").toString();
		EventiDTO eventiObj = new EventiDTO();
		eventiObj.setNameevento(nameevento);
		eventiObj.setCityevento(cityevento);
		eventiObj.setGestoreevento(gestoreevento);
		eventiObj.setMeseevento(meseevento);
		eventiService.insertEventi(eventiObj);

		visualEventi(request);
		return "gestoreeventi/manageEventi";
	}
	
	@RequestMapping(value ="/eventi", method = RequestMethod.GET)
	public String eventi(HttpServletRequest request) {
		visualEventi(request);
		return "itinerary/Eventiconsigliati";
	}
	
	@RequestMapping(value ="/viaggia", method = RequestMethod.GET)
	public String indietro(HttpServletRequest request) {
		visualEventi(request);
		return "homeUser";
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
