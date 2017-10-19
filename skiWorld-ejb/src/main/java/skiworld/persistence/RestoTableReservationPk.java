package skiworld.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
@Embeddable
public class RestoTableReservationPk implements Serializable{
	private int id_user;
	private int id_table;
	private Date StartTime;
	private Date EndTime;
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getId_table() {
		return id_table;
	}
	public void setId_table(int id_table) {
		this.id_table = id_table;
	}
	public Date getStartTime() {
		return StartTime;
	}
	public void setStartTime(Date startTime) {
		StartTime = startTime;
	}
	public Date getEndTime() {
		return EndTime;
	}
	public void setEndTime(Date endTime) {
		EndTime = endTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((EndTime == null) ? 0 : EndTime.hashCode());
		result = prime * result + ((StartTime == null) ? 0 : StartTime.hashCode());
		result = prime * result + id_table;
		result = prime * result + id_user;
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
		RestoTableReservationPk other = (RestoTableReservationPk) obj;
		if (EndTime == null) {
			if (other.EndTime != null)
				return false;
		} else if (!EndTime.equals(other.EndTime))
			return false;
		if (StartTime == null) {
			if (other.StartTime != null)
				return false;
		} else if (!StartTime.equals(other.StartTime))
			return false;
		if (id_table != other.id_table)
			return false;
		if (id_user != other.id_user)
			return false;
		return true;
	}
	
	

}
