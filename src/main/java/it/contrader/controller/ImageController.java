package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.ImageDTO;
import it.contrader.service.ImageService;

@CrossOrigin
@RestController
@RequestMapping("/image")
public class ImageController {

	private final ImageService imageService;

	@Autowired
	public ImageController(ImageService imageService) {
		this.imageService = imageService;
	}
	
	@RequestMapping(value="/showImage" , method= RequestMethod.GET)
	public List<ImageDTO> showImage() {		
		return imageService.getAllImages();
	}

	@RequestMapping(value = "/deleteImage", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "idImage") int id) {
		this.imageService.deleteImageById(id);
	}

	@RequestMapping(value="/insertImage", method= RequestMethod.POST)
	public ImageDTO insertImage(@RequestBody ImageDTO image) {
		return imageService.insertImage(image);
	}

	@RequestMapping(value="/updateImage" , method= RequestMethod.PUT)
	public ImageDTO showImage(@RequestBody ImageDTO image) {		
		return imageService.insertImage(image);
	}

}

