package it.contrader.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@Entity
public class GestoreEventi extends User {

	@OneToMany (mappedBy = "gestoreeventi")
	private List<Eventi> eventi;
	
}
