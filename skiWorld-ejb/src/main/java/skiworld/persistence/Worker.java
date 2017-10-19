package skiworld.persistence;

import javax.persistence.Entity;

@Entity
public class Worker extends User {
	private String experienceWorker;
	private String speciality;
	private String registrationNumbe;
	public String getExperienceWorker() {
		return experienceWorker;
	}
	public void setExperienceWorker(String experienceWorker) {
		this.experienceWorker = experienceWorker;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getRegistrationNumbe() {
		return registrationNumbe;
	}
	public void setRegistrationNumbe(String registrationNumbe) {
		this.registrationNumbe = registrationNumbe;
	}
	
	
}
