package it.contrader.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;

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
public class Eventi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEvento;
	
	@Column(unique = true)
	private String nameevento;
	
	private String meseevento;

	
	@ManyToOne
	@JoinColumn(name="namecity")
	private City city;
	
	@ManyToOne
	@JoinColumn(name="username")
	private User user;
}
