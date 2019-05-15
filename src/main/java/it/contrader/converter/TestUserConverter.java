package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.TestUserDTO;

import it.contrader.model.TestUser;

@Component
public class TestUserConverter extends AbstractConverter<TestUser,TestUserDTO> {

	@Override
	public TestUser toEntity(TestUserDTO testuserDTO) {
		TestUser testuser = null;
		if (testuserDTO != null) {
			testuser = new TestUser();
			testuser.setIdUser(testuserDTO.getIdUser());
			testuser.setUsername(testuserDTO.getUsername());
			testuser.setPassword(testuserDTO.getPassword());
			testuser.setUserType(testuserDTO.getUserType());
		}
		return testuser;
	}

	@Override
	public TestUserDTO toDTO(TestUser testuser) {
		TestUserDTO testuserDTO = null;
		if (testuser != null) {
			testuserDTO = new TestUserDTO();
			testuserDTO.setIdUser(testuser.getIdUser());
			testuserDTO.setUsername(testuser.getUsername());
			testuserDTO.setPassword(testuser.getPassword());
			testuserDTO.setUserType(testuser.getUserType());

		}
		return testuserDTO;
	}
}