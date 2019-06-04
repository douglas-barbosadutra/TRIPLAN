package it.contrader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer> {

	
	public List<Booking> findAll();

}



