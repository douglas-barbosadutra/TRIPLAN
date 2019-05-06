package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import it.contrader.utils.GestoreEccezioni;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Hotel;
import it.contrader.model.Tags;
import it.contrader.model.User;

public class HotelDAO {

	private final String QUERY_ALL = "SELECT * FROM hotel";
	private final String QUERY_INSERT = "INSERT INTO hotel (name_hotel, city_hoytel, numero_stelle, latitude, longitude, gestore_hotel) VALUES (?,?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM hotel WHERE idhotel=?";
	private final String QUERY_UPDATE = "UPDATE hotel SET name_hotel=?, city_hotel=?, numero_stelle=?, latitude=?, longitude=?, gestore_hotel=? WHERE idhotel=?";
	private final String QUERY_DELETE = "DELETE FROM hotel WHERE idhotel=?";
	private final String QUERY_GEST = "SELECT * FROM hotel JOIN user ON hotel.gestore_hotel=tab_user.username";

	public HotelDAO() {

	}

	public List<Hotel> getAllHotel() {
		List<Hotel> hotelsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Hotel hotel;
			while (resultSet.next()) {
				int idhotel = resultSet.getInt("idhotel");
				String name_hotel = resultSet.getString("name_hotel");
				String city_hotel = resultSet.getString("city_hotel");
				int numero_stelle = resultSet.getInt("numero_stelle");
				double latitude = resultSet.getDouble("latitude");
				double longitude = resultSet.getDouble("longitude");
				String gestore_hotel = resultSet.getString("gestore_hotel");
				hotel = new Hotel(name_hotel, city_hotel, numero_stelle, latitude, longitude, gestore_hotel);
				hotel.setIdHotel(idhotel);
				hotelsList.add(hotel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hotelsList;
	}

	public boolean insertHotel(Hotel hotel) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, hotel.getNomeHotel());
			preparedStatement.setString(2, hotel.getCityHotel());
			preparedStatement.setInt(3, hotel.getNumeroStelle());
			preparedStatement.setDouble(4, hotel.getLatitude());
			preparedStatement.setDouble(5, hotel.getLongitude());
			preparedStatement.setString(6, hotel.getGestoreHotel());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}
	

	public Hotel readHotel(int idhotel) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idhotel);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name_hotel, city_hotel, gestore_hotel;
			double longitude;
			double latitude;
			int numero_stelle;
			 name_hotel = resultSet.getString("name_hotel");
			 city_hotel = resultSet.getString("city_hotel");
			 numero_stelle = resultSet.getInt("numero_stelle");
			 latitude = resultSet.getDouble("latitude");
			 longitude = resultSet.getDouble("longitude");
			 gestore_hotel = resultSet.getString("gestore_hotel");
			Hotel hotel = new Hotel(name_hotel, city_hotel, numero_stelle, latitude, longitude, gestore_hotel);
			hotel.setIdHotel(resultSet.getInt("idhotel"));
			

			return hotel;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updateHotel(Hotel hotelToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		if (hotelToUpdate.getIdHotel() == 0)
			return false;

		Hotel hotelRead = readHotel(hotelToUpdate.getIdHotel());
		if (!hotelRead.equals(hotelToUpdate)) {
			try {
				// Fill the cityToUpdate object
				if (hotelToUpdate.getNomeHotel() == null || hotelToUpdate.getNomeHotel().equals("")) {
					hotelToUpdate.setNomeHotel(hotelRead.getNomeHotel());
				}
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, hotelToUpdate.getIdHotel());
				preparedStatement.setString(2, hotelToUpdate.getNomeHotel());
				preparedStatement.setString(3, hotelToUpdate.getCityHotel());
				preparedStatement.setInt(4, hotelToUpdate.getNumeroStelle());
				preparedStatement.setDouble(5, hotelToUpdate.getLatitude());
				preparedStatement.setDouble(6, hotelToUpdate.getLongitude());
				preparedStatement.setString(7, hotelToUpdate.getGestoreHotel());
			    preparedStatement.setInt(8, hotelToUpdate.getIdHotel());
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


	public boolean deleteHotel(Integer id) {
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

