package gov.nla.jpa.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Class for Book table
 * 
 * @author Nishan Fonseka
 *
 */
@Entity
public class Book {

	@Id
	@Column(columnDefinition = "VARCHAR(30)")
	private String isbn;
	
	@OneToOne(mappedBy = "book")
    private Burrowing burrowing;
	
	@Column(columnDefinition = "VARCHAR(200)")
	private String title;
	
	@Column(columnDefinition = "VARCHAR(60)")
	private String author;
	
	public Book() {	
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Burrowing getBurrowing() {
		return burrowing;
	}

	public void setBurrowing(Burrowing burrowing) {
		this.burrowing = burrowing;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + "]";
	}

}
