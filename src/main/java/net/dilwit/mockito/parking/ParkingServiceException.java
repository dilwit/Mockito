package net.dilwit.mockito.parking;

import net.dilwit.mockito.database.DatabaseException;

/**
 * 
 * @author Dilusha Withanage
 *
 */
public class ParkingServiceException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = -4501811478921841939L;
	
	public ParkingServiceException(DatabaseException e) {
		super(e);
	}

}
