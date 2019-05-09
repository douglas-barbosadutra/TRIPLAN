package it.contrader.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterHotel;
import it.contrader.dao.HotelRepository;
import it.contrader.dto.HotelDTO;
import it.contrader.model.Hotel;



@Service
public class HotelService {

	private final HotelRepository hotelRepository;

	@Autowired
	public HotelService(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}
	
	public List<HotelDTO> getAllHotelDTO() {
		return ConverterHotel.toListDTO((List<Hotel>) hotelRepository.findAll());
	}
	public Hotel getHotelById(Integer id) {
		return hotelRepository.findById(id).get();
	}
	
	public HotelDTO getHotelDTOById(Integer id) {
		return ConverterHotel.toDTO(hotelRepository.findById(id).get());
	}
	
	
	public HotelDTO getByNomeHotel(String nomehotel) {

		final Hotel hotel = hotelRepository.findByNomeHotel(nomehotel);

		return ConverterHotel.toDTO(hotel);
	}
	


	public boolean insertHotel(HotelDTO hotelDTO) {
		return hotelRepository.save(ConverterHotel.toEntity(hotelDTO)) != null;
	}

	public boolean updateHotel(HotelDTO hotelDTO) {
		return hotelRepository.save(ConverterHotel.toEntity(hotelDTO)) != null;
	}
	
	public void deleteHotelById(Integer id) {
		hotelRepository.deleteById(id);
	}
}
