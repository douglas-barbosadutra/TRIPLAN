package it.contrader.dao;


import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Places;

import java.util.List;


public interface PlacesRepository extends CrudRepository<Places, Integer> {

	public List<Places> findAllByNameplaces(String nameplaces);
	

}






