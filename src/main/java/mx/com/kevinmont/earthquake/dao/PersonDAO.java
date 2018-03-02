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
    
    int delete(int id);
    
    String create(PersonVO person);
    
    PersonVO retrieve(int id);
    
    List<PersonVO> retrieveAll();
    
}
