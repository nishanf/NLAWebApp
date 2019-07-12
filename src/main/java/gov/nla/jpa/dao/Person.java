package gov.nla.jpa.dao;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * Class for Person table
 * 
 * @author Nishan Fonseka
 *
 */
@Entity
public class Person {

	@Id
	@GeneratedValue
	@Column(name="person_id", columnDefinition = "INTEGER")
	private Long personId;
	
	@OneToMany
	@JoinColumn(name = "person_id", referencedColumnName = "person_id")
	private List<Burrowing> burrowings;
		
	@Column(columnDefinition = "VARCHAR(30)")
	private String email;
	
	@Column(columnDefinition = "VARCHAR(30)")
	private String name;
	
	@Column(columnDefinition = "VARCHAR(20)")
	private String phone;

	public Person() {
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public List<Burrowing> getBurrowings() {
		return burrowings;
	}

	public void setBurrowings(List<Burrowing> burrowings) {
		this.burrowings = burrowings;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", name=" + name + ", email=" + email + " phone=" + phone + "]";
	}

}
