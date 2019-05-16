package it.contrader.model;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@OnDelete(action = OnDeleteAction.CASCADE)
public class User {
	
	public enum UserType {
		SUPERUSER,
		TOUROPERATOR,
		GESTOREHOTEL,
		GESTOREEVENTI,
		TESTUSER,
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUser;
	
	@Column(unique = true)
	private String username;
	
	private String password;

	private UserType userType;

	@OneToMany (mappedBy = "user")
	private List<Eventi> eventi;
	
	@OneToMany (mappedBy = "user")
	private List<Hotel> hotel;
	
}
