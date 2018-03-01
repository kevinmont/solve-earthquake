/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.kevinmont.earthquake.issue.rest.vo;

/**
 *
 * @author mont
 */
public class AddressVO {

    /**
     * @return the address_id
     */
    public short getAddress_id() {
        return address_id;
    }

    /**
     * @param address_id the address_id to set
     */
    public void setAddress_id(short address_id) {
        this.address_id = address_id;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * @return the city_id
     */
    public String getCity_id() {
        return city_id;
    }

    /**
     * @param city_id the city_id to set
     */
    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    /**
     * @return the temporaryShelter
     */
    public String getTemporaryShelter() {
        return temporaryShelter;
    }

    /**
     * @param temporaryShelter the temporaryShelter to set
     */
    public void setTemporaryShelter(String temporaryShelter) {
        this.temporaryShelter = temporaryShelter;
    }
    private short address_id;
    private String street;
    private String zipCode;
    private String city_id;
    private String temporaryShelter;
    
    
}
