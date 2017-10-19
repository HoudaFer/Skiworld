package skiworld.persistence;

import javax.persistence.Entity;

@Entity
public class SkiMan extends User {
	private String profilePicture;
	private String registrationNumber;

	public String getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	
}
