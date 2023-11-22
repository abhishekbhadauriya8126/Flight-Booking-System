package com.example.SearchFlights.model;

public class FlightDetails {
	private String flightName;
    private String flightNumber;
    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private String price;
    
    public FlightDetails() {}

	public FlightDetails(String flightName,String flightNumber, String source, String destination, String departureTime,
			String arrivalTime, String price) {
		super();
		this.flightName = flightName;
		this.flightNumber = flightNumber;
		this.source = source;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.price = price;
	}


	
	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
	
    
}
