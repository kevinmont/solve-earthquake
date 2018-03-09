/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.kevinmont.earthquake.service.impl;

import java.util.List;

import mx.com.kevinmont.earthquake.config.ConfigAOP;
import mx.com.kevinmont.earthquake.dao.PersonDAO;
import mx.com.kevinmont.earthquake.rest.vo.PersonVO;
import mx.com.kevinmont.earthquake.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author mont
 */
@Component
public class PersonServiceImpl implements PersonService {

    private PersonDAO personDAO;

    @Override
    @ConfigAOP
    public String createPerson(PersonVO personVO) {
        /*Here must be the model logic*/
        if (personVO == null) {
            return "Error datos no validos";
        }

        if (personVO.getAge() < 1) {
            throw new RuntimeException("Person's age must be greater than " + personVO.getAge());
        }
        personDAO.create(personVO);
        return personVO.getName();
    }

	@Override
	@ConfigAOP
	public int updatePerson(PersonVO person) {
		if(person == null) {
			throw new RuntimeException("Person mustn´t be null");
		}
		return personDAO.update(person);
	}

	@Override
	@ConfigAOP
	public PersonVO retrievePersonById(int id) {
		if(id<1)
			throw new IllegalArgumentException("Person's id must be greater than " +id);
		return personDAO.retrieve(id);
	}

	@Override
	@ConfigAOP
	public List<PersonVO> retrievePersons() {
		return personDAO.retrieveAll();
	}

	@Override
	@ConfigAOP
	public int deletePersonById(int id) {
		if(id<1) {
			throw new RuntimeException("Person's id must be greater than " +id);
		}
		return personDAO.delete(id);
	}
	
	@Autowired
	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO=personDAO;
	}

}
