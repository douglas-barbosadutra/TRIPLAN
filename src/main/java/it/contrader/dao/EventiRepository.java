package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.contrader.model.Eventi;

import it.contrader.dao.MyRepository;

@Repository
@Transactional
public interface EventiRepository extends MyRepository<Eventi, Long>{
	
	// TODO This should be not necessary
	@Override
	@Query(value = "SELECT * FROM #{#entityName} e WHERE e.idCity = ?1", nativeQuery = true)
	List<Eventi> findAllBy(Long idCity);
	

}
