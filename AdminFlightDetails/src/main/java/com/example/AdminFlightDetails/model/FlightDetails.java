package com.example.AdminFlightDetails.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "flightDetails")
public class FlightDetails {
    @Id
    private String id;
    private String flightName;
    private String flightNumber;
    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private String Price;
    private List<String> noOfDaysInWeek;
    
    
    public FlightDetails() {}
	
	
	

	public FlightDetails(String id,String flightName, String flightNumber, String source, String destination, String departureTime,
			String arrivalTime, String price, List<String> noOfDaysInWeek) {
		super();
		this.id = id;
		this.flightName=flightName;
		this.flightNumber = flightNumber;
		this.source = source;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		Price = price;
		this.noOfDaysInWeek = noOfDaysInWeek;
	}
	
	

	public String getPrice() {
		return Price;
	}




	public void setPrice(String price) {
		Price = price;
	}
	
	




	public String getFlightName() {
		return flightName;
	}




	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}




	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public List<String> getNoOfDaysInWeek() {
		return noOfDaysInWeek;
	}
	public void setNoOfDaysInWeek(List<String> noOfDaysInWeek) {
		this.noOfDaysInWeek = noOfDaysInWeek;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	
	

    
}