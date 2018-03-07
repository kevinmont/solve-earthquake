package mx.com.kevinmont.earthquake.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.kevinmont.earthquake.config.ApplicationContext;
import mx.com.kevinmont.earthquake.rest.vo.PersonVO;
import mx.com.kevinmont.earthquake.service.PersonService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContext.class)
public class PersonServiceImplTest {

	@Autowired
	PersonService personService;
	
	@Test
	public void getPersont() {
		PersonVO personVO= personService.retrievePersonById(2);
		assertNotNull(personVO);
	}

}
