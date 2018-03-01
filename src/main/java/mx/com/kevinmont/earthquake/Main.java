package mx.com.kevinmont.earthquake;

import java.util.Scanner;
import mx.com.kevinmont.earthquake.dao.PersonDAO;
import mx.com.kevinmont.earthquake.dao.impl.PersonDAOimpl;
import mx.com.kevinmont.earthquake.dao.utils.AbstractDAO;
import mx.com.kevinmont.earthquake.rest.controller.Controller;
import mx.com.kevinmont.earthquake.service.PersonService;
import mx.com.kevinmont.earthquake.service.impl.PersonServiceImpl;
import mx.com.kevinmont.earthquake.view.View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mont
 */
public class Main {
    public static void main(String arg[]){
        PersonDAOimpl jdbcDao= new PersonDAOimpl();
        jdbcDao.setUser("root");
        jdbcDao.setPassword("gusanito");
        jdbcDao.setUrl("jdbc:mysql://127.0.0.1:3306/vidas");
        
        
        PersonService personService= new PersonServiceImpl();
        personService.setPersonDAO(jdbcDao);
        
        Controller controller = new Controller();
        controller.setPersonService(personService);
        
        controller.setScanner(new Scanner(System.in));
        
        controller.setView(new View());
        controller.start();
        
    }
}
