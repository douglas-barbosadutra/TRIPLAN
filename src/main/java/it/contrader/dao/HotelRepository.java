package it.contrader.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import it.contrader.model.Hotel;
import java.util.List;


public interface HotelRepository extends CrudRepository<Hotel, Integer> {

	public List<Hotel> findAllByNomehotel(String nomehotel);
	

}



