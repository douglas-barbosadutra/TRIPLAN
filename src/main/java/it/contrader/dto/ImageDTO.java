package it.contrader.dto;

import java.util.List;

import org.hibernate.type.BlobType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ImageDTO {

	private Integer idImage;
	
	private String image;
	
	private String type;

	private CityDTO cityDTO;
	}