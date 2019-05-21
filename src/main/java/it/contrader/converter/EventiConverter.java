package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.EventiDTO;
import it.contrader.model.Eventi;

@Component
public class EventiConverter extends AbstractConverter<Eventi, EventiDTO> {
	
	@Autowired
	private CityConverter cityConverter;
	
	@Autowired
	private GestoreEventiConverter gestoreeventiConverter;
	
	@Override
	public Eventi toEntity(EventiDTO eventiDTO) {
		Eventi eventi = new Eventi();
		if(eventiDTO!=null) {
			eventi.setIdEvento(eventiDTO.getIdEvento());
			eventi.setNameevento(eventiDTO.getNameevento());
			eventi.setMeseevento(eventiDTO.getMeseevento());
			eventi.setCity(cityConverter.toEntity(eventiDTO.getCityDTO()));
			eventi.setGestoreeventi(gestoreeventiConverter.toEntity(eventiDTO.getGestoreeventiDTO()));			
		}
		return eventi;
	}

	
	@Override
	public EventiDTO toDTO(Eventi eventi) {
		EventiDTO eventiDTO = new EventiDTO();
		if(eventi!=null) {
			eventiDTO.setIdEvento(eventi.getIdEvento());
			eventiDTO.setNameevento(eventi.getNameevento());
			eventiDTO.setMeseevento(eventi.getMeseevento());
			eventiDTO.setCityDTO(cityConverter.toDTO(eventi.getCity()));
			eventiDTO.setGestoreeventiDTO(gestoreeventiConverter.toDTO(eventi.getGestoreeventi()));

	}
		return eventiDTO;
	}
}
