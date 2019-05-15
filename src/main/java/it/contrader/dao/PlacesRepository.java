package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.contrader.model.Places;
import it.contrader.model.User;
import it.contrader.dao.MyRepository;

@Repository
@Transactional
public interface PlacesRepository extends MyRepository<User, Long>{
	
	// TODO This should be not necessary
	@Override
	@Query(value = "SELECT * FROM #{#entityName} e WHERE e.idCity = ?1", nativeQuery = true)
	List<Places> findAllBy(Long idCity);
	
}
