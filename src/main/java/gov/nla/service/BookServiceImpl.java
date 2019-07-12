package gov.nla.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.nla.jpa.dao.Book;
import gov.nla.jpa.dao.BookRepository;

/**
 * Implementation of Books related services
 * Calls BookRepositorys defined methods and return results
 * 
 * @author Nishan Fonseka
 *
 */
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book findBookByISBN(String isbn) {
		
		return bookRepository.findOne(isbn);
	}

	@Override
	public List<Book> findAllBooks() {
		
		return bookRepository.findAll();
	}

}
