package skiworld.persistence;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Instructor extends User {
	private String registrationNumber;
	private Integer experienceIns;
	private List<Planing> planing;

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Integer getExperienceIns() {
		return experienceIns;
	}

	public void setExperienceIns(Integer experienceIns) {
		this.experienceIns = experienceIns;
	}
	@OneToMany(mappedBy="instructor")
	public List<Planing> getPlaning() {
		return planing;
	}

	public void setPlaning(List<Planing> planing) {
		this.planing = planing;
	}


}
