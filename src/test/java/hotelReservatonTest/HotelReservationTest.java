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
//				Hotel [name=Bridgewood, totalRate=0, weekendRate=150, weekdayRate=50, rating=4]
//				Hotel [name=Lakewood, totalRate=0, weekendRate=110, weekdayRate=90, rating=3]
//				Hotel [name=Ridgewood, totalRate=0, weekendRate=220, weekdayRate=150, rating=5]
	}

	@Test
	public void findTheCheaptestHotelAndTotalCostTest() {
		HotelReservationSystemMain.addHotels();
		boolean cheapHotel = HotelReservationSystemMain.findTheCheaptestHotelAndTotalCost("11-Sep-2020", "12-Sep-2020");
		Assert.assertEquals(true, cheapHotel);
//		Output:-
//				Hotel [name=Bridgewood, totalRate=200, weekendRate=150, weekdayRate=50, rating=4]
//				Hotel [name=Lakewood, totalRate=200, weekendRate=110, weekdayRate=90, rating=3]

	}

	@Test
	public void findTheCheaptestBestRatingHotelTest() {
		HotelReservationSystemMain.addHotels();
		boolean cheapHotelRating = HotelReservationSystemMain.findTheCheaptestBestRatingHotel("11-Sep-2020",
				"12-Sep-2020");
		Assert.assertEquals(true, cheapHotelRating);
//		Output:-
//				Hotel [name=Lakewood, totalRate=200, weekendRate=110, weekdayRate=90, rating=3]
	}

	@Test
	public void findTheBestRatingHotelTest() {
		HotelReservationSystemMain.addHotels();
		boolean bestRatingHotel = HotelReservationSystemMain.findTheBestRatingHotel("11-Sep-2020", "12-Sep-2020");
		Assert.assertEquals(true, bestRatingHotel);

//		O/P:- Hotel [name=Ridgewood, totalRate=370, weekendRate=220, weekdayRate=150, rating=5]
	}
}