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
import it.contrader.dto.CityDTO;
import it.contrader.model.City;


public class CityDAO {

	private final String QUERY_ALL = "select * from city";
	private final String QUERY_INSERT = "insert into city (name_city) values (?)";
	private final String QUERY_READ = "select * from city where idcity=?";

	private final String QUERY_UPDATE = "UPDATE city SET idcity=?,name_city=? WHERE idcity=?";
	private final String QUERY_DELETE = "delete from city where idcity=?";
	
	public CityDAO() {

	}

	public List<City> getAllCity() {
		List<City> cityList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			City city;
			while (resultSet.next()) {
				int idCity = resultSet.getInt("idCity");
				String name_city = resultSet.getString("name_city");
				city = new City(idCity, name_city);
				city.setIdCity(idCity);
				cityList.add(city);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cityList;
	}

	public boolean insertCity(City city) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, city.getNomeCity());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public City readCity(int idCity) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idCity);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int idcity;
			String nomecity;
			

			nomecity = resultSet.getString("name_city");
			idcity = resultSet.getInt("idcity");
			
			City city = new City(idcity, nomecity);
			city.setIdCity(resultSet.getInt("idcity"));

			return city;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updateCity(City cityToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (cityToUpdate.getIdCity() == 0)
			return false;

		
		City cityRead = readCity(cityToUpdate.getIdCity());
		if (!cityRead.equals(cityToUpdate)) {
			try {
				// Fill the cityToUpdate object
				if (cityToUpdate.getNomeCity() == null || cityToUpdate.getNomeCity().equals("")) {
					cityToUpdate.setNomeCity(cityRead.getNomeCity());
				
				}
				
				// Update the city
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, cityToUpdate.getIdCity());
				preparedStatement.setString(2, cityToUpdate.getNomeCity());
			    preparedStatement.setInt(3, cityToUpdate.getIdCity());
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

	public boolean deleteCity(Integer id) {
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
