package net.dilwit.mockito.payment;

/**
 * 
 * @author Dilusha Withanage
 *
 */
public interface PaymentService {

	String purchaseParkingPass(PaymentDetails paymentDetails) throws PaymentServiceException;

}
