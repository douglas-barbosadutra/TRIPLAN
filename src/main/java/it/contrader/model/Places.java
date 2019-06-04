package it.contrader.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	private Integer idplaces;
	
	@Column(unique = true)
	private String nameplaces;
	
	private String cityplaces;

	private String category;
    
	private Integer costo ;
	
	private Double latitude;
	
	private Double longitude;
	
	private Integer durata;
	
	private Integer fascia;
	
	@ManyToOne
	@JoinColumn(name="idCity")
	private City city;


}
