package it.contrader.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.contrader.model.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {
	
	public List<Image> findAll();
	
	
}
