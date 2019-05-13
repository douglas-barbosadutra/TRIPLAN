package it.contrader.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="hotel")
public class Hotel implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	@Id
	@Column(name = "idhotel")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idhotel;
	
	@Column(name = "nomehotel")
	private String nomehotel;
	
	@Column(name = "cityhotel")
	private String cityhotel;
	
	@Column(name = "numerostelle")
	private int numerostelle;
	
	@Column(name = "latitude")
	private Double latitude;
	
	@Column(name = "longitude")
	private Double longitude;
	
	@Column(name = "gestorehotel")
	private String gestorehotel;

	
	}
	
	

	



