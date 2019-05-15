package it.contrader.dao;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import it.contrader.model.TourOperator;
import it.contrader.dao.MyRepository;


@Repository
@Transactional
public interface TourOperatorRepository extends MyRepository<TourOperator, Long> {

	// TODO This should be not necessary
	@Override
	@Query(value = "SELECT * FROM #{#entityName} e", nativeQuery = true)
	List<TourOperator>findAllBy(Long id);
}
