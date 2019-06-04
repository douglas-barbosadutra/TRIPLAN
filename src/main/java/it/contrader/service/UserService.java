package it.contrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.UserConverter;
import it.contrader.dao.UserRepository;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;

@Service
public class UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<UserDTO> getListaUserDTO() {
		return UserConverter.toListDTO((List<User>) userRepository.findAll());
	}

	public UserDTO getUserDTOById(Integer id) {
		return UserConverter.toDTO(userRepository.findById(id).get()); 
	}

	public UserDTO getUserByUsernameAndPassword(String username, String password) {
		final User user = userRepository.findUserByUsernameAndPassword(username, password);
		return UserConverter.toDTO(user);
	}

	public UserDTO insertUser(UserDTO userDTO) {
		User user = UserConverter.toEntity(userDTO);
		userRepository.saveAndFlush(user);
		return UserConverter.toDTO(user);
	}

	public boolean updateUser(UserDTO userDTO) {
		return userRepository.save(UserConverter.toEntity(userDTO)) != null;
	}
	
	public void deleteUserById(Integer id) {
		userRepository.deleteById(id);
	}
	
	public List<UserDTO> getAllUsers(){
		return UserConverter.toListDTO(userRepository.findAll());
	}
}
