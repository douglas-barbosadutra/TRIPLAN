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
import it.contrader.model.Places;
import it.contrader.model.Places2;


public class PlacesDAO {

	private final String QUERY_ALL = "select * from places";
	private final String QUERY_INSERT = "insert into places (name_places, latitude, longitude) value (?,?,?)";
	private final String QUERY_READ = "select * from places where idplaces=?";
	private final String QUERY_UPDATE = "UPDATE places SET idplaces=?,name_places=?,latitude=?,longitude=? WHERE idplaces=?";
	private final String QUERY_DELETE = "delete from places where idPlaces=?";
	private final String QUERY_SELECT = "select places.idplaces, places.name_places FROM places INNER JOIN city on places.city_idcity=city.idcity";
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
				String nomePlaces = resultSet.getString("name_places");
				String latPlaces = resultSet.getString("latitude");
				String longPlaces = resultSet.getString("longitude");
				places = new Places(idPlaces, nomePlaces, latPlaces, longPlaces);
				places.setIdPlaces(idPlaces);
				placesList.add(places);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return placesList;
	}
	public List<Places2> getSelectPlaces() {
		List<Places2> placesList2 = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_SELECT);
			Places2 places2;
			while (resultSet.next()) {
				int idPlaces = resultSet.getInt("idplaces");
				String nomePlaces = resultSet.getString("name_places");
				places2 = new Places2(idPlaces, nomePlaces);
				places2.setIdPlaces(idPlaces);
				placesList2.add(places2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return placesList2;
	}
	public boolean insertPlaces(Places places) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, places.getNomePlaces());
			preparedStatement.setString(2, places.getLatPlaces());
			preparedStatement.setString(3, places.getLongPlaces());
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
			String nomeplaces;
			String latplaces;
			String longplaces;
			
			nomeplaces = resultSet.getString("name_places");
			idplaces = resultSet.getInt("idplaces");
			latplaces = resultSet.getString("latitude");
			longplaces = resultSet.getString("longitude");
			
			Places places = new Places(idplaces, nomeplaces, latplaces, longplaces);
			places.setIdPlaces(resultSet.getInt("idplaces"));
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
				preparedStatement.setString(3, placesToUpdate.getLatPlaces());
				preparedStatement.setString(4, placesToUpdate.getLongPlaces());
			    preparedStatement.setInt(5, placesToUpdate.getIdPlaces());
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
}
