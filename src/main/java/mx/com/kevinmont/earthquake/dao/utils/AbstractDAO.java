/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.kevinmont.earthquake.dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author mont
 */

public abstract class AbstractDAO {

	@Value("${db.driver_class_name}")
	private String driverClassName;
	@Value("${db.url}")
	private String url;
	@Value("${db.user}")
	private String user;
	@Value("${db.password}")
	private String password;

	public AbstractDAO() {

	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	
	@PostConstruct	
	public void init() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(getUrl(),getUser(),getPassword());
	}

}
