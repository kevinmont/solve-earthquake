package mx.com.kevinmont.controller.impl;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import mx.com.kevinmont.earthquake.rest.controller.PersonController;
import mx.com.kevinmont.earthquake.rest.vo.PersonVO;
import mx.com.kevinmont.earthquake.service.PersonService;

@Controller

public class PersonControllerImpl2 implements PersonController {
	@Autowired
	PersonService personService;

	PersonControllerImpl2() {

	}

	@RequestMapping(value = "/a", method = RequestMethod.GET, produces= "application/json")
	public ResponseEntity addPersonController(@RequestParam (value = "personId", required=true) Integer id) {
		System.out.println(id);
		PersonVO personVO = this.personService.retrievePersonById(id);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("X-Total-Count", personVO.toString());
		return  new ResponseEntity<>(personVO,headers,HttpStatus.OK);
	}

}
