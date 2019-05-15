package it.contrader.dao;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import it.contrader.model.GestoreHotel;
import it.contrader.dao.MyRepository;


@Repository
@Transactional
public interface GestoreHotelRepository extends MyRepository<GestoreHotel, Long> {

	// TODO This should be not necessary
	@Override
	@Query(value = "SELECT * FROM #{#entityName} e", nativeQuery = true)
	List<GestoreHotel>findAllBy(Long id);
}
