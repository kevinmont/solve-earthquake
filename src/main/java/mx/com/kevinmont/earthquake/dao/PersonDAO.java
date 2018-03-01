/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.kevinmont.earthquake.dao;

import java.util.List;
import mx.com.kevinmont.earthquake.rest.vo.PersonVO;

/**
 *
 * @author mont
 */
public interface PersonDAO {
    
    int update(PersonVO person);
    
    boolean delete(int id);
    
    boolean add(PersonVO person);
    
    PersonVO retrieve();
    
    List<PersonVO> retrieveAll();
    
}
