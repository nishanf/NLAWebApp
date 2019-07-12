package gov.nla.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.nla.jpa.dao.Book;
import gov.nla.jpa.dao.Burrowing;
import gov.nla.jpa.dao.Person;
import gov.nla.jpa.dao.PersonRepository;


/**
 * Service implementation class for Person table 
 * Calls PersonRepositorys defined methods and return results
 * 
 * @author Nishan Fonseka
 *
 */
@Service
public class PersonServiceImpl implements PersonServce
{
	@Autowired
	PersonRepository personRepository;

	
	public Person findByPersonId(Long personId) {
        
		return personRepository.findOne(personId);
	}
	
	public List<Person> findAllPersons() {
        
		return personRepository.findAll();
	}

	@Transactional
	public List<Book> findAllBooksBurrowedByPerson(Long personId) {
        
		List<Book> bookList = new ArrayList<Book>();
		
		Person person = personRepository.findOne(personId);
		List<Burrowing> burrowings = person.getBurrowings();
		
		for (Burrowing burrowing : burrowings) {	
			
			Book book = burrowing.getBook();
			bookList.add(book);
		}
		
		return bookList;
	}
	
}
