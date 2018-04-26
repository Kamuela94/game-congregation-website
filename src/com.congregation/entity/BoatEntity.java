package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Boat_Details")
public class BoatEntity 
{
	@Id
	@GeneratedValue
	private String boatId;
	private String boatingType ;
	private String location;
	private Double cost;
	
	public String getBoatId() {
		return boatId;
	}
	public void setBoatId(String boatId) {
		this.boatId = boatId;
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

}
