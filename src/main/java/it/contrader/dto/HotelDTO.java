package it.contrader.dto;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {
	
	private int idhotel;
	
	private String nomehotel;
	
	private String cityhotel;
	
	private int numerostelle;
	
	private double latitude;
	
	private double longitude;
	
	private String gestorehotel;

	
	
	
}
