package com.infy.service;

import java.util.Map;

import com.infy.bean.HouseBoatBooking;

public interface HouseBoatService {
	
	public Map<String,String> getBoatingTypes() throws Exception;
	public HouseBoatBooking bookHouseBoat(HouseBoatBooking houseBoatBooking) throws Exception;
}
