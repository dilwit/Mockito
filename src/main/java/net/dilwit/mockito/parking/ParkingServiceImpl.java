package net.dilwit.mockito.parking;

import net.dilwit.mockito.database.DatabaseException;

/**
 * 
 * @author Dilusha Withanage
 *
 */
public class ParkingServiceImpl implements ParkingService {
	
	private ParkingDao parkingDao;

	@Override
	public boolean isRegisteredForParking(String id) throws ParkingServiceException {
		
		try {
			return parkingDao.isRegisteredForParking(id);
		} catch (DatabaseException e) {
			throw new ParkingServiceException(e);
		}
	}

	public ParkingDao getParkingDao() {
		return parkingDao;
	}

	public void setParkingDao(ParkingDao parkingDao) {
		this.parkingDao = parkingDao;
	}	

}
