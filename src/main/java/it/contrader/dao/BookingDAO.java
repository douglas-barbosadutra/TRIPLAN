package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.controller.GestoreEccezioni;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Booking;


public class BookingDAO {

	private final String QUERY_ALL = "select * from booking";
	private final String QUERY_INSERT = "insert into booking (book_usename, book_city) values (?)";
	private final String QUERY_READ = "select * from booking where idbooking=?";

	private final String QUERY_UPDATE = "UPDATE booking SET idbooking=?,book_city=? WHERE idbooking=?";
	private final String QUERY_DELETE = "delete from booking where idbooking=?";
	
	public BookingDAO() {

	}

	public List<Booking> getAllBooking() {
		List<Booking> bookingList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Booking booking;
			while (resultSet.next()) {
				int idBooking = resultSet.getInt("idbooking");
				String book_city = resultSet.getString("book_city");
				String book_username = resultSet.getString("book_username");
				booking = new Booking(idBooking, book_city);
				booking.setIdBooking(idBooking);
				bookingList.add(booking);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookingList;
	}

	public boolean insertBooking(Booking booking) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, booking.getNomeBooking());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public Booking readBooking(int idBooking) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idBooking);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int idbooking;
			String nomebooking;
			

			nomebooking = resultSet.getString("booking_city");
			idbooking = resultSet.getInt("idboking");
			
			Booking booking = new Booking(idbooking, nomebooking);
			booking.setIdBooking(resultSet.getInt("idbooking"));

			return booking;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updateBooking(Booking bookingToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (bookingToUpdate.getIdBooking() == 0)
			return false;

		
		Booking BookingRead = readBooking(bookingToUpdate.getIdBooking());
		if (!BookingRead.equals(bookingToUpdate)) {
			try {
				// Fill the booking Update object
				if (bookingToUpdate.getNomeBooking() == null || bookingToUpdate.getNomeBooking().equals("")) {
					bookingToUpdate.setNomeBooking(BookingRead.getNomeBooking());
				
				}
				
				// Update the Booking
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, bookingToUpdate.getIdBooking());
				preparedStatement.setString(2, bookingToUpdate.getNomeBooking());
			    preparedStatement.setInt(3, bookingToUpdate.getIdBooking());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;
		
	}

	public boolean deleteBooking(Integer id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} catch (SQLException e) {
		}
		return false;
	}
}
