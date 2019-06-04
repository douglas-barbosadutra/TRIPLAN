package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import it.contrader.dto.BookingDTO;
import it.contrader.model.Booking;

@Component
public class BookingConverter {

	
	
	public static Booking toEntity(BookingDTO bookingDTO) {
		Booking booking = new Booking();
		if(bookingDTO!=null) {
			booking.setIdBooking(bookingDTO.getIdBooking());
			booking.setUsername(bookingDTO.getUsername());
			booking.setCity(bookingDTO.getCity());
			booking.setDatefrom(bookingDTO.getDatefrom());
			booking.setDateto(bookingDTO.getDateto());
			booking.setCosto(bookingDTO.getCosto());
			booking.setIndex(bookingDTO.getIndex());
			booking.setPeople(bookingDTO.getPeople());
			
		}
		return booking;
	}
	
	public static BookingDTO toDTO(Booking booking) {
		BookingDTO bookingDTO = new BookingDTO();
		if(booking!=null) {
			bookingDTO.setIdBooking(booking.getIdBooking());
			bookingDTO.setUsername(booking.getUsername());
			bookingDTO.setCity(booking.getCity());
			bookingDTO.setDatefrom(booking.getDatefrom());
			bookingDTO.setDateto(booking.getDateto());
			bookingDTO.setCosto(booking.getCosto());
			bookingDTO.setIndex(booking.getIndex());
			bookingDTO.setPeople(booking.getPeople());
		}
		return bookingDTO;
	}
	
	public static List<BookingDTO> toListDTO(List<Booking> list) {
		List<BookingDTO> listBookingDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Booking booking : list) {
				listBookingDTO.add(BookingConverter.toDTO(booking));
			}
		}
		return listBookingDTO;
	}

	public static List<Booking> toListEntity(List<BookingDTO> listBookingDTO) {
		List<Booking> list = new ArrayList<>();
		if (!listBookingDTO.isEmpty()) {
			for (BookingDTO bookingDTO : listBookingDTO) {
				list.add(BookingConverter.toEntity(bookingDTO));
			}
		}
		return list;
	}
}
