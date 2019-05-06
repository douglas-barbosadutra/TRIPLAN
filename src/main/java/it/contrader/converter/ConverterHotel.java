package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.HotelDTO;
import it.contrader.model.Hotel;

public class ConverterHotel {

	public static HotelDTO toDTO(Hotel hotel) {
		HotelDTO hotelDTO = null;
		if (hotel != null) {
			hotelDTO = new HotelDTO();
			hotelDTO.setIdHotel(hotel.getIdHotel());
			hotelDTO.setNomeHotel(hotel.getNomeHotel());
			hotelDTO.setCityHotel(hotel.getCityHotel());
			hotelDTO.setNumeroStelle(hotel.getNumeroStelle());
			hotelDTO.setLatitude(hotel.getLatitude());
			hotelDTO.setLongitude(hotel.getLongitude());
			hotelDTO.setGestoreHotel(hotel.getGestoreHotel());
			
		}
		return hotelDTO;
	}

	public static Hotel toEntity(HotelDTO hotelDTO) {
		Hotel hotel = null;
		if (hotelDTO != null) {
			hotel = new Hotel();
			hotel.setIdHotel(hotelDTO.getIdHotel());
			hotel.setNomeHotel(hotelDTO.getNomeHotel());
			hotel.setCityHotel(hotelDTO.getCityHotel());
			hotel.setNumeroStelle(hotelDTO.getNumeroStelle());
			hotel.setLatitude(hotelDTO.getLatitude());
			hotel.setLongitude(hotelDTO.getLongitude());
			hotel.setGestoreHotel(hotelDTO.getGestoreHotel());
		}
		return hotel;
	}

	public static List<HotelDTO> toListDTO(List<Hotel> list) {
		List<HotelDTO> listHotelDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Hotel hotel : list) {
				listHotelDTO.add(ConverterHotel.toDTO(hotel));
			}
		}
		return listHotelDTO;
	}

	public static List<Hotel> toListEntity(List<HotelDTO> listHotelDTO) {
		List<Hotel> list = new ArrayList<>();
		if (!listHotelDTO.isEmpty()) {
			for (HotelDTO hotelDTO : listHotelDTO) {
				list.add(ConverterHotel.toEntity(hotelDTO));
			}
		}
		return list;
	}
}
