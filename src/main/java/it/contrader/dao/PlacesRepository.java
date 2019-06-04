package it.contrader.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;


import it.contrader.model.Places;


public interface PlacesRepository extends CrudRepository<Places, Integer> {

	public List<Places> findAll();

}






