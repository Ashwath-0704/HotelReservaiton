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

	public static boolean addHotels() {
		Hotel Hotel1 = new Hotel("Lakewood", 80, 80, 110, 90, 3);
		Hotel Hotel2 = new Hotel("Bridgewood", 110, 50, 150, 50, 4);
		Hotel Hotel3 = new Hotel("Ridgewood", 100, 40, 220, 150, 5);
		hotel_list.add(Hotel1);
		hotel_list.add(Hotel2);
		hotel_list.add(Hotel3);
		return true;
	}
}