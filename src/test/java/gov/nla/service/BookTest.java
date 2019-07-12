package gov.nla.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import gov.nla.config.db.H2DataSource;
import gov.nla.jpa.dao.Book;
import gov.nla.jpa.dao.BookRepository;

/**
 * Test cases for testing in memory database to ensure JPA queries work 
 * and return valid objects.
 * Test the Book service methods which in turn calls into the in memory database
 * 
 * @author Nishan Fonseka
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { H2DataSource.class }, loader = AnnotationConfigContextLoader.class)
@Transactional
public class BookTest {

	@Resource
	private BookRepository bookRepository;

	@Test
	public void testTitle() {
		
		Book book = bookRepository.findOne("545645");
		assertEquals("Wrong Title", "Art of Zen", book.getTitle());
	}
	
	
	@Test
	public void testInsertNewBook() {
		Book book = new Book();
		book.setIsbn("3638768");
		book.setTitle("Junit Tests");
		book.setAuthor("John Dee");
		bookRepository.save(book);
		
		Book book2 = bookRepository.findOne("3638768");
		assertEquals("Wrong Title", "Junit Tests", book2.getTitle());
		assertEquals("Wrong Author", "John Dee", book2.getAuthor());
		
		List<Book> list = bookRepository.findAll();
		Assert.assertEquals(9, list.size());
	}

	
}
