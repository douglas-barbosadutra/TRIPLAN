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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="eventi")
	public class Eventi implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "idevento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idevento;

	@Column(name = "nameevento")
	@NotNull
	private String nameevento;

	@Column(name = "cityevento")
	@NotNull
	private String cityevento;

	@Column(name = "gestoreevento")
	@NotNull
	private String gestoreevento;

	@Column(name = "meseevento")
	@NotNull
	private String meseevento;

	@ManyToOne
	@JoinColumn(name="idCity")
	private City city;

}