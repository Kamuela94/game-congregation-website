package com.infy.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.infy.bean.HouseBoatBooking;

public class HouseBoatDAOImpl implements HouseBoatDAO {

	public Map<String, String> getBoatingTypes() throws Exception {
		Map<String, String> boatingTypeMap = null;
		try {
			boatingTypeMap = new LinkedHashMap<String, String>();

			boatingTypeMap.put("D", "Day Cruise");
			boatingTypeMap.put("N", "Night Stay");
			boatingTypeMap.put("F", "Day & Night");

		} catch (Exception e) {
			Logger logger = LogManager.getLogger(this.getClass());
			logger.error(e.getMessage(), e);
			throw new Exception("DAO.TECHNICAL_ERROR");
		}
		return boatingTypeMap;
	}

	public HouseBoatBooking fetchBoatByTypeAndLocation(
			HouseBoatBooking houseBoatBooking) throws Exception {
		try {

			List<String[]> boatDetails = new ArrayList<String[]>();

			String[] boatDetailRow1 = { "B101", "D", "Allepey", "10000.00" };
			String[] boatDetailRow2 = { "B102", "N", "Allepey", "15000.00" };
			String[] boatDetailRow3 = { "B103", "F", "Allepey", "25000.00" };
			String[] boatDetailRow4 = { "B104", "D", "Kumarakom", "9000.00" };
			String[] boatDetailRow5 = { "B105", "N", "Kumarakom", "12000.00" };
			String[] boatDetailRow6 = { "B106", "F", "Kumarakom", "22000.00" };
			String[] boatDetailRow7 = { "B107", "D", "Tarkarli", "7000.00" };
			String[] boatDetailRow8 = { "B108", "N", "Tarkarli", "11000.00" };
			String[] boatDetailRow9 = { "B109", "F", "Tarkarli", "26000.00" };

			boatDetails.add(boatDetailRow1);
			boatDetails.add(boatDetailRow2);
			boatDetails.add(boatDetailRow3);
			boatDetails.add(boatDetailRow4);
			boatDetails.add(boatDetailRow5);
			boatDetails.add(boatDetailRow6);
			boatDetails.add(boatDetailRow7);
			boatDetails.add(boatDetailRow8);
			boatDetails.add(boatDetailRow9);

			for (String[] boatDetail : boatDetails) {
				if (boatDetail[1].equalsIgnoreCase(houseBoatBooking
						.getBoatingType())
						&& boatDetail[2].equalsIgnoreCase(houseBoatBooking
								.getLocation())) {
					houseBoatBooking.setBoatId(boatDetail[0]);
					houseBoatBooking.setCost(Double.parseDouble(boatDetail[3]));
					break;
				}
			}

			return houseBoatBooking;
		} catch (Exception e) {
			Logger logger = LogManager.getLogger(this.getClass());
			logger.error(e.getMessage(), e);
			throw new Exception("DAO.TECHNICAL_ERROR");
		}
	}

