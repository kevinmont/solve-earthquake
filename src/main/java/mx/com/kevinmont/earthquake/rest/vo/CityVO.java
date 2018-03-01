/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.kevinmont.earthquake.rest.vo;

/**
 *
 * @author mont
 */
public class CityVO {

    /**
     * @return the cityId
     */
    public short getCityId() {
        return cityId;
    }

    /**
     * @param cityId the cityId to set
     */
    public void setCityId(short cityId) {
        this.cityId = cityId;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }
    private short cityId;
    private String city;
}
