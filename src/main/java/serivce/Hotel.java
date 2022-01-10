package serivce;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Hotel {
	
	private String name;
	private Integer rates;
	private long rewardWeekDayRate, rewardWeekEndRates;
	private long regularWeekDayRate, regularWeekEndRate;
	private CustomerType typeOfCustomer;
	private long totalRate;
	private int weekendRate;
	private int weekdayRate;
	private int rating;
	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

	public Hotel() {
		super();
	}

	public Hotel(String name, int weekendRate, int weekdayRate, int rating) {
		super();
		this.name = name;
		this.weekendRate = weekendRate;
		this.weekdayRate = weekdayRate;
		this.rating = rating;
	}

	public Hotel(String name, long rewardWeekDayRate, long rewardWeekEndRates, long regularWeekDayRate,
			long regularWeekEndRate, int rating) {
		super();
		this.name = name;
		this.rewardWeekDayRate = rewardWeekDayRate;
		this.rewardWeekEndRates = rewardWeekEndRates;
		this.regularWeekDayRate = regularWeekDayRate;
		this.regularWeekEndRate = regularWeekEndRate;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRates() {
		return rates;
	}

	public void setRates(Integer rates) {
		this.rates = rates;
	}

	public long getTotalRate() {
		return totalRate;
	}

	public void setTotalRate(long l) {
		this.totalRate = l;
	}

	public int getWeekendRate() {
		return weekendRate;
	}

	public void setWeekendRate(int weekendRate) {
		this.weekendRate = weekendRate;
	}

	public int getWeekdayRate() {
		return weekdayRate;
	}

	public void setWeekdayRate(int weekdayRate) {
		this.weekdayRate = weekdayRate;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public CustomerType getTypeOfCustomer() {
		return typeOfCustomer;
	}

	public void setTypeOfCustomer(CustomerType typeOfCustomer) {
		this.typeOfCustomer = typeOfCustomer;
	}

	public long getRewardWeekDayRate() {
		return rewardWeekDayRate;
	}

	public void setRewardWeekDayRate(long rewardWeekDayRate) {
		this.rewardWeekDayRate = rewardWeekDayRate;
	}

	public long getRewardWeekEndRates() {
		return rewardWeekEndRates;
	}

	public void setRewardWeekEndRates(long rewardWeekEndRates) {
		this.rewardWeekEndRates = rewardWeekEndRates;
	}

	public long getRegularWeekDayRate() {
		return regularWeekDayRate;
	}

	public void setRegularWeekDayRate(long regularWeekDayRate) {
		this.regularWeekDayRate = regularWeekDayRate;
	}

	public long getRegularWeekEndRate() {
		return regularWeekEndRate;
	}

	public void setRegularWeekEndRate(long regularWeekEndRate) {
		this.regularWeekEndRate = regularWeekEndRate;
	}

	@Override
	public String toString() {
		return "Hotel [name=" + name + ", typeOfCustomer=" + typeOfCustomer + ", totalRate=" + totalRate + ", rating="
				+ rating + ", rewardWeekDayRate=" + rewardWeekDayRate + ", rewardWeekEndRates=" + rewardWeekEndRates
				+ ", regularWeekDayRate=" + regularWeekDayRate + ", regularWeekEndRate=" + regularWeekEndRate + "]";
	}

	/*
	 * This function Takes input three parameters as (customer type and date range).
	 * Using ChronoUnit finding the gap between the data range. // (eg:- 2 day)
	 * checking for customer type and calculating Total rate (totalRate = rate * days) // (eg:- Tr = 250*2 )
	 * .
	 * Return an Total rate. // (eg:- r:- 500)
	 */
	public long checkCustomerTypeAndRetrunTotalRateForDataRange(CustomerType customerType, String stateDate,String endDate) {
		final LocalDate stateDateLD = LocalDate.parse(stateDate, DATE_FORMAT);
		final LocalDate endDateLD = LocalDate.parse(endDate, DATE_FORMAT);
		
		final long daysBetween = (int) ChronoUnit.DAYS.between(stateDateLD, endDateLD);
		
		if (customerType.equals(CustomerType.REWARD)) {
			if (stateDateLD.getDayOfWeek().equals(DayOfWeek.SATURDAY)|| endDateLD.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
				setTotalRate(getRewardWeekEndRates() + getRewardWeekDayRate()* daysBetween);
			} else {
				setTotalRate(getRewardWeekDayRate() + getRewardWeekEndRates()* daysBetween);
			}
		} else if (customerType.equals(CustomerType.REGULAR)) {
			if (stateDateLD.getDayOfWeek().equals(DayOfWeek.SATURDAY)
					|| endDateLD.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
				setTotalRate(getRegularWeekEndRate() + getRegularWeekDayRate()* daysBetween);
			} else {
				setTotalRate(getRegularWeekDayRate()+ getRegularWeekEndRate() * daysBetween);
			}
		}

		return getTotalRate();
	}

}
