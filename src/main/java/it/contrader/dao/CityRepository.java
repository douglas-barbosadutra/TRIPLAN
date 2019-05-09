package it.contrader.dao;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import it.contrader.dto.CityDTO;
import it.contrader.model.City;


public interface CityRepository extends JpaRepository<City, Integer> {
	public List<CityDTO> findAllCityByIdCity(int idcity);
    
	
	
}
