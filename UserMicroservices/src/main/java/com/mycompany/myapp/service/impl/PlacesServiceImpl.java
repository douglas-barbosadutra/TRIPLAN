package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.service.PlacesService;
import com.mycompany.myapp.domain.Places;
import com.mycompany.myapp.repository.PlacesRepository;
import com.mycompany.myapp.service.dto.PlacesDTO;
import com.mycompany.myapp.service.mapper.PlacesMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing Places.
 */
@Service
@Transactional
public class PlacesServiceImpl implements PlacesService {

    private final Logger log = LoggerFactory.getLogger(PlacesServiceImpl.class);

    private final PlacesRepository placesRepository;

    private final PlacesMapper placesMapper;

    public PlacesServiceImpl(PlacesRepository placesRepository, PlacesMapper placesMapper) {
        this.placesRepository = placesRepository;
        this.placesMapper = placesMapper;
    }

    /**
     * Save a places.
     *
     * @param placesDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public PlacesDTO save(PlacesDTO placesDTO) {
        log.debug("Request to save Places : {}", placesDTO);
        Places places = placesMapper.toEntity(placesDTO);
        places = placesRepository.save(places);
        return placesMapper.toDto(places);
    }

    /**
     * Get all the places.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<PlacesDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Places");
        return placesRepository.findAll(pageable)
            .map(placesMapper::toDto);
    }


    /**
     * Get one places by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<PlacesDTO> findOne(Long id) {
        log.debug("Request to get Places : {}", id);
        return placesRepository.findById(id)
            .map(placesMapper::toDto);
    }

    /**
     * Delete the places by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Places : {}", id);
        placesRepository.deleteById(id);
    }
}
