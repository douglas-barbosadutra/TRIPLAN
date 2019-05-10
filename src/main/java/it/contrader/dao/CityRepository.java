package it.contrader.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.contrader.model.City;
import it.contrader.model.User;

import java.util.List;


public interface CityRepository extends CrudRepository<City, Integer> {

	public List<City> findAllByNamecity(String namecity);
	

}



