package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.SuperuserDTO;

import it.contrader.model.Superuser;

@Component
public class SuperUserConverter extends AbstractConverter<Superuser,SuperuserDTO> {

	@Override
	public Superuser toEntity(SuperuserDTO superuserDTO) {
		Superuser superuser = null;
		if (superuserDTO != null) {
			superuser = new Superuser();
			superuser.setIdUser(superuserDTO.getIdUser());
			superuser.setUsername(superuserDTO.getUsername());
			superuser.setPassword(superuserDTO.getPassword());
			superuser.setUserType(superuserDTO.getUserType());
		}
		return superuser;
	}

	@Override
	public SuperuserDTO toDTO(Superuser superuser) {
		SuperuserDTO superuserDTO = null;
		if (superuser != null) {
			superuserDTO = new SuperuserDTO();
			superuserDTO.setIdUser(superuser.getIdUser());
			superuserDTO.setUsername(superuser.getUsername());
			superuserDTO.setPassword(superuser.getPassword());
			superuserDTO.setUserType(superuser.getUserType());

		}
		return superuserDTO;
	}
}