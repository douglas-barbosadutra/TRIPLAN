package it.contrader.model;

import java.sql.Date;
import java.text.DateFormat;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBooking;

	@Column(unique = true)
	
	private String username;
	
	private String citybook;	
	
	private Date datefrom;
	
	private Date dateto;
	
	private Integer costo;
	
	private Integer indice;
	
	private Integer people;

	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;

	@ManyToOne
	@JoinColumn(name="idCity")
	private City city;

	
}
