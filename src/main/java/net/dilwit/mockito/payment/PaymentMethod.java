package net.dilwit.mockito.payment;

/**
 * 
 * @author Dilusha Withanage
 *
 */
public enum PaymentMethod {

	CC("Credit Card"),
	PP("PayPal");
	
	private String display;
	
	private PaymentMethod(String display) {
		this.display = display;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}
	
}
