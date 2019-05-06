package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.ConverterHotel;
import it.contrader.dao.HotelDAO;
import it.contrader.dto.HotelDTO;
import it.contrader.model.Hotel;

public class HotelService {

	private HotelDAO hotelDAO;

	public HotelService() {
		this.hotelDAO = new HotelDAO();
	}

	public List<HotelDTO> getAllHotel() {

		List<Hotel> list = hotelDAO.getAllHotel();
		List<HotelDTO> listDTO = new ArrayList<>();

		for (Hotel hotel : list) {
			listDTO.add(ConverterHotel.toDTO(hotel));
		}

		return listDTO;
	}
	
	


	public boolean insertHotel(HotelDTO hotelDTO) {
				return this.hotelDAO.insertHotel(ConverterHotel.toEntity(hotelDTO));
	}
	
	public List<HotelDTO> readHotel() {

		List<Hotel> list = hotelDAO.getAllHotel();
		List<HotelDTO> listDTO = new ArrayList<>();

		for (Hotel hotel : list) {
			listDTO.add(ConverterHotel.toDTO(hotel));
		}

		return listDTO;
	}
	public boolean updateHotel(HotelDTO hotelDTO) {
		return this.hotelDAO.updateHotel(ConverterHotel.toEntity(hotelDTO));
	}
	
	public boolean deleteHotel(int idhotel) {
		return this.hotelDAO.deleteHotel(idhotel);
	}
	
	
}
