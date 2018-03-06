package com.infy.bean;
    
import java.util.Calendar;

public class HouseBoatBooking {
	private Integer bookingId;
	private String boatId;
	private Calendar dateOfRide;
	private Integer noOfPeople;
	private Long contactNo;
	private String bookingStatus;
	private String boatingType ;
	private String location;
	private Double cost;
	private Double totalCost;
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public String getBoatId() {
		return boatId;
	}
	public void setBoatId(String boatId) {
		this.boatId = boatId;
	}
	public Calendar getDateOfRide() {
		return dateOfRide;
	}
	public void setDateOfRide(Calendar dateOfRide) {
		this.dateOfRide = dateOfRide;
	}
	public Integer getNoOfPeople() {
		return noOfPeople;
	}
	public void setNoOfPeople(Integer noOfPeople) {
		this.noOfPeople = noOfPeople;
	}
	public Long getContactNo() {
		return contactNo;
	}
	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public String getBoatingType() {
		return boatingType;
	}
	public void setBoatingType(String boatingType) {
		this.boatingType = boatingType;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

}    
    