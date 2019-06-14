package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.UserMicroservicesApp;

import com.mycompany.myapp.domain.Places;
import com.mycompany.myapp.repository.PlacesRepository;
import com.mycompany.myapp.service.PlacesService;
import com.mycompany.myapp.service.dto.PlacesDTO;
import com.mycompany.myapp.service.mapper.PlacesMapper;
import com.mycompany.myapp.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


import static com.mycompany.myapp.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the PlacesResource REST controller.
 *
 * @see PlacesResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserMicroservicesApp.class)
public class PlacesResourceIntTest {

    private static final String DEFAULT_NAMEPLACES = "AAAAAAAAAA";
    private static final String UPDATED_NAMEPLACES = "BBBBBBBBBB";

    private static final String DEFAULT_CATEGORY = "AAAAAAAAAA";
    private static final String UPDATED_CATEGORY = "BBBBBBBBBB";

    private static final Integer DEFAULT_COSTO = 1;
    private static final Integer UPDATED_COSTO = 2;

    private static final Double DEFAULT_LATITUDE = 1D;
    private static final Double UPDATED_LATITUDE = 2D;

    private static final Double DEFAULT_LONGITUDE = 1D;
    private static final Double UPDATED_LONGITUDE = 2D;

    private static final Integer DEFAULT_FASCIA = 1;
    private static final Integer UPDATED_FASCIA = 2;

    private static final Integer DEFAULT_DURATA = 1;
    private static final Integer UPDATED_DURATA = 2;

    @Autowired
    private PlacesRepository placesRepository;


    @Autowired
    private PlacesMapper placesMapper;
    

    @Autowired
    private PlacesService placesService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restPlacesMockMvc;

    private Places places;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final PlacesResource placesResource = new PlacesResource(placesService);
        this.restPlacesMockMvc = MockMvcBuilders.standaloneSetup(placesResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Places createEntity(EntityManager em) {
        Places places = new Places()
            .nameplaces(DEFAULT_NAMEPLACES)
            .category(DEFAULT_CATEGORY)
            .costo(DEFAULT_COSTO)
            .latitude(DEFAULT_LATITUDE)
            .longitude(DEFAULT_LONGITUDE)
            .fascia(DEFAULT_FASCIA)
            .durata(DEFAULT_DURATA);
        return places;
    }

    @Before
    public void initTest() {
        places = createEntity(em);
    }

    @Test
    @Transactional
    public void createPlaces() throws Exception {
        int databaseSizeBeforeCreate = placesRepository.findAll().size();

        // Create the Places
        PlacesDTO placesDTO = placesMapper.toDto(places);
        restPlacesMockMvc.perform(post("/api/places")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(placesDTO)))
            .andExpect(status().isCreated());

        // Validate the Places in the database
        List<Places> placesList = placesRepository.findAll();
        assertThat(placesList).hasSize(databaseSizeBeforeCreate + 1);
        Places testPlaces = placesList.get(placesList.size() - 1);
        assertThat(testPlaces.getNameplaces()).isEqualTo(DEFAULT_NAMEPLACES);
        assertThat(testPlaces.getCategory()).isEqualTo(DEFAULT_CATEGORY);
        assertThat(testPlaces.getCosto()).isEqualTo(DEFAULT_COSTO);
        assertThat(testPlaces.getLatitude()).isEqualTo(DEFAULT_LATITUDE);
        assertThat(testPlaces.getLongitude()).isEqualTo(DEFAULT_LONGITUDE);
        assertThat(testPlaces.getFascia()).isEqualTo(DEFAULT_FASCIA);
        assertThat(testPlaces.getDurata()).isEqualTo(DEFAULT_DURATA);
    }

    @Test
    @Transactional
    public void createPlacesWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = placesRepository.findAll().size();

        // Create the Places with an existing ID
        places.setId(1L);
        PlacesDTO placesDTO = placesMapper.toDto(places);

