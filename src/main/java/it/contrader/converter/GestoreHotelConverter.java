package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.GestoreHotelDTO;

import it.contrader.model.GestoreHotel;

@Component
public class GestoreHotelConverter extends AbstractConverter<GestoreHotel,GestoreHotelDTO> {

	@Override
	public GestoreHotel toEntity(GestoreHotelDTO gestorehotelDTO) {
		GestoreHotel gestorehotel = null;
		if (gestorehotelDTO != null) {
			gestorehotel = new GestoreHotel();
			gestorehotel.setIdUser(gestorehotelDTO.getIdUser());
			gestorehotel.setUsername(gestorehotelDTO.getUsername());
			gestorehotel.setPassword(gestorehotelDTO.getPassword());
			gestorehotel.setUserType(gestorehotelDTO.getUserType());
		}
		return gestorehotel;
	}

	@Override
	public GestoreHotelDTO toDTO(GestoreHotel gestorehotel) {
		GestoreHotelDTO gestorehotelDTO = null;
		if (gestorehotel != null) {
			gestorehotelDTO = new GestoreHotelDTO();
			gestorehotelDTO.setIdUser(gestorehotel.getIdUser());
			gestorehotelDTO.setUsername(gestorehotel.getUsername());
			gestorehotelDTO.setPassword(gestorehotel.getPassword());
			gestorehotelDTO.setUserType(gestorehotel.getUserType());

		}
		return gestorehotelDTO;
	}
}