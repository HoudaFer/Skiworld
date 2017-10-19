package skiworld.persistence;

import javax.persistence.Entity;

@Entity
public class Player extends User{
	private int age;
	private int experiencePlayer;
	private PlayersType type;
	private boolean isVIP;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getExperiencePlayer() {
		return experiencePlayer;
	}
	public void setExperiencePlayer(int experiencePlayer) {
		this.experiencePlayer = experiencePlayer;
	}
	public PlayersType getType() {
		return type;
	}
	public void setType(PlayersType type) {
		this.type = type;
	}
	public boolean isVIP() {
		return isVIP;
	}
	public void setVIP(boolean isVIP) {
		this.isVIP = isVIP;
	}
	
	
}
