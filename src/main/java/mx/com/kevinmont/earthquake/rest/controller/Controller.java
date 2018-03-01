/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.kevinmont.earthquake.rest.controller;

import java.util.Scanner;
import mx.kevinmont.earthquake.issue.rest.vo.PersonVO;
import mx.com.kevinmont.earthquake.service.PersonService;
import mx.com.kevinmont.earthquake.view.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author mont
 */
@Component
public class Controller {
    
    public void start(){
       String strOption = null;
        do {
            this.getView().showMenu();
            strOption = getScanner().next();
            switch (strOption) {
                case "2":
                    this.handleCreatePerson();
                    break;
            }
        } while (!strOption.equals("5"));
    }
    
    private void handleCreatePerson(){
        PersonVO personVo= new PersonVO();
        
        getView().showTypeFirstName();
        personVo.setName(getScanner().next());
        
        getView().showTypeLastName();
        personVo.setLastName(getScanner().next());
        
        getView().showTypeAge();
        personVo.setAge(getScanner().nextShort());
        
        getView().showTypePhysicalFeatures();
        personVo.setPhysicalFeatures(getScanner().next());
        
        getView().showTypeImage();
        personVo.setImage(getScanner().next());
        
        getView().showTypeDescription();
        personVo.setDescription(getScanner().next());
        
        getView().showTypeTemporaryShelter();
        personVo.setTemporaryShelter(getScanner().nextShort());
        
        getPersonService().create(personVo);
    }

    /**
     * @return the personService
     */
    public PersonService getPersonService() {
        return personService;
    }

    /**
     * @param personService the personService to set
     */
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    /**
     * @return the view
     */
    public View getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(View view) {
        this.view = view;
    }

    /**
     * @return the scanner
     */
    public Scanner getScanner() {
        return scanner;
    }

    /**
     * @param scanner the scanner to set
     */
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
    @Autowired
    private PersonService personService;
    @Autowired
    private View view;
    @Autowired
    private Scanner scanner;
}
