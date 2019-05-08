package it.contrader.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@Table(name="city")
	public class City {
		
		
    	
    	
    	
    	
    	@Id
		@Column(name = "idcity")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int idcity;
		
		@Column(name = "name_city")
		private String name_city;
		
	    @Column(name = "stato")
		private String stato;

		
		}
		
		
	


	

