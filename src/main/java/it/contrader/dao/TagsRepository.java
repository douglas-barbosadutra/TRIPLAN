package it.contrader.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Tags;


import java.util.List;


public interface TagsRepository extends CrudRepository<Tags, Integer> {

	public List<Tags> findAllByNametag(String nametag);
	

}



