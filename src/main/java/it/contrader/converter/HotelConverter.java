package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.HotelDTO;
import it.contrader.model.Hotel;

@Component
public class HotelConverter extends AbstractConverter<Hotel, HotelDTO> {
	
	@Autowired
	private CityConverter cityConverter;
	
	@Autowired
	private UserConverter userConverter;
	
	@Override
	public Hotel toEntity(HotelDTO hotelDTO) {
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

	
	@Override
	public HotelDTO toDTO(Hotel hotel) {
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
}
