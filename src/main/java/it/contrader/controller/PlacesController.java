package it.contrader.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.PlacesDTO;
import it.contrader.service.PlacesService;

@CrossOrigin
@RestController
@RequestMapping("/Places")
public class PlacesController {

	private final PlacesService placesService;

	@Autowired
	public PlacesController(PlacesService placesService) {
		this.placesService = placesService;
	}
	
	@RequestMapping(value="/showPlaces" , method= RequestMethod.GET)
	public List<PlacesDTO> showPlaces() {		
		return placesService.getAllPlaces();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "idCity") int id) {
		this.placesService.deletePlacesById(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
		public void update(@RequestBody PlacesDTO places) {
			placesService.updatePlaces(places);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody PlacesDTO places) {
		placesService.insertPlaces(places);
	}


	@RequestMapping(value= "/SelectPlaces",method = RequestMethod.GET)
	public List<PlacesDTO> SelectPlaces(@RequestParam(value = "idCity") int id) {
	    int idCity =Integer.parseInt(("idCity"));
	    List<PlacesDTO> selectCityplaces = this.placesService.findAllByIdCity(idCity);
	    return selectCityplaces;}

	@RequestMapping(value= "/Itinerary",method = RequestMethod.GET)
	public List<PlacesDTO> Itinerary(@RequestBody List<PlacesDTO> selectCityplaces) {
		   int i;   
		   List<PlacesDTO> Itinerary = new ArrayList<>();
		   for (i=0; i< selectCityplaces.size(); i++) {
			       if (selectCityplaces.get(i).getFascia()== 1 ||selectCityplaces.get(i).getFascia()==4){
				      Integer durata=0;
			    	  durata= durata + selectCityplaces.get(i).getDurata();
			    	  while(durata <=180) {
				           Itinerary.add(selectCityplaces.get(i));}}
			       Itinerary = this.placesService.getItinerary(Itinerary);
			       if (selectCityplaces.get(i).getFascia()== 2) {
		                Itinerary.add(selectCityplaces.get(i)); }
		           
				   if (selectCityplaces.get(i).getFascia()== 1 ||selectCityplaces.get(i).getFascia()==4){
					   Integer durata=0;
				    	  durata= durata + selectCityplaces.get(i).getDurata();
				    	  while(durata <=180) {
					           Itinerary.add(selectCityplaces.get(i));}}
				   Itinerary = this.placesService.getItinerary(Itinerary);
				   
				   if (selectCityplaces.get(i).getFascia()== 2) {
		                Itinerary.add(selectCityplaces.get(i)); }
		   
				   if (selectCityplaces.get(i).getFascia()== 3 ||selectCityplaces.get(i).getFascia()==4){
					   Itinerary.add(selectCityplaces.get(i));}
				   
				   }
		   return Itinerary;}}
		   
	











