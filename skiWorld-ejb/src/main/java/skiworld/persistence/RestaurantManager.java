package skiworld.persistence;

import javax.persistence.Entity;

@Entity
public class RestaurantManager extends User {
	private String registrationNumber;
	private int experienceRes;
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public int getExperienceRes() {
		return experienceRes;
	}
	public void setExperienceRes(int experienceRes) {
		this.experienceRes = experienceRes;
	}
	
	
}
