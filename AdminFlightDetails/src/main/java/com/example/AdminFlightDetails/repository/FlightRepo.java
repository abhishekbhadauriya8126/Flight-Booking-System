package com.example.AdminFlightDetails.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.AdminFlightDetails.model.FlightDetails;


public interface FlightRepo extends MongoRepository<FlightDetails, String> {
    List<FlightDetails> findBySourceAndDestination(String source, String destination);


	
	
}