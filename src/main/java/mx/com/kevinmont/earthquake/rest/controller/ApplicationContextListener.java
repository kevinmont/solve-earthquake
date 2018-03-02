package mx.com.kevinmont.earthquake.rest.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ApplicationContext context= new ClassPathXmlApplicationContext("/mx/com/kevin/mont/earthquake/applicationContext.xml");
		arg0.getServletContext().setAttribute("application", context);
	}

}
