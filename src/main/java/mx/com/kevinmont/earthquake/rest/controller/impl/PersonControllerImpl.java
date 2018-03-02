package mx.com.kevinmont.earthquake.rest.controller.impl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.google.gson.Gson;
import mx.com.kevinmont.earthquake.rest.controller.PersonController;
import mx.com.kevinmont.earthquake.rest.vo.PersonVO;
import mx.com.kevinmont.earthquake.service.PersonService;


public class PersonControllerImpl extends HttpServlet implements PersonController {
	
	private PersonService personService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		List<PersonVO> persons= this.personService.retrievePersons();
//		String jsonPersons= new Gson().toJson(persons);
//		resp.setContentType("application/json");
//		resp.getWriter().print(jsonPersons);
		short idPerson= Short.valueOf(req.getParameter("person_id"));
		PersonVO personVO= this.personService.retrievePersonById(idPerson);
		String jsonPerson = new Gson().toJson(personVO);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonPerson);
	}

	@Override
	public void init() throws ServletException {
		ApplicationContext context= (ApplicationContext) this.getServletContext().getAttribute("application");
		personService= context.getBean(PersonService.class);
	}
	
}
