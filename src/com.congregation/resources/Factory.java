package com.infy.resources;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.infy.dao.HouseBoatDAOImpl;
import com.infy.service.HouseBoatServiceImpl;



public class Factory {

	public static HouseBoatServiceImpl createHouseBoatService() {
		Logger logger = LogManager.getLogger(Factory.class);
		logger.info("FactoryService: Inside HouseBoatServiceImpl Method");
		return new HouseBoatServiceImpl();
	}

	public static HouseBoatDAOImpl createHouseBoatDAO() {
		Logger logger = LogManager.getLogger(Factory.class);
		logger.info("FactoryDAO: Inside HouseBoatDAOImpl Method");
		return new HouseBoatDAOImpl();
	}
}
