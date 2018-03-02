/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.kevinmont.earthquake.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import mx.com.kevinmont.earthquake.dao.PersonDAO;
import mx.com.kevinmont.earthquake.dao.utils.AbstractDAO;
import mx.com.kevinmont.earthquake.rest.vo.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author mont
 */
@Component
public class PersonDAOimpl extends AbstractDAO implements PersonDAO {

	Connection connection;
	ResultSet resultSet;

	@Override
	public PersonVO retrieve(int id) {
		PreparedStatement statement = null;
		PersonVO personVO=null;
		try {
			connection = getConnection();
			String sql = "SELECT * FROM person where person_id = ?";
			personVO = new PersonVO();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				personVO.setId(resultSet.getShort(1));
				personVO.setName(resultSet.getString(2));
				personVO.setLastName(resultSet.getString(3));
				personVO.setAge(resultSet.getShort(4));
				personVO.setPhysicalFeatures(resultSet.getString(5));
				personVO.setImage(resultSet.getString(6));
				personVO.setDescription(resultSet.getString(7));
			}
		} catch (SQLException ex) {
			Logger.getLogger(PersonDAOimpl.class.getName()).log(Level.SEVERE, null, ex);

		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
				}
			}
		}
		return personVO;
	}

	@Override
	public List<PersonVO> retrieveAll() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public int update(PersonVO person) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public int delete(int id) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public String create(PersonVO person) {
		boolean successful = false;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			String sql = "INSERT INTO person(first_name, last_name, age, physical_features,"
					+ "image, description, temporary_shelter_id) values ( ? , ? , ? , ? , ? , ? , ? )";

			statement = connection.prepareStatement(sql);
			statement.setString(1, person.getName());
			statement.setString(2, person.getLastName());
			statement.setShort(3, person.getAge());
			statement.setString(4, person.getPhysicalFeatures());
			statement.setString(5, person.getImage());
			statement.setString(6, person.getDescription());
			statement.setShort(7, person.getTemporaryShelter());
			successful = statement.execute();
		} catch (SQLException ex) {
			Logger.getLogger(PersonDAOimpl.class.getName()).log(Level.SEVERE, null, ex);

		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ex) {
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
				}
			}
		}
		return person.getName();
	}

}
