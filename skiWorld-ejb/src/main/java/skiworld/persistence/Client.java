package skiworld.persistence;

import javax.persistence.Entity;

@Entity
public class Client extends User{
	private String creditCardNumber;
	private int numberVisits;
	private boolean isVIP;

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public int getNumberVisits() {
		return numberVisits;
	}

	public void setNumberVisits(int numberVisits) {
		this.numberVisits = numberVisits;
	}

	public boolean isVIP() {
		return isVIP;
	}

	public void setVIP(boolean isVIP) {
		this.isVIP = isVIP;
	}

}
