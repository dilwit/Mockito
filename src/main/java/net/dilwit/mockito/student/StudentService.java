package net.dilwit.mockito.student;

import net.dilwit.mockito.payment.PaymentDetails;

/**
 * 
 * @author Dilusha Withanage
 *
 */
public interface StudentService {

	String purchaseMonthlyParkingPass(Student student, PaymentDetails paymentDetails) throws StudentServiceException;

	void updateParkingReceipt(Student student, String receiptId) throws StudentServiceException;

}
