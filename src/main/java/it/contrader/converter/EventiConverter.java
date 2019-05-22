package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.EventiDTO;
import it.contrader.model.Eventi;

@Component
public class EventiConverter {
	
	@Autowired
	private static CityConverter cityConverter;
	
	@Autowired
	private static UserConverter userConverter;
	
	public static Eventi toEntity(EventiDTO eventiDTO) {
		Eventi eventi = new Eventi();
		if(eventiDTO!=null) {
			eventi.setIdEvento(eventiDTO.getIdEvento());
			eventi.setNameevento(eventiDTO.getNameevento());
			eventi.setMeseevento(eventiDTO.getMeseevento());
			eventi.setCity(cityConverter.toEntity(eventiDTO.getCityDTO()));
			eventi.setUser(userConverter.toEntity(eventiDTO.getUserDTO()));			
		}
		return eventi;
	}

	
	public static EventiDTO toDTO(Eventi eventi) {
		EventiDTO eventiDTO = new EventiDTO();
		if(eventi!=null) {
			eventiDTO.setIdEvento(eventi.getIdEvento());
			eventiDTO.setNameevento(eventi.getNameevento());
			eventiDTO.setMeseevento(eventi.getMeseevento());
			eventiDTO.setCityDTO(cityConverter.toDTO(eventi.getCity()));
			eventiDTO.setUserDTO(userConverter.toDTO(eventi.getUser()));

	}
		return eventiDTO;
	}
	public static List<EventiDTO> toListDTO(List<Eventi> list) {
		List<EventiDTO> listEventiDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Eventi eventi : list) {
				listEventiDTO.add(EventiConverter.toDTO(eventi));
			}
		}
		return listEventiDTO;
	}

	public static List<Eventi> toListEntity(List<EventiDTO> listEventiDTO) {
		List<Eventi> list = new ArrayList<>();
		if (!listEventiDTO.isEmpty()) {
			for (EventiDTO eventiDTO : listEventiDTO) {
				list.add(EventiConverter.toEntity(eventiDTO));
			}
		}
		return list;
	}
}