package it.contrader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Hotel;


public interface HotelRepository extends CrudRepository<Hotel, Integer> {

	public List<Hotel> findAllByNamehotel(String namehotel);
	
	public List<Hotel> findAll();

}



