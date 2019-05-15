package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.GestoreEventiDTO;

import it.contrader.model.GestoreEventi;

@Component
public class GestoreEventiConverter extends AbstractConverter<GestoreEventi,GestoreEventiDTO> {

	@Override
	public GestoreEventi toEntity(GestoreEventiDTO gestoreeventiDTO) {
		GestoreEventi gestoreeventi = null;
		if (gestoreeventiDTO != null) {
			gestoreeventi = new GestoreEventi();
			gestoreeventi.setIdUser(gestoreeventiDTO.getIdUser());
			gestoreeventi.setUsername(gestoreeventiDTO.getUsername());
			gestoreeventi.setPassword(gestoreeventiDTO.getPassword());
			gestoreeventi.setUserType(gestoreeventiDTO.getUserType());
		}
		return gestoreeventi;
	}

	@Override
	public GestoreEventiDTO toDTO(GestoreEventi gestoreeventi) {
		GestoreEventiDTO gestoreeventiDTO = null;
		if (gestoreeventi != null) {
			gestoreeventiDTO = new GestoreEventiDTO();
			gestoreeventiDTO.setIdUser(gestoreeventi.getIdUser());
			gestoreeventiDTO.setUsername(gestoreeventi.getUsername());
			gestoreeventiDTO.setPassword(gestoreeventi.getPassword());
			gestoreeventiDTO.setUserType(gestoreeventi.getUserType());

		}
		return gestoreeventiDTO;
	}
}