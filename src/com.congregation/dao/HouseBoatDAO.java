package com.infy.dao;

import java.util.List;
import java.util.Map;

import com.infy.bean.HouseBoatBooking;

public interface HouseBoatDAO {

	public Map<String,String> getBoatingTypes() throws Exception;
	public HouseBoatBooking bookHouseBoat(HouseBoatBooking houseBoatBooking) throws Exception;
	public List<String> fetchPreviousBooking(HouseBoatBooking houseBoatBooking) throws Exception;
	public HouseBoatBooking fetchBoatByTypeAndLocation(HouseBoatBooking houseBoatBooking) throws Exception;

}