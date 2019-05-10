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
@Table(name="city")
	public class City implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "idCity")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCity;

	@Column(name = "namecity")
	@NotNull
	private String namecity;

	@Column(name = "state")
	@NotNull
	private String state;

}