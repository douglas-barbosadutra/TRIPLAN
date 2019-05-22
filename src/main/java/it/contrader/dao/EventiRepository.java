package it.contrader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Eventi;

public interface EventiRepository extends CrudRepository<Eventi, Integer> {
	public List<Eventi> findAllByNameevento(String nameevento);
	
	public List<Eventi> findAll();
}
