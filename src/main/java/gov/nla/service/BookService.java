package gov.nla.service;

import java.util.List;

import gov.nla.jpa.dao.Book;

/**
 * Interface for defining methods for BookService
 * 
 * @author Nishan Fonseka
 *
 */
public interface BookService {
	
	public Book findBookByISBN(String isbn);
	
	public List<Book>findAllBooks();
	
}
