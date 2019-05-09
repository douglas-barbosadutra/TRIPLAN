package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.EventiDTO;
import it.contrader.dto.EventiDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Eventi;
import it.contrader.model.Eventi;
import it.contrader.model.User;

public class ConverterEventi {

	public static EventiDTO toDTO(Eventi eventi) {
		EventiDTO eventiDTO = null;
		if (eventi != null) {
			eventiDTO = new EventiDTO();
			eventiDTO.setIdEvento(eventi.getIdEvento());
			eventiDTO.setName_evento(eventi.getName_evento());
			eventiDTO.setCity_evento(eventi.getCity_evento());
			eventiDTO.setGestore_evento(eventi.getGestore_evento());
			
			}
		return eventiDTO;
	}
	
	public static Eventi toEntity(EventiDTO eventiDTO) {
		Eventi eventi = null;
		if (eventiDTO != null) {
			eventi = new Eventi();
			eventi.setIdEvento(eventiDTO.getIdEvento());
			eventi.setName_evento(eventiDTO.getName_evento());
			eventi.setCity_evento(eventiDTO.getCity_evento());
			eventi.setGestore_evento(eventiDTO.getGestore_evento());
			
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
	
