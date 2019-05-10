package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Eventi;

import java.util.List;

public interface EventiRepository extends CrudRepository<Eventi, Integer> {

	
	public List<Eventi> findAllByNameevento(String nameevento);
}
