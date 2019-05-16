package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import it.contrader.dto.PlacesDTO;
import it.contrader.model.Places;


@Service
public class PlacesService extends AbstractService<Places, PlacesDTO> {
	
	public List<PlacesDTO> getItinerary(List<PlacesDTO> places) {
		List<PlacesDTO> itinerary = new ArrayList<>();
		double bestDistance;
		int posX = 0;
		itinerary.add(places.get(0));
		if (places.size() > 1) {
			while (places.size() > 1) {
				posX = 0;
				bestDistance = 999999999999.00;
				for (int i = 1; i < places.size(); i++) {
					if (places.get(0).distanceTo(places.get(i)) < bestDistance) {					
						bestDistance = places.get(0).distanceTo(places.get(i));
						posX = i;
					}else {
						
					}
				}
				itinerary.add(places.get(posX));
				PlacesDTO trovato = places.get(posX);
				places.remove(trovato);
				places.set(0, trovato);
				
			}
		}
		
		return itinerary;
	}
	
	
	
	
	//ALL crud methods in AbstractService
}
