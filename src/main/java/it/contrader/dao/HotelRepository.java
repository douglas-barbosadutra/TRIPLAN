package it.contrader.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import it.contrader.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

	public Hotel findByNomeHotel(String nomehotel);
	
}