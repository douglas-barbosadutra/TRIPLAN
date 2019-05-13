package it.contrader.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="places")
	public class Places implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "idPlaces")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPlaces;

	@Column(name = "nameplaces")
	@NotNull
	private String nameplaces;

	@Column(name = "cityplaces")
	@NotNull
	private String cityplaces;
	
	@Column(name = "latitude")
	@NotNull
	private Double latitude;

	@Column(name = "longitude")
	@NotNull
	private Double longitude;
	
	@Column(name = "cityidcity")
	@NotNull
	private Integer cityidcity;
	
	@Column(name = "type")
	@NotNull
	private String type;
}