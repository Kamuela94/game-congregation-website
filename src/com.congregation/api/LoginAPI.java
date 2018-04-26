package com.congregation.api;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.infy.bean.HouseBoatBooking;
import com.infy.resources.AppConfig;
import com.infy.resources.Factory;
import com.infy.resources.JSONParser;
import com.infy.service.HouseBoatService;

@Path("Login")
public class LoginAPI {

	@Path("login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response booking(String dataRecieved) throws Exception {
		Response response = null;
		String string = dataRecieved;
		try {
			HouseBoatBooking houseBoatBooking = JSONParser.fromJson(string,
					HouseBoatBooking.class);
			
			HouseBoatService houseBoatService = Factory
					.createHouseBoatService();
			houseBoatBooking = houseBoatService.bookHouseBoat(houseBoatBooking);
			
			String successMessage = this.getBookingSuccessMessage(houseBoatBooking);
			
			houseBoatBooking = new HouseBoatBooking();
			houseBoatBooking.setMessage(successMessage);
			
			String returnString = JSONParser.toJson(houseBoatBooking);
			response = Response.status(Status.OK).entity(returnString).build();
		} catch (Exception e) {
			
			
			String errorMessage = AppConfig.PROPERTIES.getProperty(e.getMessage());
			
			HouseBoatBooking houseBoatBooking = new HouseBoatBooking();
			houseBoatBooking.setMessage(errorMessage);
			
			String returnString = JSONParser.toJson(houseBoatBooking);

			response = Response.status(Status.SERVICE_UNAVAILABLE)
					.entity(returnString).build();
		}
		return response;
	}

	@Path("fetchboatingtypes")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response fetchBoatingTypeList() throws Exception {
		String returnValue = null;
		Response response = null;
		try {
			HouseBoatService houseBoatService = Factory
					.createHouseBoatService();
			Map<String, String> boatingTypes = houseBoatService
					.getBoatingTypes();
			returnValue = JSONParser.toJson(boatingTypes);
			response = Response.status(Status.OK).entity(returnValue).build();
		} catch (Exception e) {
			String errorMessage = AppConfig.PROPERTIES.getProperty(e.getMessage());
			
			HouseBoatBooking houseBoatBooking = new HouseBoatBooking();
			houseBoatBooking.setMessage(errorMessage);
			
			String returnString = JSONParser.toJson(houseBoatBooking);

			response = Response.status(Status.SERVICE_UNAVAILABLE)
					.entity(returnString).build();
		}
		return response;
	}
	
	private String getBookingSuccessMessage(HouseBoatBooking houseBoatBooking){
		String message = AppConfig.PROPERTIES
				.getProperty("BOOKINGAPI.BOOKING_SUCCESS1");
		message += houseBoatBooking.getBookingId();
		message += AppConfig.PROPERTIES
				.getProperty("BOOKINGAPI.BOOKING_SUCCESS2");
		message += houseBoatBooking.getTotalCost();
		return message;
	}

}