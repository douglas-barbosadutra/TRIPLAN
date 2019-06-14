package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Places.
 */
@Entity
@Table(name = "places")
public class Places implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nameplaces")
    private String nameplaces;

    @Column(name = "category")
    private String category;

    @Column(name = "costo")
    private Integer costo;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "fascia")
    private Integer fascia;

    @Column(name = "durata")
    private Integer durata;

    @ManyToOne
    @JsonIgnoreProperties("places")
    private City city;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameplaces() {
        return nameplaces;
    }

    public Places nameplaces(String nameplaces) {
        this.nameplaces = nameplaces;
        return this;
    }

    public void setNameplaces(String nameplaces) {
        this.nameplaces = nameplaces;
    }

    public String getCategory() {
        return category;
    }

    public Places category(String category) {
        this.category = category;
        return this;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getCosto() {
        return costo;
    }

    public Places costo(Integer costo) {
        this.costo = costo;
        return this;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Places latitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Places longitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getFascia() {
        return fascia;
    }

    public Places fascia(Integer fascia) {
        this.fascia = fascia;
        return this;
    }

    public void setFascia(Integer fascia) {
        this.fascia = fascia;
    }

    public Integer getDurata() {
        return durata;
    }

    public Places durata(Integer durata) {
        this.durata = durata;
        return this;
    }

    public void setDurata(Integer durata) {
        this.durata = durata;
    }

    public City getCity() {
        return city;
    }

    public Places city(City city) {
        this.city = city;
        return this;
    }

    public void setCity(City city) {
        this.city = city;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Places places = (Places) o;
        if (places.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), places.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Places{" +
            "id=" + getId() +
            ", nameplaces='" + getNameplaces() + "'" +
            ", category='" + getCategory() + "'" +
            ", costo=" + getCosto() +
            ", latitude=" + getLatitude() +
            ", longitude=" + getLongitude() +
            ", fascia=" + getFascia() +
            ", durata=" + getDurata() +
            "}";
    }
}
