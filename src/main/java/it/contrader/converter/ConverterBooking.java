package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.BookingDTO;
import it.contrader.model.Booking;

public class ConverterBooking {


	public static BookingDTO toDTO(Booking booking) {
		BookingDTO bookingDTO = null;
		if (booking != null) {
			bookingDTO = new BookingDTO();
			bookingDTO.setIdBooking(booking.getIdBooking());
<<<<<<< HEAD
			bookingDTO.setNomeBooking(booking.getNomeBooking());
=======
			bookingDTO.setUsernameBooking(booking.getUsernameBooking());
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f
			
		}
		return bookingDTO;
	}

	public static Booking toEntity(BookingDTO bookingDTO) {
		Booking booking = null;
		if (bookingDTO != null) {
			booking = new Booking();
			booking.setIdBooking(bookingDTO.getIdBooking());
<<<<<<< HEAD
			booking.setNomeBooking(bookingDTO.getNomeBooking());
=======
			booking.setUsernameBooking(bookingDTO.getUsernameBooking());
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f
			
		}
		return booking;
	}

	public static List<BookingDTO> toListDTO(List<Booking> list) {
		List<BookingDTO> listBookigDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Booking booking : list) {
				listBookigDTO.add(ConverterBooking.toDTO(booking));
			}
		}
		return listBookigDTO;
	}

	public static List<Booking> toListEntity(List<BookingDTO> listBookingDTO) {
		List<Booking> list = new ArrayList<>();
		if (!listBookingDTO.isEmpty()) {
			for (BookingDTO bookingDTO : listBookingDTO) {
				list.add(ConverterBooking.toEntity(bookingDTO));
			}
		}
		return list;
	}
}