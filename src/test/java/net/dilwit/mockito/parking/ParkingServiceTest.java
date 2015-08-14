package net.dilwit.mockito.parking;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import net.dilwit.mockito.database.DatabaseException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * 
 * @author Dilusha Withanage
 *
 */
public class ParkingServiceTest {
	
	@Mock
	private ParkingDao parkingDao;
	
	@InjectMocks
	private ParkingService parkingService;
	
	private String id;
	
	@Before
	public void setUp() {
		
		id = "ID123456";
		parkingService = new ParkingServiceImpl();
		
		MockitoAnnotations.initMocks(this);
	}
	
	@Test (expected = ParkingServiceException.class)
	public void itShouldNotBeFoundInRegister() throws DatabaseException, ParkingServiceException {
		
		when(parkingDao.isRegisteredForParking(id)).thenThrow(DatabaseException.class);

		boolean isRegistered = parkingService.isRegisteredForParking(id);
		verify(parkingDao).isRegisteredForParking(id);
		Assert.assertFalse(isRegistered);
	}
	
	@Test
	public void itShouldBeFoundInRegister() throws DatabaseException, ParkingServiceException {

		when(parkingDao.isRegisteredForParking(id)).thenReturn(true);
		
		boolean isRegistered = parkingService.isRegisteredForParking(id);
		verify(parkingDao).isRegisteredForParking(id);
		Assert.assertTrue(isRegistered);
		
	}

}