	public List<String> fetchPreviousBooking(HouseBoatBooking houseBoatBooking)
			throws Exception {

		List<String[]> bookingDetails = new ArrayList<String[]>();

		String[] bookingDetailsRow1 = { "1018", "B101", "30-JUL-16", "2",
				"1111111111", "PN", "B101", "D", "Allepey", "10000" };
		String[] bookingDetailsRow2 = { "1015", "B101", "29-JUL-16", "2",
				"1111111111", "PN", "B101", "D", "Allepey", "10000" };
		String[] bookingDetailsRow3 = { "1020", "B101", "31-JUL-16", "2",
				"1111111112", "PN", "B101", "D", "Allepey", "10000" };
		String[] bookingDetailsRow4 = { "1014", "B101", "29-JUL-16", "2",
				"1111111111", "PN", "B101", "D", "Allepey", "10000" };
		String[] bookingDetailsRow5 = { "1021", "B101", "12-AUG-16", "12",
				"1111111112", "PN", "B101", "D", "Allepey", "10000" };
		String[] bookingDetailsRow6 = { "1017", "B101", "30-JUL-16", "2",
				"1111111111", "PN", "B101", "D", "Allepey", "10000" };
		String[] bookingDetailsRow7 = { "1002", "B101", "30-JUL-16", "8",
				"9968456711", "PN", "B101", "D", "Allepey", "10000" };
		String[] bookingDetailsRow8 = { "1001", "B101", "28-JUL-16", "6",
				"8095487654", "PN", "B101", "D", "Allepey", "10000" };
		String[] bookingDetailsRow9 = { "1006", "B103", "01-AUG-16", "12",
				"9543436767", "PN", "B103", "F", "Allepey", "25000" };
		String[] bookingDetailsRow10 = { "1004", "B105", "28-JUL-16", "10",
				"8095112299", "CO", "B105", "N", "Kumarakom", "12000" };
		String[] bookingDetailsRow11 = { "1007", "B105", "20-JUL-16", "4",
				"8769001234", "CO", "B105", "N", "Kumarakom", "12000" };
		String[] bookingDetailsRow12 = { "1005", "B106", "26-JUL-16", "6",
				"9769454513", "CO", "B106", "F", "Kumarakom", "22000" };
		String[] bookingDetailsRow13 = { "1003", "B106", "02-AUG-16", "5",
				"9869228325", "PN", "B106", "F", "Kumarakom", "22000" };
		String[] bookingDetailsRow14 = { "1008", "B106", "31-JUL-16", "4",
				"8963636364", "CO", "B106", "F", "Kumarakom", "22000" };
		String[] bookingDetailsRow15 = { "1009", "B106", "24-JUL-16", "6",
				"9996734521", "CO", "B106", "F", "Kumarakom", "22000" };
		String[] bookingDetailsRow16 = { "1022", "B107", "31-JUL-16", "1",
				"1122334455", "PN", "B107", "D", "Tarkarli", "7000" };
		String[] bookingDetailsRow17 = { "1023", "B108", "30-JUL-16", "1",
				"1122112211", "PN", "B108", "N", "Tarkarli", "11000" };

		bookingDetails.add(bookingDetailsRow1);
		bookingDetails.add(bookingDetailsRow2);
		bookingDetails.add(bookingDetailsRow3);
		bookingDetails.add(bookingDetailsRow4);
		bookingDetails.add(bookingDetailsRow5);
		bookingDetails.add(bookingDetailsRow6);
		bookingDetails.add(bookingDetailsRow7);
		bookingDetails.add(bookingDetailsRow8);
		bookingDetails.add(bookingDetailsRow9);
		bookingDetails.add(bookingDetailsRow10);
		bookingDetails.add(bookingDetailsRow11);
		bookingDetails.add(bookingDetailsRow12);
		bookingDetails.add(bookingDetailsRow13);
		bookingDetails.add(bookingDetailsRow14);
		bookingDetails.add(bookingDetailsRow15);
		bookingDetails.add(bookingDetailsRow16);
		bookingDetails.add(bookingDetailsRow17);

		List<String> listOfBoatsBooked = new ArrayList<String>();

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
			String dateOfRide = sdf.format(houseBoatBooking.getDateOfRide()
					.getTime());
			for (String[] bookingDetail : bookingDetails) {
				if (bookingDetail[7].equalsIgnoreCase(houseBoatBooking
						.getBoatingType())
						&& bookingDetail[8].equalsIgnoreCase(houseBoatBooking
								.getLocation())
						&& bookingDetail[2].equalsIgnoreCase(dateOfRide)) {
					listOfBoatsBooked.add(bookingDetail[1]);
					break;
				}
			}
		} catch (Exception e) {
			Logger logger = LogManager.getLogger(this.getClass());
			logger.error(e.getMessage(), e);
			throw new Exception("DAO.TECHNICAL_ERROR");
		}
		
		if(listOfBoatsBooked.isEmpty())
			return null;
		
