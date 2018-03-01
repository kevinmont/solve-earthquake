/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.kevinmont.earthquake.dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author mont
 */
@Component
public abstract class AbstractDAO {

    @Value("${db.driver_class_name}")
    private String driver_class_name;
    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public AbstractDAO() {

    }

    public void init() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName(getUrl()).newInstance();
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(getUrl(), getUser(), getPassword());
    }

    /**
     * @return the driver_class_name
     */
    public String getDriver_class_name() {
        return driver_class_name;
    }

    /**
     * @param driver_class_name the driver_class_name to set
     */
    public void setDriver_class_name(String driver_class_name) {
        this.driver_class_name = driver_class_name;
    }

}
