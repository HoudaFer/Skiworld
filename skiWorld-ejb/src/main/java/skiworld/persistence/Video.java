package skiworld.persistence;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Video extends Gallery{

	private String video;
	private User user ;
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	@ManyToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
