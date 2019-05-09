package it.contrader.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="eventi")
	public class Eventi{
	
	@Id
	@Column(name = "idEvento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEvento;

	@Column(name = "name_evento")
	@NotNull
	private String name_evento;

	@Column(name = "city_evento")
	@NotNull
	private String city_evento;

	@Column(name = "gestore_evento")
	@NotNull
	private String gestore_evento;
	
	@ManyToOne
	@JoinColumn(name = "idcity")
	private City city;
	
	@ManyToOne
	@JoinColumn(name = "iduser")
	private User user;

}
