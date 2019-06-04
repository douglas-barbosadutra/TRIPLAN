package it.contrader.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {

	private Integer idUser;
	
	private String username;
	
	private String password;

	private String userType;

	}