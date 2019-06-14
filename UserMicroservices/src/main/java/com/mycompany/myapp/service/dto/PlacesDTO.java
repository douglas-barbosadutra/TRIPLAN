package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Places entity.
 */
public class PlacesDTO implements Serializable {

    private Long id;

    private String nameplaces;

    private String category;

    private Integer costo;

    private Double latitude;

    private Double longitude;

    private Integer fascia;

    private Integer durata;

    private Long cityId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameplaces() {
        return nameplaces;
    }

    public void setNameplaces(String nameplaces) {
        this.nameplaces = nameplaces;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getFascia() {
        return fascia;
    }

    public void setFascia(Integer fascia) {
        this.fascia = fascia;
    }

    public Integer getDurata() {
        return durata;
    }

    public void setDurata(Integer durata) {
        this.durata = durata;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PlacesDTO placesDTO = (PlacesDTO) o;
        if (placesDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), placesDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PlacesDTO{" +
            "id=" + getId() +
            ", nameplaces='" + getNameplaces() + "'" +
            ", category='" + getCategory() + "'" +
            ", costo=" + getCosto() +
            ", latitude=" + getLatitude() +
            ", longitude=" + getLongitude() +
            ", fascia=" + getFascia() +
            ", durata=" + getDurata() +
            ", city=" + getCityId() +
            "}";
    }
}
