package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.TourOperatorDTO;

import it.contrader.model.TourOperator;

@Component
public class TourOperatorConverter extends AbstractConverter<TourOperator,TourOperatorDTO> {

	@Override
	public TourOperator toEntity(TourOperatorDTO touroperatorDTO) {
		TourOperator touroperator = null;
		if (touroperatorDTO != null) {
			touroperator = new TourOperator();
			touroperator.setIdUser(touroperatorDTO.getIdUser());
			touroperator.setUsername(touroperatorDTO.getUsername());
			touroperator.setPassword(touroperatorDTO.getPassword());
			touroperator.setUserType(touroperatorDTO.getUserType());
		}
		return touroperator;
	}

	@Override
	public TourOperatorDTO toDTO(TourOperator touroperator) {
		TourOperatorDTO touroperatorDTO = null;
		if (touroperator != null) {
			touroperatorDTO = new TourOperatorDTO();
			touroperatorDTO.setIdUser(touroperator.getIdUser());
			touroperatorDTO.setUsername(touroperator.getUsername());
			touroperatorDTO.setPassword(touroperator.getPassword());
			touroperatorDTO.setUserType(touroperator.getUserType());

		}
		return touroperatorDTO;
	}
}