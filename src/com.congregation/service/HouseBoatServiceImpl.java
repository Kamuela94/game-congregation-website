package com.infy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.infy.bean.HouseBoatBooking;
import com.infy.dao.HouseBoatDAO;
import com.infy.resources.Factory;

public class HouseBoatServiceImpl implements HouseBoatService {

	public Map<String, String> getBoatingTypes() throws Exception {
		Map<String, String> boatingTypeMap = new HashMap<String, String>();
		try {
			HouseBoatDAO houseBoatDAO = Factory.createHouseBoatDAO();
			boatingTypeMap = houseBoatDAO.getBoatingTypes();
		} catch (Exception exception) {
			if (!exception.getMessage().contains("DAO")) {
				Logger logger = LogManager.getLogger(this.getClass());
				logger.error(exception.getMessage(), exception);
			}
			throw exception;
		}
		return boatingTypeMap;
	}

	public HouseBoatBooking bookHouseBoat(HouseBoatBooking houseBoatBooking)
			throws Exception {
		HouseBoatBooking bookedhouseBoatDetails = null;
		try {
			HouseBoatDAO houseBoatDAO = Factory.createHouseBoatDAO();

			List<String> boatIdsOfBookedHouseBoats = houseBoatDAO
					.fetchPreviousBooking(houseBoatBooking);
			if (boatIdsOfBookedHouseBoats == null
					|| boatIdsOfBookedHouseBoats.isEmpty()) {
				houseBoatBooking = houseBoatDAO
						.fetchBoatByTypeAndLocation(houseBoatBooking);
				bookedhouseBoatDetails = houseBoatDAO
						.bookHouseBoat(houseBoatBooking);

				Double totalCost = (houseBoatBooking.getNoOfPeople() * houseBoatBooking
						.getCost());
				bookedhouseBoatDetails.setTotalCost(totalCost);
			} else {
				throw new Exception(
						"HOUSEBOATSERVICE.BOAT_NOT_AVAILABLE_FOR_THIS_DATE");
			}
		} catch (Exception exception) {
			if (!exception.getMessage().contains("DAO")) {
				Logger logger = LogManager.getLogger(this.getClass());
				logger.error(exception.getMessage(), exception);
			}
			throw exception;
		}
		return bookedhouseBoatDetails;
	}
}