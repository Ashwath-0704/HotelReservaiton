package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import serivce.Hotel;


public class HotelReservationSystemMain {

	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
	static ArrayList<Hotel> hotel_list = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	/*
	 * UC1 and UC3
	 */
	public static boolean addHotels() {
		Hotel Hotel1 = new Hotel("Bridgewood", 150, 50, 4);
		Hotel Hotel2 = new Hotel("Lakewood", 110, 90, 3);
		Hotel Hotel3 = new Hotel("Ridgewood", 220, 150, 5);
		hotel_list.add(Hotel1);
		hotel_list.add(Hotel2);
		hotel_list.add(Hotel3);
//		hotel_list.forEach(System.out::println);
		return true;
	}

	/*
	 * UC2 and UC4
	 */
	public static boolean findTheCheaptestHotelAndTotalCost(String stateDate, String endDate) {
		LocalDate stateDateLD = LocalDate.parse(stateDate, DATE_FORMAT);
		LocalDate endDateLD = LocalDate.parse(endDate, DATE_FORMAT);
		int daysBetween = (int) ChronoUnit.DAYS.between(stateDateLD, endDateLD);
		List<Object> storedCheapRateHotel1 = hotel_list.stream().map(hotelData -> {
			Hotel result = new Hotel();
			result.setName(hotelData.getName());
			result.setTotalRate(hotelData.getWeekendRate() + hotelData.getWeekdayRate() * daysBetween);
			result.setTypeOfCustomer(hotelData.getTypeOfCustomer());
			result.setWeekdayRate(hotelData.getWeekdayRate());
			result.setWeekendRate(hotelData.getWeekendRate());
			result.setRating(hotelData.getRating());
			return result;
		}).sorted(Comparator.comparing(Hotel::getTotalRate)).collect(Collectors.toList());
		System.out.printf("The total number of the days is : %d\n", daysBetween);
		storedCheapRateHotel1.forEach(System.out::println);
		return true;
	}

}