package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	private Integer idEvento;
	
	@Column(unique = true)
	private String nameevento;
	
	private String meseevento;
	
	@ManyToOne
	@JoinColumn(name="idCity")
	private City city;

	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;

}
