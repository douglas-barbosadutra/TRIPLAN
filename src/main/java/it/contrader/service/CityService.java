package it.contrader.service;

import java.util.ArrayList;
import java.util.List;
import it.contrader.converter.ConverterCity;
import it.contrader.converter.ConverterUser;
import it.contrader.dao.CityDAO;
import it.contrader.dto.CityDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.City;
import it.contrader.model.User;

public class CityService {
	
	
private CityDAO cityDAO;

public CityService() {
	this.cityDAO = new CityDAO();
}


public List<CityDTO> getAllCity() {

	List<City> list = cityDAO.getAllCity();
	List<CityDTO> listDTO = new ArrayList<>();

	for (City city : list) {
		listDTO.add(ConverterCity.toDTO(city));
	}

	return listDTO;
}

		public  boolean insertCity(CityDTO CityDTO) {
			return this.cityDAO.insertCity(ConverterCity.toEntity(CityDTO));
		}
		
		public CityDTO readCity(int idcity) {
			return ConverterCity.toDTO(this.cityDAO.readCity(idcity));
		}
		
		public boolean updateCity(CityDTO cityDTO) {
			return this.cityDAO.updateCity(ConverterCity.toEntity(cityDTO));
		}
		
		public boolean deleteCity(int idcity) {
			return this.cityDAO.deleteCity(idcity);
		}
	
		}

	
		
		
		
	

