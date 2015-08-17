package net.dilwit.mockito;

import net.dilwit.mockito.parking.ParkingServiceTest;
import net.dilwit.mockito.student.StudentServiceTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 
 * @author Dilusha Withanage
 *
 */

@RunWith(Suite.class)
@SuiteClasses({
	StudentServiceTest.class,
	ParkingServiceTest.class
})

public class AllTests {

}
