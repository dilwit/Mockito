package net.dilwit.mockito.student;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import net.dilwit.mockito.database.DatabaseException;
import net.dilwit.mockito.parking.ParkingService;
import net.dilwit.mockito.parking.ParkingServiceException;
import net.dilwit.mockito.payment.PaymentDetails;
import net.dilwit.mockito.payment.PaymentService;
import net.dilwit.mockito.payment.PaymentServiceException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * 
 * @author Dilusha Withanage
 *
 */
public class StudentServiceTest {
	
	@Mock
	private ParkingService parkingService;
	@Mock
	private PaymentService paymentService;
	@Mock
	private StudentDao studentDao;
	
	@Captor
	private ArgumentCaptor<Student> studentCaptor;
	
	
	@InjectMocks
	private StudentService studentService;
	
	
	private Student student;
	private String receiptNumber;
	private PaymentDetails paymentDetails;
	
	@Before
	public void setUp() {
		
		student = new Student();
		student.setId("STU123456");
		
		paymentDetails = new PaymentDetails();
		receiptNumber = "RC123456";
		
		studentService = new StudentServiceImpl();	
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test (expected = StudentServiceException.class)
	public void itShouldnotBeAbleToPurchasePassIfNotRegisteredForParking() throws StudentServiceException, ParkingServiceException, PaymentServiceException {		
		
		when(parkingService.isRegisteredForParking(student.getId())).thenThrow(ParkingServiceException.class);
		
		String receiptId = studentService.purchaseMonthlyParkingPass(student, paymentDetails);		
		verify(parkingService).isRegisteredForParking(student.getId());
		verify(paymentService, never()).purchaseParkingPass(paymentDetails);
		
		Assert.assertNull(receiptId);
	}
	
	@Test
	public void itShouldableToPurchasePassIfRegisteredForParking() throws StudentServiceException, ParkingServiceException, PaymentServiceException {
		
		when(parkingService.isRegisteredForParking(student.getId())).thenReturn(true);
		when(paymentService.purchaseParkingPass(paymentDetails)).thenReturn(receiptNumber);
		
		String receiptId = studentService.purchaseMonthlyParkingPass(student, paymentDetails);
		verify(parkingService).isRegisteredForParking(student.getId());
		verify(paymentService).purchaseParkingPass(paymentDetails);
		
		Assert.assertEquals(receiptNumber, receiptId);
	}
	
	@Test (expected = StudentServiceException.class)
	public void itShouldNotBeAbleToUpdateStudentWithParkingReceipt() throws DatabaseException, StudentServiceException {		
		
		doThrow(DatabaseException.class).when(studentDao).updateStudent(student);
		
		studentService.updateParkingReceipt(student, receiptNumber);
		verify(studentDao).updateStudent(student);
		
		verify(studentDao).updateStudent(studentCaptor.capture());
		Student studentToUpdate = studentCaptor.getValue();
		Assert.assertEquals(receiptNumber, studentToUpdate.getParkingReceipt());
	}
	
	@Test
	public void itShouldBeAbleToUpdateStudentWithParkingReceipt() throws StudentServiceException, DatabaseException {
		
		studentService.updateParkingReceipt(student, receiptNumber);
		verify(studentDao).updateStudent(student);
		
		verify(studentDao).updateStudent(studentCaptor.capture());
		Student studentToUpdate = studentCaptor.getValue();
		Assert.assertEquals(receiptNumber, studentToUpdate.getParkingReceipt());
	}

}
