package it.contrader.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.CityDTO;
import it.contrader.dto.ImageDTO;
import it.contrader.dto.PlacesDTO;
import it.contrader.service.ImageService;

@CrossOrigin
@RestController
@RequestMapping("/image")
public class ImageController {

	private CityDTO cityDTO;
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

	@RequestMapping(value= "/selectImage", method = RequestMethod.POST)
    public CityDTO selectImage(@RequestParam(value = "idImage") int id) { 
    ImageDTO immagine = this.imageService.getImageDTOById(id);    
    List<ImageDTO> immagini= new ArrayList<>();
    immagini.add(immagine);
    List<ImageDTO> scelta1 = new ArrayList<>();
    List<ImageDTO> scelta2 =new ArrayList<>();
    int i;
    scelta1.add(immagini.get(0));
    for (i=0; i< immagini.size();)  { 
     if (immagini.get(i).getType()== immagini.get(i+1).getType()){ 
    		scelta1.add(immagini.get(i+1));} 
     else { 
    	  scelta2.add(immagini.get(i+1));}
	}    
    List<ImageDTO> sceltadefinitiva = new ArrayList<>();
	for(ImageDTO p : scelta1){ 
	  if (scelta1.size()>=scelta2.size()){ 
	      sceltadefinitiva.addAll(scelta1);}
	  else { 
	      sceltadefinitiva.addAll(scelta2);}
      }
    return sceltadefinitiva.get(i).getCityDTO();

   }
}

