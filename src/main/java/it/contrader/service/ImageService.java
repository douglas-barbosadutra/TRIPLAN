package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ImageConverter;
import it.contrader.converter.PlacesConverter;
import it.contrader.dao.ImageRepository;
import it.contrader.dto.ImageDTO;
import it.contrader.dto.PlacesDTO;
import it.contrader.model.Image;
import it.contrader.model.Places;

@Service
public class ImageService {

	private final ImageRepository imageRepository;

	@Autowired
	public ImageService(ImageRepository imageRepository) {
		this.imageRepository = imageRepository;
	}

	public List<ImageDTO> getListaImageDTO() {
		return ImageConverter.toListDTO((List<Image>) imageRepository.findAll());
	}

	public ImageDTO getImageDTOById(Integer id) {
		return ImageConverter.toDTO(imageRepository.findById(id).get()); 
	}

	public ImageDTO insertImage(ImageDTO imageDTO) {
		Image image = ImageConverter.toEntity(imageDTO);
		imageRepository.saveAndFlush(image);
		return ImageConverter.toDTO(image);
	}

	public boolean updateImage(ImageDTO imageDTO) {
		return imageRepository.save(ImageConverter.toEntity(imageDTO)) != null;
	}
	
	public void deleteImageById(Integer id) {
		imageRepository.deleteById(id);
	}
	
	public List<ImageDTO> getAllImages(){
		return ImageConverter.toListDTO(imageRepository.findAll());
	}
    
	
	}
