package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Eventi;

import java.util.List;

public interface EventiRepository extends CrudRepository<Eventi, Integer> {

	public Eventi findEventiByName_evento(String name_evento);
	public List<Eventi> findAllByName_evento(String name_evento);
}
