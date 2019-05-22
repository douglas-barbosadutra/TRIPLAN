package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.HotelDTO;
import it.contrader.model.Hotel;

@Component
public class HotelConverter  {
	
	@Autowired
	private static CityConverter cityConverter;
	
	@Autowired
	private static UserConverter userConverter;
	
	
	public static Hotel toEntity(HotelDTO hotelDTO) {
		Hotel hotel = new Hotel();
		if(hotelDTO!=null) {
			hotel.setIdHotel(hotelDTO.getIdHotel());
			hotel.setNamehotel(hotelDTO.getNamehotel());
			hotel.setLatitude(hotelDTO.getLatitude());
			hotel.setLongitude(hotelDTO.getLongitude());
			hotel.setNumerostelle(hotelDTO.getNumerostelle());
			hotel.setCity(cityConverter.toEntity(hotelDTO.getCityDTO()));
			hotel.setUser(userConverter.toEntity(hotelDTO.getUserDTO()));

		}
		return hotel;
	}

	
	public static HotelDTO toDTO(Hotel hotel) {
		HotelDTO hotelDTO = new HotelDTO();
		if(hotel!=null) {
			hotelDTO.setIdHotel(hotel.getIdHotel());
			hotelDTO.setNamehotel(hotel.getNamehotel());
			hotelDTO.setLatitude(hotel.getLatitude());
			hotelDTO.setLongitude(hotel.getLongitude());
			hotelDTO.setNumerostelle(hotel.getNumerostelle());
			hotelDTO.setCityDTO(cityConverter.toDTO(hotel.getCity()));
			hotelDTO.setUserDTO(userConverter.toDTO(hotel.getUser()));


		}
		return hotelDTO;
	}
	public static List<HotelDTO> toListDTO(List<Hotel> list) {
		List<HotelDTO> listHotelDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Hotel hotel : list) {
				listHotelDTO.add(HotelConverter.toDTO(hotel));
			}
		}
		return listHotelDTO;
	}

	public static List<Hotel> toListEntity(List<HotelDTO> listHotelDTO) {
		List<Hotel> list = new ArrayList<>();
		if (!listHotelDTO.isEmpty()) {
			for (HotelDTO hotelDTO : listHotelDTO) {
				list.add(HotelConverter.toEntity(hotelDTO));
			}
		}
		return list;
	}
}