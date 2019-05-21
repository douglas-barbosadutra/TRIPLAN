package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.TestuserDTO;

import it.contrader.model.Testuser;

@Component
public class TestuserConverter extends AbstractConverter<Testuser,TestuserDTO> {

	@Override
	public Testuser toEntity(TestuserDTO testuserDTO) {
		Testuser testuser = null;
		if (testuserDTO != null) {
			testuser = new Testuser();
			testuser.setIdUser(testuserDTO.getIdUser());
			testuser.setUsername(testuserDTO.getUsername());
			testuser.setPassword(testuserDTO.getPassword());
			testuser.setUserType(testuserDTO.getUserType());
		}
		return testuser;
	}

	@Override
	public TestuserDTO toDTO(Testuser testuser) {
		TestuserDTO testuserDTO = null;
		if (testuser != null) {
			testuserDTO = new TestuserDTO();
			testuserDTO.setIdUser(testuser.getIdUser());
			testuserDTO.setUsername(testuser.getUsername());
			testuserDTO.setPassword(testuser.getPassword());
			testuserDTO.setUserType(testuser.getUserType());

		}
		return testuserDTO;
	}
}