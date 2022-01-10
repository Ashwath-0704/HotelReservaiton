package hotelReservatonTest;

import org.junit.Assert;
import org.junit.Test;

import model.HotelReservationSystemMain;

public class HotelReservationTest {

	@Test
	public void addHotelTest() {
		boolean addHotelTest = HotelReservationSystemMain.addHotels();
		Assert.assertEquals(true, addHotelTest);
//		Output:-
//				Hotel [name=Bridgewood, weekendRate=150, weekdayRate=50, rating=4]
//				Hotel [name=Lakewood, weekendRate=110, weekdayRate=90, rating=3]
//				Hotel [name=Ridgewood, weekendRate=220, weekdayRate=150, rating=5]

	}
}