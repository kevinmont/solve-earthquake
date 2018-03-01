/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.kevinmont.earthquake.service;

import java.util.List;
import mx.com.kevinmont.earthquake.dao.PersonDAO;
import mx.com.kevinmont.earthquake.dao.utils.AbstractDAO;
import mx.com.kevinmont.earthquake.rest.vo.PersonVO;
import org.springframework.stereotype.Component;

/**
 *
 * @author mont
 */
public interface PersonService {

    String create(PersonVO personVO);
    
    int delete(Integer id);
    
    List<PersonVO> retrieveAll();
    
    int update(PersonVO personVo);
    
    void setPersonDAO(PersonDAO personDAO);
}
