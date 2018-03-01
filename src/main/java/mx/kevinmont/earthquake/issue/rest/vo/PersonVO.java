/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.kevinmont.earthquake.issue.rest.vo;

import java.awt.Image;

/**
 *
 * @author mont
 */
public class PersonVO {
    private short id;
    private String name;
    private String lastName;
    private short age;
    private String physicalFeatures;
    private String image;
    private String description;
    private short temporaryShelter;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the age
     */
    public short getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(short age) {
        this.age = age;
    }

    /**
     * @return the physicalFeatures
     */
    public String getPhysicalFeatures() {
        return physicalFeatures;
    }

    /**
     * @param physicalFeatures the physicalFeatures to set
     */
    public void setPhysicalFeatures(String physicalFeatures) {
        this.physicalFeatures = physicalFeatures;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * @return the temporaryShelter
     */
    public short getTemporaryShelter() {
        return temporaryShelter;
    }

    /**
     * @param temporaryShelter the temporaryShelter to set
     */
    public void setTemporaryShelter(short temporaryShelter) {
        this.temporaryShelter = temporaryShelter;
    }

    /**
     * @return the id
     */
    public short getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(short id) {
        this.id = id;
    }
}
