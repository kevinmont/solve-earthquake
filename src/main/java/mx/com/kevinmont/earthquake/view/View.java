/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.kevinmont.earthquake.view;

import java.util.List;
import mx.com.kevinmont.earthquake.rest.vo.PersonVO;
import org.springframework.stereotype.Component;

/**
 *
 * @author mont
 */
@Component
public class View {

    public View() {
    }

    public void showMenu() {
        String strMainMenu = "";
        strMainMenu += "Selecciona una opcion:";
        strMainMenu += "\n\t1. Mostrar todos las personas";
        strMainMenu += "\n\t2. Agregar persona";
        strMainMenu += "\n\t3. Eliminar persona";
        strMainMenu += "\n\t4. Editar persona";
        strMainMenu += "\n\t5. Salir";
        strMainMenu += "\n\nR: ";
        System.out.println(strMainMenu);
    }

    public void showTypeFirstName() {
        System.out.print("Type First Name: \n");
    }

    public void showTypeLastName() {
        System.out.print("Type Last Name: \n");
    }

    public void showTypeAge() {
        System.out.print("Type Age: \n");
    }

    public void showTypePhysicalFeatures() {
        System.out.print("Type Physical Features: \n");
    }

    public void showTypeImage() {
        System.out.print("Type Image: \n");
    }

    public void showTypeDescription() {
        System.out.print("Type Description: \n");
    }

    public void showTypeTemporaryShelter() {
        System.out.print("Type Temporary Shelter: \n");
    }

    public void printAllPersons(List<PersonVO> persons) {
        for (PersonVO person : persons) {
            System.out.println(">>> Listing user: " + person.getName());
            System.out.println(" - First Name: " + person.getName());
            System.out.println(" - Last Name: " + person.getLastName());
            System.out.println(" - Physical Features: " + person.getPhysicalFeatures());
            System.out.println(" - Image: " + person.getImage());
            System.out.println(" - Description: " + person.getDescription());
            System.out.println(" - Temporary Shelter: " + person.getTemporaryShelter());
        }
    }
}
