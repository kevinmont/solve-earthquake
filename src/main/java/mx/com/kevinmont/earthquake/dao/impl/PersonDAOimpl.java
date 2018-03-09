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
import java.util.ArrayList;
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

	private Connection connection = null;
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement = null;

	@Override
	public PersonVO retrieve(int id) {
		PersonVO personVO = null;
		try {
			this.connection = getConnection();
			String sql = "SELECT * FROM person where person_id = ?";
			personVO = new PersonVO();
			this.preparedStatement = this.connection.prepareStatement(sql);
			this.preparedStatement.setInt(1, id);
			this.resultSet = preparedStatement.executeQuery();

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
			if (this.preparedStatement != null) {
				try {
					this.preparedStatement.close();
					this.connection.close();
				} catch (SQLException ex) {
				}
			}
		}
		return personVO;
	}

	@Override
	public List<PersonVO> retrieveAll() {
		List<PersonVO> personVO = null;
		try {
			personVO= new ArrayList<>();
			this.connection= getConnection();
			this.preparedStatement = this.connection.prepareStatement("SELECT * FROM person");
			this.resultSet  = this.preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				PersonVO temp_personVO= new PersonVO();
				temp_personVO.setId(resultSet.getShort(1));
				temp_personVO.setName(resultSet.getString(2));
				temp_personVO.setLastName(resultSet.getString(3));
				temp_personVO.setAge(resultSet.getShort(4));
				temp_personVO.setPhysicalFeatures(resultSet.getString(5));
				temp_personVO.setImage(resultSet.getString(6));
				temp_personVO.setDescription(resultSet.getString(7));
				temp_personVO.setTemporaryShelter(resultSet.getShort(8));
				personVO.add(temp_personVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personVO;
	}

	@Override
	public int update(PersonVO person) {
		int rowsAffected = 0;
		try {
			String sql = "INSERT INTO person(first_name, last_name, age, physical_features,"
					+ "image, description, temporary_shelter_id) values ( ? , ? , ? , ? , ? , ? , ? )";

			this.preparedStatement = this.connection.prepareStatement(sql);
			this.preparedStatement.setString(1, person.getName());
			this.preparedStatement.setString(2, person.getLastName());
			this.preparedStatement.setShort(3, person.getAge());
			this.preparedStatement.setString(4, person.getPhysicalFeatures());
			this.preparedStatement.setString(5, person.getImage());
			this.preparedStatement.setString(6, person.getDescription());
			this.preparedStatement.setShort(7, person.getTemporaryShelter());
			rowsAffected = this.preparedStatement.executeUpdate();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					this.preparedStatement.close();
					this.connection.close();
				} catch (SQLException e) {
				}
			}
		}
		return rowsAffected;
	}

	@Override
	public int delete(int id) {
		int rowsAffected = 0;
		try {
			this.connection = getConnection();
			this.preparedStatement = this.connection.prepareStatement("delete from person where person_id = ? ");
			this.preparedStatement.setInt(1, id);
			rowsAffected = this.preparedStatement.executeUpdate();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					this.preparedStatement.close();
					this.connection.close();
				} catch (SQLException e) {
				}
			}
		}
		return rowsAffected;
	}

	@Override
	public String create(PersonVO person) {
		try {
			this.connection = getConnection();
			String sql = "INSERT INTO person(first_name, last_name, age, physical_features,"
					+ "image, description, temporary_shelter_id) values ( ? , ? , ? , ? , ? , ? , ? )";

			this.preparedStatement = this.connection.prepareStatement(sql);
			this.preparedStatement.setString(1, person.getName());
			this.preparedStatement.setString(2, person.getLastName());
			this.preparedStatement.setShort(3, person.getAge());
			this.preparedStatement.setString(4, person.getPhysicalFeatures());
			this.preparedStatement.setString(5, person.getImage());
			this.preparedStatement.setString(6, person.getDescription());
			this.preparedStatement.setShort(7, person.getTemporaryShelter());
			this.preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(PersonDAOimpl.class.getName()).log(Level.SEVERE, null, ex);

		} finally {
			if (this.preparedStatement != null) {
				try {
					this.preparedStatement.close();
					this.connection.close();
				} catch (SQLException ex) {
				}
			}
		}
		return person.getName();
	}

}
