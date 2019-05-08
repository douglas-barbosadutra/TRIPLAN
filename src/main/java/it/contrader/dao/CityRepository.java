package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.contrader.utils.GestoreEccezioni;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.dto.CityDTO;
import it.contrader.model.City;


public interface CityRepository extends JpaRepository<City, Integer> {
	public List<City> findAllCityByIdCity(int idcity);
   public List<City> insertCity(int idcity);
    public List<City> deleteCity(int idcity);
    public List<City> readCity(int idcity);
    public List<City> updateCity(int idcity);

	
	
}
