package skiworld.persistence;

import javax.persistence.Entity;

@Entity
public class EventHolder extends User {
	private String registrationNumberEvent;
	private int experienceEvent;

	public String getRegistrationNumberEvent() {
		return registrationNumberEvent;
	}

	public void setRegistrationNumberEvent(String registrationNumberEvent) {
		this.registrationNumberEvent = registrationNumberEvent;
	}

	public int getExperienceEvent() {
		return experienceEvent;
	}

	public void setExperienceEvent(int experienceEvent) {
		this.experienceEvent = experienceEvent;
	}

}
