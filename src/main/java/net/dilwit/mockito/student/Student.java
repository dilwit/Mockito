package net.dilwit.mockito.student;

import net.dilwit.mockito.payment.PaymentDetails;


/**
 * 
 * @author Dilusha Withanage
 *
 */
public class Student {

	private String id;
	private String parkingReceipt;
	private StudentService studentService;
	
	/*
	 *  Narrative:  
		 * 	In order to drive to university  
		 *  As a registered student for parking 
		 * 	I want to purchase monthly parking pass via CC or PP
	 */
	public void purchaseMonthlyParkingPass(PaymentDetails paymentDetails) throws StudentServiceException {
		String receiptId = studentService.purchaseMonthlyParkingPass(this, paymentDetails);
		studentService.updateParkingReceipt(this, receiptId);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
	
	public String getParkingReceipt() {
		return parkingReceipt;
	}

	public void setParkingReceipt(String parkingReceipt) {
		this.parkingReceipt = parkingReceipt;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
}
