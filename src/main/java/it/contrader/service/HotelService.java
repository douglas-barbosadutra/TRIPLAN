package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.HotelConverter;
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

	public List<HotelDTO> getListaHotelDTO() {
		return HotelConverter.toListDTO((List<Hotel>)hotelRepository.findAll());
	}

	public HotelDTO getHotelDTOById(Integer idhotel) {
		return HotelConverter.toDTO(hotelRepository.findById(idhotel).get()); 
	}


	public boolean insertHotel(HotelDTO hotelDTO) {
		return hotelRepository.save(HotelConverter.toEntity(hotelDTO)) != null;
	}

	public boolean updateHotel(HotelDTO hotelDTO) {
		return hotelRepository.save(HotelConverter.toEntity(hotelDTO)) != null;
	}
	
	public void deleteHotelById(Integer idhotel) {
		hotelRepository.deleteById(idhotel);
	}
	
	public List<HotelDTO> findAllHotelDTO() {

		List<Hotel> list = hotelRepository.findAll();
		List<HotelDTO> hotelDTOs = new ArrayList<>();
		list.forEach(i -> hotelDTOs.add(HotelConverter.toDTO(i)));
		return hotelDTOs;
	}
}
