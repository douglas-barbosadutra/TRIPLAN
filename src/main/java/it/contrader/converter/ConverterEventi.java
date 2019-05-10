package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.EventiDTO;
import it.contrader.model.Eventi;

public class ConverterEventi {

	public static EventiDTO toDTO(Eventi eventi) {
		EventiDTO eventiDTO = null;
		if (eventi != null) {
			eventiDTO = new EventiDTO();
			eventiDTO.setIdevento(eventi.getIdevento());
			eventiDTO.setNameevento(eventi.getNameevento());
			eventiDTO.setCityevento(eventi.getCityevento());
			eventiDTO.setGestoreevento(eventi.getGestoreevento());
		}
		return eventiDTO;
	}

	public static Eventi toEntity(EventiDTO eventiDTO) {
		Eventi eventi = null;
		if (eventiDTO != null) {
			eventi = new Eventi();
			eventi.setIdevento(eventiDTO.getIdevento());
			eventi.setNameevento(eventiDTO.getNameevento());
			eventi.setCityevento(eventiDTO.getCityevento());;
			eventi.setGestoreevento(eventiDTO.getGestoreevento());
		}
		return eventi;
	}

	public static List<EventiDTO> toListDTO(List<Eventi> list) {
		List<EventiDTO> listEventiDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Eventi eventi : list) {
				listEventiDTO.add(ConverterEventi.toDTO(eventi));
			}
		}
		return listEventiDTO;
	}

	public static List<Eventi> toListEntity(List<EventiDTO> listEventiDTO) {
		List<Eventi> list = new ArrayList<>();
		if (!listEventiDTO.isEmpty()) {
			for (EventiDTO eventiDTO : listEventiDTO) {
				list.add(ConverterEventi.toEntity(eventiDTO));
			}
		}
		return list;
	}
}
	
