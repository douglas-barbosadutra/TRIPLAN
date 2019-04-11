package it.contrader.service;

import java.util.List;
import it.contrader.converter.ConverterCity;
import it.contrader.dao.CityDAO;
import it.contrader.dto.CityDTO;
import it.contrader.model.City;

public class CityService {
	
	
private CityDAO cityDAO;

		public CityService() {
			this.cityDAO = new CityDAO();
		}

		public List<City> getAllCity() {
			return this.cityDAO.getAllCity();
		}

		public boolean insertCity(CityDTO CityDTO) {
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

