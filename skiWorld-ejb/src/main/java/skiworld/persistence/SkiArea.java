package skiworld.persistence;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
//@NamedQuery(name="SkiArea.complex",query="select s from SkiArea s where ")
public class SkiArea implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idArea;
	private String name;
	private boolean isAvailable;
	private Integer spectatorNumber;
	private String address;
	private Blob image;
	private SkiAreaType skiAreaType;
	private List<SkiAreaReservation> skiAreaReservation ;
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}



	
@OneToMany(mappedBy="skiArea")
	public List<SkiAreaReservation> getSkiAreaReservation() {
		return skiAreaReservation;
	}

	public void setSkiAreaReservation(List<SkiAreaReservation> skiAreaReservation) {
		this.skiAreaReservation = skiAreaReservation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	@ManyToOne
	public SkiAreaType getSkiAreaType() {
		return skiAreaType;
	}

	public void setSkiAreaType(SkiAreaType skiAreaType) {
		this.skiAreaType = skiAreaType;
	}

	public Integer getSpectatorNumber() {
		return spectatorNumber;
	}

	public void setSpectatorNumber(Integer spectatorNumber) {
		this.spectatorNumber = spectatorNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + idArea;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + (isAvailable ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((skiAreaReservation == null) ? 0 : skiAreaReservation.hashCode());
		result = prime * result + ((skiAreaType == null) ? 0 : skiAreaType.hashCode());
		result = prime * result + ((spectatorNumber == null) ? 0 : spectatorNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SkiArea other = (SkiArea) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (idArea != other.idArea)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (isAvailable != other.isAvailable)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (skiAreaReservation == null) {
			if (other.skiAreaReservation != null)
				return false;
		} else if (!skiAreaReservation.equals(other.skiAreaReservation))
			return false;
		if (skiAreaType == null) {
			if (other.skiAreaType != null)
				return false;
		} else if (!skiAreaType.equals(other.skiAreaType))
			return false;
		if (spectatorNumber == null) {
			if (other.spectatorNumber != null)
				return false;
		} else if (!spectatorNumber.equals(other.spectatorNumber))
			return false;
		return true;
	}

	



}
