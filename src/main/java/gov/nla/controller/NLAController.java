package gov.nla.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import gov.nla.jpa.dao.Book;
import gov.nla.jpa.dao.Person;
import gov.nla.service.BookService;
import gov.nla.service.PersonServce;

/**
 * This is the central Controller class that handles all requests from the web browser
 * 
 * Intercepts the request url and then calls the relavent service methods and then returns 
 * the model to the view to display the response to the web browser.
 * 
 * @author Nishan Fonseka
 *
 */
@Controller
public class NLAController {
	
	
	@Autowired
	private PersonServce personServce;
	
	@Autowired
	private BookService bookService;
		
	/**
	 * Displays home page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showWelcome(ModelMap model) {
		
		return "welcome";
	}

	/**
	 * Handles displaying all library books
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list-books", method = RequestMethod.GET)
	public String showAllBooks(ModelMap model) {

		// find all library books
		List<Book> list =  bookService.findAllBooks();
		model.addAttribute("list", list);
		
		return "list-books";
	}
	
	
	/**
	 * Handles displaying all library patrons
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list-patrons", method = RequestMethod.GET)
	public String showAllPatrons(ModelMap model) {

		// find all library patrons
		List<Person> list =  personServce.findAllPersons();
		model.addAttribute("list", list);
		
		return "list-persons";
	}
	
	/**
	 * Handles displaying all library books for the patron
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list-patron-books", method = RequestMethod.GET)
	public String showAllooksForPatron(ModelMap model,  @RequestParam Long personId) {
		
		// find all library books for the patron
		List<Book> list =  personServce.findAllBooksBurrowedByPerson(personId);
		model.addAttribute("list", list);
		
		// find the patron name
		Person person =  personServce.findByPersonId(personId);
		model.addAttribute("name", person.getName());
		
		return "list-person-books";
	}
	
}
