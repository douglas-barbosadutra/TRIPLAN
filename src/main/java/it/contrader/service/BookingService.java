package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.BookingConverter;
import it.contrader.converter.UserConverter;
import it.contrader.dao.BookingRepository;
import it.contrader.dto.BookingDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Booking;

@Service
public class BookingService {

	private final BookingRepository bookingRepository;

	@Autowired
	public BookingService(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}

	public List<BookingDTO> getListaBookingDTO() {
		return BookingConverter.toListDTO((List<Booking>) bookingRepository.findAll());
	}

	public BookingDTO getBookingDTOById(Integer id) {
		return BookingConverter.toDTO(bookingRepository.findById(id).get()); 
	}


	public boolean insertBooking(BookingDTO bookingDTO) {
		return bookingRepository.save(BookingConverter.toEntity(bookingDTO)) != null;
	}

	public boolean updateBooking(BookingDTO bookingDTO) {
		return bookingRepository.save(BookingConverter.toEntity(bookingDTO)) != null;
	}
	
	public void deleteBookingById(Integer id) {
		bookingRepository.deleteById(id);
	}
	
	public List<BookingDTO> getAllBooking(){
		return BookingConverter.toListDTO(bookingRepository.findAll());
	}

}
