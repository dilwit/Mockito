package net.dilwit.mockito.parking;

/**
 * 
 * @author Dilusha Withanage
 *
 */
public interface ParkingService {

	boolean isRegisteredForParking(String id) throws ParkingServiceException;

}
