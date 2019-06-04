package it.contrader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.City;

public interface CityRepository extends CrudRepository<City, Integer> {

	public List<City> findAllByNamecity(String namecity);
	
	public List<City> findAll();

}



