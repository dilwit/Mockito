package net.dilwit.mockito.parking;

import net.dilwit.mockito.database.DatabaseException;

/**
 * 
 * @author Dilusha Withanage
 *
 */
public interface ParkingDao {

	boolean isRegisteredForParking(String id) throws DatabaseException;

}
