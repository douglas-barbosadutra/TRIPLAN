package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.PlacesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Places and its DTO PlacesDTO.
 */
@Mapper(componentModel = "spring", uses = {CityMapper.class})
public interface PlacesMapper extends EntityMapper<PlacesDTO, Places> {

    @Mapping(source = "city.id", target = "cityId")
    PlacesDTO toDto(Places places);

    @Mapping(source = "cityId", target = "city")
    Places toEntity(PlacesDTO placesDTO);

    default Places fromId(Long id) {
        if (id == null) {
            return null;
        }
        Places places = new Places();
        places.setId(id);
        return places;
    }
}
