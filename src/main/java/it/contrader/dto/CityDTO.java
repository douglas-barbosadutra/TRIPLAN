package it.contrader.dto;
import java.util.List;

import it.contrader.model.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data public class CityDTO {

	private int idcity;
	
	private String name_city;
	
    private String stato;
}
           



