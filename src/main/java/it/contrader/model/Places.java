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
public class Places {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPlaces;
	
	@Column(unique = true)
	private String nameplaces;
	
	private double latitude;
	
	private double longitude;
	
	private String type;
	
	@ManyToOne
	@JoinColumn(name="idCity")
	private City city;
}
