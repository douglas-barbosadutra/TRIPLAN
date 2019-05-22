package it.contrader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Tags;


public interface TagsRepository extends CrudRepository<Tags, Integer> {

	public List<Tags> findAllByNametag(String nametag);
	
	public List<Tags> findAll();

}



