package net.dilwit.mockito.student;

import net.dilwit.mockito.database.DatabaseException;
import net.dilwit.mockito.parking.ParkingService;
import net.dilwit.mockito.parking.ParkingServiceException;
import net.dilwit.mockito.payment.PaymentDetails;
import net.dilwit.mockito.payment.PaymentService;
import net.dilwit.mockito.payment.PaymentServiceException;

/**
 * 
 * @author Dilusha Withanage
 *
 */
public class StudentServiceImpl implements StudentService {
	
	private StudentDao studentDao;
	
	private ParkingService parkingService;
	private PaymentService paymentService;
	
	@Override
	public String purchaseMonthlyParkingPass(Student student, PaymentDetails paymentDetails) throws StudentServiceException {
		
		try {
			if(parkingService.isRegisteredForParking(student.getId())) {
				 return paymentService.purchaseParkingPass(paymentDetails);
			}
		} catch (ParkingServiceException | PaymentServiceException e) {
			throw new StudentServiceException(e);
		}	
		
		return null;
	}
	
	@Override
	public void updateParkingReceipt(Student student, String receiptId) throws StudentServiceException {
		try {
			student.setParkingReceipt(receiptId);
			studentDao.updateStudent(student);
		} catch (DatabaseException e) {
			throw new StudentServiceException(e);
		}
	}	
	
	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public ParkingService getParkingService() {
		return parkingService;
	}

	public void setParkingService(ParkingService parkingService) {
		this.parkingService = parkingService;
	}

	public PaymentService getPaymentService() {
		return paymentService;
	}

	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

}
