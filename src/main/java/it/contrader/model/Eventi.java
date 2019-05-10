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
}