		return listOfBoatsBooked;
	}

	public HouseBoatBooking bookHouseBoat(HouseBoatBooking houseBoatBooking)
			throws Exception {
		
		List<String[]> bookingDetails = new ArrayList<String[]>();

		String[] bookingDetailsRow1 = { "1018", "B101", "30-JUL-16", "2",
				"1111111111", "PN", "B101", "D", "Allepey", "10000" };
		String[] bookingDetailsRow2 = { "1015", "B101", "29-JUL-16", "2",
				"1111111111", "PN", "B101", "D", "Allepey", "10000" };
		String[] bookingDetailsRow3 = { "1020", "B101", "31-JUL-16", "2",
				"1111111112", "PN", "B101", "D", "Allepey", "10000" };
		String[] bookingDetailsRow4 = { "1014", "B101", "29-JUL-16", "2",
				"1111111111", "PN", "B101", "D", "Allepey", "10000" };
		String[] bookingDetailsRow5 = { "1021", "B101", "12-AUG-16", "12",
				"1111111112", "PN", "B101", "D", "Allepey", "10000" };
		String[] bookingDetailsRow6 = { "1017", "B101", "30-JUL-16", "2",
				"1111111111", "PN", "B101", "D", "Allepey", "10000" };
		String[] bookingDetailsRow7 = { "1002", "B101", "30-JUL-16", "8",
				"9968456711", "PN", "B101", "D", "Allepey", "10000" };
		String[] bookingDetailsRow8 = { "1001", "B101", "28-JUL-16", "6",
				"8095487654", "PN", "B101", "D", "Allepey", "10000" };
		String[] bookingDetailsRow9 = { "1006", "B103", "01-AUG-16", "12",
				"9543436767", "PN", "B103", "F", "Allepey", "25000" };
		String[] bookingDetailsRow10 = { "1004", "B105", "28-JUL-16", "10",
				"8095112299", "CO", "B105", "N", "Kumarakom", "12000" };
		String[] bookingDetailsRow11 = { "1007", "B105", "20-JUL-16", "4",
				"8769001234", "CO", "B105", "N", "Kumarakom", "12000" };
		String[] bookingDetailsRow12 = { "1005", "B106", "26-JUL-16", "6",
				"9769454513", "CO", "B106", "F", "Kumarakom", "22000" };
		String[] bookingDetailsRow13 = { "1003", "B106", "02-AUG-16", "5",
				"9869228325", "PN", "B106", "F", "Kumarakom", "22000" };
		String[] bookingDetailsRow14 = { "1008", "B106", "31-JUL-16", "4",
				"8963636364", "CO", "B106", "F", "Kumarakom", "22000" };
		String[] bookingDetailsRow15 = { "1009", "B106", "24-JUL-16", "6",
				"9996734521", "CO", "B106", "F", "Kumarakom", "22000" };
		String[] bookingDetailsRow16 = { "1022", "B107", "31-JUL-16", "1",
				"1122334455", "PN", "B107", "D", "Tarkarli", "7000" };
		String[] bookingDetailsRow17 = { "1023", "B108", "30-JUL-16", "1",
				"1122112211", "PN", "B108", "N", "Tarkarli", "11000" };

		bookingDetails.add(bookingDetailsRow1);
		bookingDetails.add(bookingDetailsRow2);
		bookingDetails.add(bookingDetailsRow3);
		bookingDetails.add(bookingDetailsRow4);
		bookingDetails.add(bookingDetailsRow5);
		bookingDetails.add(bookingDetailsRow6);
		bookingDetails.add(bookingDetailsRow7);
		bookingDetails.add(bookingDetailsRow8);
		bookingDetails.add(bookingDetailsRow9);
		bookingDetails.add(bookingDetailsRow10);
		bookingDetails.add(bookingDetailsRow11);
		bookingDetails.add(bookingDetailsRow12);
		bookingDetails.add(bookingDetailsRow13);
		bookingDetails.add(bookingDetailsRow14);
		bookingDetails.add(bookingDetailsRow15);
		bookingDetails.add(bookingDetailsRow16);
		bookingDetails.add(bookingDetailsRow17);

		try {
			
			boolean bookingAlreadyDone = false;
			
			for (String[] bookingDetail : bookingDetails) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
				String dateOfRide = sdf.format(houseBoatBooking.getDateOfRide()
						.getTime());
				if (bookingDetail[1].equalsIgnoreCase(houseBoatBooking.getBoatId()) && bookingDetail[2].equalsIgnoreCase(dateOfRide)) {
					bookingAlreadyDone = true;
					break;
				}
			}
			
			Integer bookingId = null;
			
			if(!bookingAlreadyDone){
				bookingId = Integer.parseInt(bookingDetails.get(bookingDetails.size()-1)[0]) + 1;
			}else{
				
			}

			houseBoatBooking.setBookingId(bookingId);
			return houseBoatBooking;

		} catch (Exception e) {
			Logger logger = LogManager.getLogger(this.getClass());
			logger.error(e.getMessage(), e);
			throw new Exception("DAO.TECHNICAL_ERROR");

		}
	}
}
