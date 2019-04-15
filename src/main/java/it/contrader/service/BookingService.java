package it.contrader.service;

import java.util.List;
import it.contrader.converter.ConverterBooking;
import it.contrader.dao.BookingDAO;
import it.contrader.dto.BookingDTO;
import it.contrader.model.Booking;

public class BookingService {
	
	
private BookingDAO bookingDAO;

		public BookingService() {
			this.bookingDAO = new BookingDAO();
		}

		public List<Booking> getAllBooking() {
			return this.bookingDAO.getAllBooking();
		}

		public boolean insertBooking(BookingDTO BookingDTO) {
			return this.bookingDAO.insertBooking(ConverterBooking.toEntity(BookingDTO));
		}
		
		public BookingDTO readBooking(int idbooking) {
			return ConverterBooking.toDTO(this.bookingDAO.readBooking(idbooking));
		}
		
		public boolean updateBooking(BookingDTO bookingDTO) {
			return this.bookingDAO.updateBooking(ConverterBooking.toEntity(bookingDTO));
		}
		
		public boolean deleteBooking(int idbooking) {
			return this.bookingDAO.deleteBooking(idbooking);
		}
		
		
	}

