package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A City.
 */
@Entity
@Table(name = "city")
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "namecity")
    private String namecity;

    @Column(name = "state")
    private String state;

    @Column(name = "jhi_type")
    private String type;

    @OneToMany(mappedBy = "city")
    private Set<Places> places = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "city_image",
               joinColumns = @JoinColumn(name = "cities_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "images_id", referencedColumnName = "id"))
    private Set<Image> images = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamecity() {
        return namecity;
    }

    public City namecity(String namecity) {
        this.namecity = namecity;
        return this;
    }

    public void setNamecity(String namecity) {
        this.namecity = namecity;
    }

    public String getState() {
        return state;
    }

    public City state(String state) {
        this.state = state;
        return this;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public City type(String type) {
        this.type = type;
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Places> getPlaces() {
        return places;
    }

    public City places(Set<Places> places) {
        this.places = places;
        return this;
    }

    public City addPlaces(Places places) {
        this.places.add(places);
        places.setCity(this);
        return this;
    }

    public City removePlaces(Places places) {
        this.places.remove(places);
        places.setCity(null);
        return this;
    }

    public void setPlaces(Set<Places> places) {
        this.places = places;
    }

    public Set<Image> getImages() {
        return images;
    }

    public City images(Set<Image> images) {
        this.images = images;
        return this;
    }

    public City addImage(Image image) {
        this.images.add(image);
        image.getCities().add(this);
        return this;
    }

    public City removeImage(Image image) {
        this.images.remove(image);
        image.getCities().remove(this);
        return this;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
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
        City city = (City) o;
        if (city.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), city.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "City{" +
            "id=" + getId() +
            ", namecity='" + getNamecity() + "'" +
            ", state='" + getState() + "'" +
            ", type='" + getType() + "'" +
            "}";
    }
}
