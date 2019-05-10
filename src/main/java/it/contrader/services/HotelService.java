package it.contrader.services;

import java.util.ArrayList;
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

	public List<HotelDTO> getListaHotelDTO() {
		return ConverterHotel.toListDTO((List<Hotel>)hotelRepository.findAll());
	}

	public HotelDTO getHotelDTOById(Integer idhotel) {
		return ConverterHotel.toDTO(hotelRepository.findById(idhotel).get()); 
	}


	public boolean insertHotel(HotelDTO hotelDTO) {
		return hotelRepository.save(ConverterHotel.toEntity(hotelDTO)) != null;
	}

	public boolean updateHotel(HotelDTO hotelDTO) {
		return hotelRepository.save(ConverterHotel.toEntity(hotelDTO)) != null;
	}
	
	public void deleteHotelById(Integer idhotel) {
		hotelRepository.deleteById(idhotel);
	}
	
	public List<HotelDTO> findhotelDTOByNomeHotel(String nomehotel) {
		
		final List<Hotel> list = hotelRepository.findAllByNomehotel(nomehotel);
		final List<HotelDTO> hotelDTO = new ArrayList<>();
		list.forEach(i -> hotelDTO.add(ConverterHotel.toDTO(i)));
		return hotelDTO;
		
	
	}
}
