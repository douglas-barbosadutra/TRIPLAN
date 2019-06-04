package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import it.contrader.dto.ImageDTO;
import it.contrader.model.Image;

@Component
public class ImageConverter  {

	public static Image toEntity(ImageDTO imageDTO) {
		Image image = null;
		if (imageDTO != null) {
			image = new Image();
			image.setIdImage(imageDTO.getIdImage());
			image.setImage(imageDTO.getImage());
			image.setType(imageDTO.getType());
		}
		return image;
	}

	public static ImageDTO toDTO(Image image) {
		ImageDTO imageDTO = null;
		if (image != null) {
			imageDTO = new ImageDTO();
			imageDTO.setIdImage(image.getIdImage());
			imageDTO.setImage(image.getImage());
			imageDTO.setType(image.getType());
		}
		return imageDTO;
	}
	public static List<ImageDTO> toListDTO(List<Image> list) {
		List<ImageDTO> listImageDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Image image : list) {
				listImageDTO.add(ImageConverter.toDTO(image));
			}
		}
		return listImageDTO;
	}

	public static List<Image> toListEntity(List<ImageDTO> listImageDTO) {
		List<Image> list = new ArrayList<>();
		if (!listImageDTO.isEmpty()) {
			for (ImageDTO imageDTO : listImageDTO) {
				list.add(ImageConverter.toEntity(imageDTO));
			}
		}
		return list;
	}
}