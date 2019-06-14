package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the City entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query(value = "select distinct city from City city left join fetch city.images",
        countQuery = "select count(distinct city) from City city")
    Page<City> findAllWithEagerRelationships(Pageable pageable);

    @Query(value = "select distinct city from City city left join fetch city.images")
    List<City> findAllWithEagerRelationships();

    @Query("select city from City city left join fetch city.images where city.id =:id")
    Optional<City> findOneWithEagerRelationships(@Param("id") Long id);

}
