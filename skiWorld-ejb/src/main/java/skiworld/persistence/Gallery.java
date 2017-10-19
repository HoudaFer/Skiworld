package skiworld.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Gallery implements Serializable {
	private int idGallery;
	private String description;
	private Date addedDate;

	@Id
	public int getIdGallery() {
		return idGallery;
	}

	public void setIdGallery(int idGallery) {
		this.idGallery = idGallery;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

}
