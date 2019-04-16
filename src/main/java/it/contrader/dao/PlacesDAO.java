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
import it.contrader.model.CityPlaces;
import it.contrader.model.Places;


public class PlacesDAO {

	private final String QUERY_ALL = "select * from places";
	private final String QUERY_INSERT = "insert into places (name_places) values (?)";
	private final String QUERY_READ = "select * from places where idplaces=?";

	private final String QUERY_UPDATE = "UPDATE places SET idplaces=?,name_places=? WHERE idplaces=?";
	private final String QUERY_DELETE = "delete from places where idPlaces=?";

	private final String QUERY_BYCITTA= "select * from places join city on places.city_idcity=city.idcity where places.city_idcity=";
	private final String QUERY_READ2= "select + from placese where city_idcity=?";
	
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
				places = new Places(idPlaces, name_places);
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
			

			nomeplaces = resultSet.getString("name_places");
			idplaces = resultSet.getInt("idplaces");
			
			Places places = new Places(idplaces, nomeplaces);
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
			    preparedStatement.setInt(3, placesToUpdate.getIdPlaces());
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
			places = new Places(idPlaces, name_places);
			places.setIdPlaces(idPlaces);
			cityplacesList.add(places);} 
	}catch (SQLException e) {
			e.printStackTrace();
	}
		
		return cityplacesList;}


public CityPlaces readPlaces2(int City_Idcity) {
	Connection connection = ConnectionSingleton.getInstance();
	try {
		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ2);
		preparedStatement.setInt(1, City_Idcity);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		int city_idcity;
		String nomeplaces;
		

		nomeplaces = resultSet.getString("name_places");
		city_idcity = resultSet.getInt("city_idcity");
		
		CityPlaces cityplaces = new CityPlaces(city_idcity, nomeplaces);
		cityplaces.setCity_Idcity(resultSet.getInt("city_idcity"));

		return cityplaces;
	} catch (SQLException e) {
		GestoreEccezioni.getInstance().gestisciEccezione(e);
		return null;
	}

}
}