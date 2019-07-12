package gov.nla.jpa.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Class for Burrowing table
 * 
 * @author Nishan Fonseka
 *
 */
@Entity
@Table(name = "Burrowings")
public class Burrowing {

	@Id
	@GeneratedValue
	@Column(name="burrow_id", columnDefinition = "INTEGER")
	private Long burrowId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person person;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "isbn", referencedColumnName = "isbn")
	private Book book;

	public Burrowing() {
	}
	
	public Long getBurrowId() {
		return burrowId;
	}

	public void setBurrowId(Long burrowId) {
		this.burrowId = burrowId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Burrowing [personId=" + person.getPersonId() + ", isbn=" + book.getIsbn() + "]";
	}

}
