package it.contrader.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {

	private long idHotel;

	private String namehotel;
	
	private double latitude;
	
	private double longitude;

	private int numerostelle;

	
}