        // An entity with an existing ID cannot be created, so this API call must fail
        restPlacesMockMvc.perform(post("/api/places")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(placesDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Places in the database
        List<Places> placesList = placesRepository.findAll();
        assertThat(placesList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllPlaces() throws Exception {
        // Initialize the database
        placesRepository.saveAndFlush(places);

        // Get all the placesList
        restPlacesMockMvc.perform(get("/api/places?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(places.getId().intValue())))
            .andExpect(jsonPath("$.[*].nameplaces").value(hasItem(DEFAULT_NAMEPLACES.toString())))
            .andExpect(jsonPath("$.[*].category").value(hasItem(DEFAULT_CATEGORY.toString())))
            .andExpect(jsonPath("$.[*].costo").value(hasItem(DEFAULT_COSTO)))
            .andExpect(jsonPath("$.[*].latitude").value(hasItem(DEFAULT_LATITUDE.doubleValue())))
            .andExpect(jsonPath("$.[*].longitude").value(hasItem(DEFAULT_LONGITUDE.doubleValue())))
            .andExpect(jsonPath("$.[*].fascia").value(hasItem(DEFAULT_FASCIA)))
            .andExpect(jsonPath("$.[*].durata").value(hasItem(DEFAULT_DURATA)));
    }
    

    @Test
    @Transactional
    public void getPlaces() throws Exception {
        // Initialize the database
        placesRepository.saveAndFlush(places);

        // Get the places
        restPlacesMockMvc.perform(get("/api/places/{id}", places.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(places.getId().intValue()))
            .andExpect(jsonPath("$.nameplaces").value(DEFAULT_NAMEPLACES.toString()))
            .andExpect(jsonPath("$.category").value(DEFAULT_CATEGORY.toString()))
            .andExpect(jsonPath("$.costo").value(DEFAULT_COSTO))
            .andExpect(jsonPath("$.latitude").value(DEFAULT_LATITUDE.doubleValue()))
            .andExpect(jsonPath("$.longitude").value(DEFAULT_LONGITUDE.doubleValue()))
            .andExpect(jsonPath("$.fascia").value(DEFAULT_FASCIA))
            .andExpect(jsonPath("$.durata").value(DEFAULT_DURATA));
    }
    @Test
    @Transactional
    public void getNonExistingPlaces() throws Exception {
        // Get the places
        restPlacesMockMvc.perform(get("/api/places/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updatePlaces() throws Exception {
        // Initialize the database
        placesRepository.saveAndFlush(places);

        int databaseSizeBeforeUpdate = placesRepository.findAll().size();

        // Update the places
        Places updatedPlaces = placesRepository.findById(places.getId()).get();
        // Disconnect from session so that the updates on updatedPlaces are not directly saved in db
        em.detach(updatedPlaces);
        updatedPlaces
            .nameplaces(UPDATED_NAMEPLACES)
            .category(UPDATED_CATEGORY)
            .costo(UPDATED_COSTO)
            .latitude(UPDATED_LATITUDE)
            .longitude(UPDATED_LONGITUDE)
            .fascia(UPDATED_FASCIA)
            .durata(UPDATED_DURATA);
        PlacesDTO placesDTO = placesMapper.toDto(updatedPlaces);

        restPlacesMockMvc.perform(put("/api/places")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(placesDTO)))
            .andExpect(status().isOk());

        // Validate the Places in the database
        List<Places> placesList = placesRepository.findAll();
        assertThat(placesList).hasSize(databaseSizeBeforeUpdate);
        Places testPlaces = placesList.get(placesList.size() - 1);
        assertThat(testPlaces.getNameplaces()).isEqualTo(UPDATED_NAMEPLACES);
        assertThat(testPlaces.getCategory()).isEqualTo(UPDATED_CATEGORY);
        assertThat(testPlaces.getCosto()).isEqualTo(UPDATED_COSTO);
        assertThat(testPlaces.getLatitude()).isEqualTo(UPDATED_LATITUDE);
        assertThat(testPlaces.getLongitude()).isEqualTo(UPDATED_LONGITUDE);
        assertThat(testPlaces.getFascia()).isEqualTo(UPDATED_FASCIA);
        assertThat(testPlaces.getDurata()).isEqualTo(UPDATED_DURATA);
    }

    @Test
    @Transactional
    public void updateNonExistingPlaces() throws Exception {
        int databaseSizeBeforeUpdate = placesRepository.findAll().size();

        // Create the Places
        PlacesDTO placesDTO = placesMapper.toDto(places);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restPlacesMockMvc.perform(put("/api/places")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(placesDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Places in the database
        List<Places> placesList = placesRepository.findAll();
        assertThat(placesList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deletePlaces() throws Exception {
        // Initialize the database
        placesRepository.saveAndFlush(places);

        int databaseSizeBeforeDelete = placesRepository.findAll().size();

        // Get the places
        restPlacesMockMvc.perform(delete("/api/places/{id}", places.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Places> placesList = placesRepository.findAll();
        assertThat(placesList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Places.class);
        Places places1 = new Places();
        places1.setId(1L);
        Places places2 = new Places();
        places2.setId(places1.getId());
        assertThat(places1).isEqualTo(places2);
        places2.setId(2L);
        assertThat(places1).isNotEqualTo(places2);
        places1.setId(null);
        assertThat(places1).isNotEqualTo(places2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PlacesDTO.class);
        PlacesDTO placesDTO1 = new PlacesDTO();
        placesDTO1.setId(1L);
        PlacesDTO placesDTO2 = new PlacesDTO();
        assertThat(placesDTO1).isNotEqualTo(placesDTO2);
        placesDTO2.setId(placesDTO1.getId());
        assertThat(placesDTO1).isEqualTo(placesDTO2);
        placesDTO2.setId(2L);
        assertThat(placesDTO1).isNotEqualTo(placesDTO2);
        placesDTO1.setId(null);
        assertThat(placesDTO1).isNotEqualTo(placesDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(placesMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(placesMapper.fromId(null)).isNull();
    }
}
