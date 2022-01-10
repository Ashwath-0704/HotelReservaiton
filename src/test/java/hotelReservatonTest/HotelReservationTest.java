package hotelReservatonTest;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import model.HotelReservationSystemMain;
import serivce.CustomerType;
import serivce.Hotel;
import serivce.HotelReservationException;

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

	@Test
	public void findTheCheaptestBestRatingHotelest() {
		HotelReservationSystemMain.addHotels();
		List<Hotel> cheapHotelRating;cheapHotelRating = HotelReservationSystemMain.findBestRatingHotel(CustomerType.REGULAR, "10-Sep-2022","11-Sep-2022");
		Assert.assertEquals(370, cheapHotelRating.get(0).getTotalRate());

//		Output:-
//		The best rated hotel for REGULAR customer is : 
//			Hotel [name=Ridgewood, typeOfCustomer=REGULAR, totalRate=370, rating=5, rewardWeekDayRate=100, rewardWeekEndRates=40, regularWeekDayRate=220, regularWeekEndRate=150]
	}

	@Test
	public void findTheCheapestHotelAndTotalCostREGULARTest() {
		HotelReservationSystemMain.addHotels();
		List<Hotel> cheapHotel = HotelReservationSystemMain.findTheCheapestHotelAndTotalCost(CustomerType.REGULAR,"10-Sep-2022", "11-Sep-2022");
		Assert.assertEquals(200, cheapHotel.get(0).getTotalRate(), cheapHotel.get(1).getTotalRate());
//		Output:-
//				The total number of the days is : 1
//				Hotel [name=Lakewood, typeOfCustomer=REGULAR, totalRate=200, rating=3, rewardWeekDayRate=80, rewardWeekEndRates=80, regularWeekDayRate=110, regularWeekEndRate=90]
//				Hotel [name=Bridgewood, typeOfCustomer=REGULAR, totalRate=200, rating=4, rewardWeekDayRate=110, rewardWeekEndRates=50, regularWeekDayRate=150, regularWeekEndRate=50]

	}

	@Test
	public void findTheCheapestHotelAndTotalCostREWARDTest() {
		HotelReservationSystemMain.addHotels();
		List<Hotel> cheapHotel = HotelReservationSystemMain.findTheCheapestHotelAndTotalCost(CustomerType.REWARD,"10-Sep-2022", "11-Sep-2022");
		Assert.assertEquals(140, cheapHotel.get(0).getTotalRate());
//		Output:-
//				The total number of the days is : 1
//				Hotel [name=Ridgewood, typeOfCustomer=REWARD, totalRate=140, rating=5, rewardWeekDayRate=100, rewardWeekEndRates=40, regularWeekDayRate=220, regularWeekEndRate=150]

	}

	@Test
	public void findTheCheaptestBestRatingHotelREWARDTest() {
		try {
			HotelReservationSystemMain.addHotels();
			List<Hotel> cheapHotelRating = HotelReservationSystemMain.findTheCheapestBestRatingHotel(CustomerType.REWARD, "10-Sep-2022", "11-Sep-2022");
			Assert.assertEquals(5, cheapHotelRating.get(0).getRating());
		} catch (HotelReservationException e) {
			System.err.println("Invalid user input");
		}

//		Output:-
//			Hotel [name=Ridgewood, typeOfCustomer=REWARD, totalRate=140, rating=5, rewardWeekDayRate=100, rewardWeekEndRates=40, regularWeekDayRate=220, regularWeekEndRate=150]	}
	}

	@Test // UC12
	public void findTheCheaptestBestRatingHotelREGULARTest() {

		try {
			HotelReservationSystemMain.addHotels();
			List<Hotel> cheapHotelRating = HotelReservationSystemMain.findTheCheapestBestRatingHotel(CustomerType.REGULAR, "10-Sep-2022", "11-Sep-2022");
			Assert.assertEquals(4, cheapHotelRating.get(0).getRating());
		} catch (HotelReservationException e) {
			System.err.println("Invalid user input");
		}

//Output:-
//		Hotel [name=Bridgewood, typeOfCustomer=REGULAR, totalRate=200, rating=4, rewardWeekDayRate=110, rewardWeekEndRates=50, regularWeekDayRate=150, regularWeekEndRate=50]	}
	}

	@Test
	public void findTheCheaptestBestRatingHotelExceptionTest() {
		try {
			HotelReservationSystemMain.addHotels();
			List<Hotel> cheapHotelRating = HotelReservationSystemMain.findTheCheapestBestRatingHotel(null,"10-Sep-2022", "11-Sep-2022");
			Assert.assertEquals(4, cheapHotelRating.get(0).getRating());
		} catch (HotelReservationException e) {
			System.err.println(e);
		}
	}
//		Output:-
//				Invalid user input	
}
