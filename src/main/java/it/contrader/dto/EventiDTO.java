package it.contrader.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventiDTO {

	private Integer idEvento;

	private String name_evento;
	
	private String city_evento;

	private String gestore_evento;
	
	
}
