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
import it.contrader.model.Tags;


public class TagsDAO {

	private final String QUERY_ALL = "select * from tags";
	private final String QUERY_INSERT = "insert into tags (name_tag, name_place_tag ) values (?,?)";
	private final String QUERY_READ = "select * from tags where idtag=?";

	private final String QUERY_UPDATE = "UPDATE tags SET idtag=?,name_tag=?, name_place_tag=?  WHERE idtag=?";
	private final String QUERY_DELETE = "delete from tags where idtag=?";
	
	public TagsDAO() {

	}

	public List<Tags> getAllTags() {
		List<Tags> tagsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Tags tags;
			while (resultSet.next()) {
				int idTag = resultSet.getInt("idtag");
				String name_tag = resultSet.getString("name_tag");
				String name_place_tag = resultSet.getString("name_place_tag");
				tags = new Tags(idTag, name_tag, name_place_tag);
				tags.setIdTag(idTag);
				tagsList.add(tags);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tagsList;
	}

	public boolean insertTags(Tags tags) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, tags.getName_tag());
			preparedStatement.setString(2, tags.getName_place_tag());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public Tags readTags(int idTag) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idTag);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int idtag;
			String name_tag;
			String name_place_tag;

			name_tag = resultSet.getString("name_tag");
			name_place_tag = resultSet.getString("name_place_tag");
			idtag = resultSet.getInt("idtag");
			
			Tags tags = new Tags(idtag, name_tag, name_place_tag);
			tags.setIdTag(resultSet.getInt("idtag"));

			return tags;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updateTags(Tags tagsToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (tagsToUpdate.getIdTag() == 0)
			return false;

		
		Tags tagsRead = readTags(tagsToUpdate.getIdTag());
		if (!tagsRead.equals(tagsToUpdate)) {
			try {

				if (tagsToUpdate.getName_tag() == null || tagsToUpdate.getName_tag().equals("")) {
					tagsToUpdate.setName_tag(tagsRead.getName_tag());
				
				}
				

				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, tagsToUpdate.getIdTag());
				preparedStatement.setString(2, tagsToUpdate.getName_tag());
				preparedStatement.setString(3, tagsToUpdate.getName_place_tag());
			    preparedStatement.setInt(4, tagsToUpdate.getIdTag());
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

	public boolean deleteTags(Integer id) {
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
