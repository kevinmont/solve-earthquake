/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.kevinmont.earthquake.service.impl;

import java.util.List;
import mx.kevinmont.earthquake.issue.dao.PersonDAO;
import mx.com.kevinmont.earthquake.dao.utils.AbstractDAO;
import mx.kevinmont.earthquake.issue.rest.vo.PersonVO;
import mx.com.kevinmont.earthquake.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author mont
 */
@Component
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO personDAO;

    @Override
    public String create(PersonVO personVO) {
        /*Here must be the model logic*/
        if (personVO == null) {
            return "Error datos no validos";
        }

        if (personVO.getAge() < 1) {
            throw new IllegalArgumentException("age of a person must be greater than" + personVO.getAge());
        }
        personDAO.add(personVO);
        return personVO.getName();
    }

    @Override
    public int delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PersonVO> retrieveAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(PersonVO personVo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the personDAO
     */
    public PersonDAO getAbstractDAO() {
        return personDAO;
    }

    /**
     * @param personDAO the personDAO to set
     */
    @Override
    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
}
