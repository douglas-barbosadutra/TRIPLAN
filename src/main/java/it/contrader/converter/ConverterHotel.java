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
			hotelDTO.setIdhotel(hotel.getIdhotel());
			hotelDTO.setNomehotel(hotel.getNomehotel());
			hotelDTO.setCityhotel(hotel.getCityhotel());
			hotelDTO.setNumerostelle(hotel.getNumerostelle());
			hotelDTO.setLatitude(hotel.getLatitude());
			hotelDTO.setLongitude(hotel.getLongitude());
			hotelDTO.setGestorehotel(hotel.getGestorehotel());
			
		}
		return hotelDTO;
	}

	public static Hotel toEntity(HotelDTO hotelDTO) {
		Hotel hotel = null;
		if (hotelDTO != null) {
			hotel = new Hotel();
			hotel.setIdhotel(hotelDTO.getIdhotel());
			hotel.setNomehotel(hotelDTO.getNomehotel());
			hotel.setCityhotel(hotelDTO.getCityhotel());
			hotel.setNumerostelle(hotelDTO.getNumerostelle());
			hotel.setLatitude(hotelDTO.getLatitude());
			hotel.setLongitude(hotelDTO.getLongitude());
			hotel.setGestorehotel(hotelDTO.getGestorehotel());
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
