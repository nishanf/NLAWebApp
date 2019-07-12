package gov.nla.service;

import java.util.List;

import gov.nla.jpa.dao.Book;
import gov.nla.jpa.dao.Person;


/**
 * Interface for defining methods for PersonServce
 * 
 * @author Nishan Fonseka
 *
 */
public interface PersonServce {

	
    public Person findByPersonId(Long personId);
	
	public List<Person> findAllPersons();
	
	public List<Book> findAllBooksBurrowedByPerson(Long personId);
	
}
