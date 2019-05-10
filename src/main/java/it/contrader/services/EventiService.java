package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.contrader.converter.ConverterEventi;
import it.contrader.dao.EventiRepository;
import it.contrader.dto.EventiDTO;
import it.contrader.model.Eventi;

@Service
public class EventiService {

	private final EventiRepository eventiRepository;

	@Autowired
	public EventiService(EventiRepository eventiRepository) {
		this.eventiRepository = eventiRepository;
	}

	public List<EventiDTO> getListaEventiDTO() {
		return ConverterEventi.toListDTO((List<Eventi>) eventiRepository.findAll());
	}

	public EventiDTO getEventiDTOById(Integer id) {
		return ConverterEventi.toDTO(eventiRepository.findById(id).get()); 
	}


	public boolean insertEventi(EventiDTO eventiDTO) {
		return eventiRepository.save(ConverterEventi.toEntity(eventiDTO)) != null;
	}

	public boolean updateEventi(EventiDTO eventiDTO) {
		return eventiRepository.save(ConverterEventi.toEntity(eventiDTO)) != null;
	}
	
	public void deleteEventiById(Integer id) {
		eventiRepository.deleteById(id);
	}
	
	public List<EventiDTO> findEventiDTOByNameevento(String nameevento) {
		
		final List<Eventi> list = eventiRepository.findAllByNameevento(nameevento);
		final List<EventiDTO> eventiDTOs = new ArrayList<>();
		list.forEach(i -> eventiDTOs.add(ConverterEventi.toDTO(i)));
		return eventiDTOs;
		
	
	}
}
