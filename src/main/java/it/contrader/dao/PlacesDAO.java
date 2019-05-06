package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.utils.GestoreEccezioni;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Places;


public class PlacesDAO {

	private final String QUERY_ALL = "SELECT * FROM places";
	private final String QUERY_INSERT = "INSERT INTO places (name_places, city_places, latitude, longitude) VALUES (?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM places where idplaces=?";

	private final String QUERY_UPDATE = "UPDATE places SET name_places=?, city_places=?, latitude=?, longitude=? WHERE idplaces=?";
	private final String QUERY_DELETE = "DELETE FROM places where idplaces=?";

	private final String QUERY_BYCITTA= "SELECT * FROM places JOIN city ON places.city_idcity=city.idcity where places.city_idcity=";
	
	
	public PlacesDAO() {

	}

	public List<Places> getAllPlaces() {
		List<Places> placesList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Places places;
			while (resultSet.next()) {
				int idPlaces = resultSet.getInt("idplaces");
				String name_places = resultSet.getString("name_places");
				String city_places = resultSet.getString("city_places");
				Double latitude = resultSet.getDouble("latitude");
				Double longitude = resultSet.getDouble("longitude");
				places = new Places(idPlaces, name_places, city_places, latitude, longitude);
				places.setIdPlaces(idPlaces);
				placesList.add(places);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return placesList;
	}

	public boolean insertPlaces(Places places) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, places.getNomePlaces());
			preparedStatement.setString(2, places.getCPlaces());
			preparedStatement.setDouble(3, places.getLatitude());
			preparedStatement.setDouble(4, places.getLongitude());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public Places readPlaces(int idPlaces) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idPlaces);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int idplaces;
			Double latitude;
			Double longitude;
			String nomeplaces;
			String city_places;
			nomeplaces = resultSet.getString("name_places");
			city_places = resultSet.getString("city_places");
			idplaces = resultSet.getInt("idplaces");
			latitude = resultSet.getDouble("latitude");
			longitude = resultSet.getDouble("longitude");
			Places places = new Places(idplaces, nomeplaces, city_places, latitude, longitude);
			places.setIdPlaces(resultSet.getInt("idplaces"));
			places.setLatitude(resultSet.getDouble("latitude"));
			places.setLongitude(resultSet.getDouble("longitude"));
			return places;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updatePlaces(Places placesToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (placesToUpdate.getIdPlaces() == 0)
			return false;

		
		Places placesRead = readPlaces(placesToUpdate.getIdPlaces());
		if (!placesRead.equals(placesToUpdate)) {
			try {
				// Fill the placesToUpdate object
				if (placesToUpdate.getNomePlaces() == null || placesToUpdate.getNomePlaces().equals("")) {
					placesToUpdate.setNomePlaces(placesRead.getNomePlaces());
				
				}
				
				// Update the places
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, placesToUpdate.getIdPlaces());
				preparedStatement.setString(2, placesToUpdate.getNomePlaces());
				preparedStatement.setString(3, placesToUpdate.getCPlaces());
				preparedStatement.setDouble(4, placesToUpdate.getLatitude());
				preparedStatement.setDouble(5, placesToUpdate.getLongitude());
			    preparedStatement.setInt(6, placesToUpdate.getIdPlaces());
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

	public boolean deletePlaces(Integer id) {
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
	
//nuovo codice da togliere se non va
public List<Places> CityPlaces(Integer idcity) {
	List<Places> cityplacesList = new ArrayList<>();
	Connection connection = ConnectionSingleton.getInstance();
	try {
		Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(QUERY_BYCITTA+idcity);
		Places places;
		while (resultSet.next()) {
			int idPlaces = resultSet.getInt("idplaces");
			String name_places = resultSet.getString("name_places");
			String city_places = resultSet.getString("city_places");
			Double latitude = resultSet.getDouble("latitude");
			Double longitude = resultSet.getDouble("longitude");
			places = new Places(idPlaces, name_places, city_places, latitude, longitude);
			places.setIdPlaces(idPlaces);
			cityplacesList.add(places);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return cityplacesList;
	}

public List<Places> Places(Integer Idcity) {
	List<Places> cityplacesList = new ArrayList<>();
	Connection connection = ConnectionSingleton.getInstance();
	try {
		Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(QUERY_READ+Idcity);
		Places places;
		while (resultSet.next()) {
			int idPlaces = resultSet.getInt("Idplaces");
			String name_places = resultSet.getString("name_places");
			double latitude= resultSet.getDouble("latitude");
			double longitude=resultSet.getDouble("longitude");
			places = new Places(idPlaces, name_places, null,  latitude , longitude);
			places.setIdPlaces(idPlaces);
			cityplacesList.add(places);} 
	}catch (SQLException e) {
			e.printStackTrace();
	}
		
		return cityplacesList;}



}