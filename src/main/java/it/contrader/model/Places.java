package it.contrader.model;

import java.util.Date;

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
public class Places {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPlaces;
	
	@Column(unique = true)
	private String nameplaces;
	
	private String cityplaces;

	private double latitude;
	
	private double longitude;
	
	private String type;
	
	@ManyToOne
	@JoinColumn(name="idCity")
	private City city;
}
