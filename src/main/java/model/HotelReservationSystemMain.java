package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import serivce.CustomerType;
import serivce.Hotel;
import serivce.HotelReservationException;

public class HotelReservationSystemMain {

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

	public static List<Hotel> findTheCheapestHotelAndTotalCost(CustomerType customerType, String stateDate,String endDate) {
		List<Hotel> storedCheapRateHotel = hotel_list.stream().map(hotelData -> {
			Hotel result = new Hotel();
			result.setName(hotelData.getName());
			result.setTotalRate(
					hotelData.checkCustomerTypeAndRetrunTotalRateForDataRange(customerType, stateDate, endDate));
			result.setTypeOfCustomer(customerType);
			result.setRating(hotelData.getRating());
			result.setRegularWeekDayRate(hotelData.getRegularWeekDayRate());
			result.setRegularWeekEndRate(hotelData.getRegularWeekEndRate());
			result.setRewardWeekDayRate(hotelData.getRewardWeekDayRate());
			result.setRewardWeekEndRates(hotelData.getRewardWeekEndRates());
			return result;
		}).sorted(Comparator.comparing(Hotel::getTotalRate)).collect(Collectors.toList());

		return storedCheapRateHotel.stream().filter(results -> results.getTotalRate() == storedCheapRateHotel.get(0).getTotalRate()).collect(Collectors.toList());
	}

	public static List<Hotel> findTheCheapestBestRatingHotel(CustomerType customerType, String stateDate,
			String endDate) throws HotelReservationException {
		if (customerType != null) {
			List<Hotel> storedCheapRateHotel = hotel_list.stream().map(hotelData -> {
				Hotel result = new Hotel();
				result.setName(hotelData.getName());
				result.setTotalRate(
						hotelData.checkCustomerTypeAndRetrunTotalRateForDataRange(customerType, stateDate, endDate));
				result.setTypeOfCustomer(customerType);
				result.setRating(hotelData.getRating());
				result.setRegularWeekDayRate(hotelData.getRegularWeekDayRate());
				result.setRegularWeekEndRate(hotelData.getRegularWeekEndRate());
				result.setRewardWeekDayRate(hotelData.getRewardWeekDayRate());
				result.setRewardWeekEndRates(hotelData.getRewardWeekEndRates());
				return result;
			}).sorted(Comparator.comparing(Hotel::getTotalRate).thenComparing(Hotel::getRating,Comparator.reverseOrder())).collect(Collectors.toList());

			return storedCheapRateHotel.stream().filter(results -> results.getTotalRate() == storedCheapRateHotel.get(0).getTotalRate() && results.getRating() == storedCheapRateHotel.get(0).getRating()).collect(Collectors.toList());
		}
		throw new HotelReservationException("Invaid input");

	}

	public static List<Hotel> findBestRatingHotel(CustomerType customerType, String stateDate, String endDate) {

		List<Hotel> storedCheapRateHotel = hotel_list.stream().map(hotelData -> {
			Hotel result = new Hotel();
			result.setName(hotelData.getName());
			result.setTotalRate(hotelData.checkCustomerTypeAndRetrunTotalRateForDataRange(customerType, stateDate, endDate));
			result.setTypeOfCustomer(customerType);
			result.setRating(hotelData.getRating());
			result.setRegularWeekDayRate(hotelData.getRegularWeekDayRate());
			result.setRegularWeekEndRate(hotelData.getRegularWeekEndRate());
			result.setRewardWeekDayRate(hotelData.getRewardWeekDayRate());
			result.setRewardWeekEndRates(hotelData.getRewardWeekEndRates());
			System.out.println(result);
			return result;
		}).sorted(Comparator.comparing(Hotel::getRating).reversed()).collect(Collectors.toList());

		return storedCheapRateHotel.stream().filter(results -> results.getTotalRate() == storedCheapRateHotel.get(0).getTotalRate()).collect(Collectors.toList());

	}
}
