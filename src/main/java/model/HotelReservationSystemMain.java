package model;


import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import serivce.Hotel;

public class HotelReservationSystemMain {

	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
	static ArrayList<Hotel> hotel_list = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	/*
	 * UC1
	 */
	public static boolean addHotels() {
		Hotel Hotel1 = new Hotel("Bridgewood", 150, 50, 4);
		Hotel Hotel2 = new Hotel("Lakewood", 110, 90, 3);
		Hotel Hotel3 = new Hotel("Ridgewood", 220, 150, 5);
		hotel_list.add(Hotel1);
		hotel_list.add(Hotel2);
		hotel_list.add(Hotel3);
		hotel_list.forEach(System.out::println);
		return true;
	}
}