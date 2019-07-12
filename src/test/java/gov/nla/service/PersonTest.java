package gov.nla.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import gov.nla.config.db.H2DataSource;
import gov.nla.jpa.dao.Burrowing;
import gov.nla.jpa.dao.Person;
import gov.nla.jpa.dao.PersonRepository;

/**
 * Test cases for testing in memory database to ensure JPA queries work 
 * and return valid objects.
 * Test the Person service methods which in turn calls into the in memory database
 * 
 * @author Nishan Fonseka
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { H2DataSource.class }, loader = AnnotationConfigContextLoader.class)
@Transactional
public class PersonTest {

	@Resource
	private PersonRepository personRepository;

	@Test
	public void testPerson() {
		
		Person person = personRepository.findOne(1L);
		assertEquals("Wrong Name", "Nishan Fonseka", person.getName());
		assertEquals("Wrong Email", "nishan@gmail.com", person.getEmail());
		assertEquals("Wrong Phone", "04234 768 435", person.getPhone());
	}
	
	
	@Test
	public void testBurrowings() {
		
		Person person = personRepository.findOne(1L);
		List<Burrowing> burrowings = person.getBurrowings();
	
		assertEquals("Wrong Name", 4, burrowings.size());
	}

}
