package it.contrader.service;

import java.util.List;
import it.contrader.converter.ConverterPlaces;
import it.contrader.dao.PlacesDAO;
<<<<<<< HEAD
import it.contrader.dto.CityPlacesDTO;
import it.contrader.dto.PlacesDTO;
import it.contrader.model.Places;
=======
import it.contrader.dto.PlacesDTO;
import it.contrader.model.Places;
import it.contrader.model.Places2;
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f

public class PlacesService {
	
	
private PlacesDAO placesDAO;

		public PlacesService() {
			this.placesDAO = new PlacesDAO();
		}

		public List<Places> getAllPlaces() {
			return this.placesDAO.getAllPlaces();
		}
<<<<<<< HEAD

=======
		
		public List<Places2> getSelectPlaces() {
			return this.placesDAO.getSelectPlaces();
		}
		
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f
		public boolean insertPlaces(PlacesDTO placesDTO) {
			return this.placesDAO.insertPlaces(ConverterPlaces.toEntity(placesDTO));
		}
		
		public PlacesDTO readPlaces(int idplaces) {
			return ConverterPlaces.toDTO(this.placesDAO.readPlaces(idplaces));
		}
<<<<<<< HEAD
		
=======

>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f
		public boolean updatePlaces(PlacesDTO placesDTO) {
			return this.placesDAO.updatePlaces(ConverterPlaces.toEntity(placesDTO));
		}
		
		public boolean deletePlaces(int idplaces) {
			return this.placesDAO.deletePlaces(idplaces);
<<<<<<< HEAD
		}
		
}
=======
		}		
	}
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f

