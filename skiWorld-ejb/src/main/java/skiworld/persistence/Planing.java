package skiworld.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Planing implements Serializable {
	private int IdPlaning;
	private String name;
	private Date date;
	private String description;
	private Instructor instructor;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdPlaning() {
		return IdPlaning;
	}

	public void setIdPlaning(int idPlaning) {
		IdPlaning = idPlaning;
	}
	@ManyToOne
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

}
