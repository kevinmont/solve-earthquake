/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.kevinmont.earthquake.service.impl;

import java.util.List;
import mx.com.kevinmont.earthquake.dao.PersonDAO;
import mx.com.kevinmont.earthquake.dao.utils.AbstractDAO;
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
    public String createPerson(PersonVO personVO) {
        /*Here must be the model logic*/
        if (personVO == null) {
            return "Error datos no validos";
        }

        if (personVO.getAge() < 1) {
            throw new IllegalArgumentException("Person's age must be greater than " + personVO.getAge());
        }
        personDAO.create(personVO);
        return personVO.getName();
    }

	@Override
	public int updatePerson(PersonVO person) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PersonVO retrievePersonById(int id) {
		if(id<1)
			throw new IllegalArgumentException("Person's id must be greater than " +id);
		return personDAO.retrieve(id);
	}

	@Override
	public List<PersonVO> retrievePersons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deletePersonById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Autowired
	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO=personDAO;
	}

}
