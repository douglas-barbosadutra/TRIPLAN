package it.contrader.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name="tags")
	public class Tags implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "idtag")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idtag;

	@Column(name = "nametag")
	@NotNull
	private String nametag;

	@Column(name = "nameplacetag")
	@NotNull
	private String nameplacetag;
	
	@ManyToMany
	@JoinColumn(name="idPlaces")
	private Places places;

}