package com.example.AdminFlightDetails.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AdminFlightDetails.model.FlightDetails;
import com.example.AdminFlightDetails.repository.FlightRepo;


@Service
public class FlightService {
    @Autowired
    private FlightRepo flightDetailRepository;
    

   //ADD FLIGHTS 
    public FlightDetails addFlightDetail(FlightDetails flightDetail) {
    	
        return flightDetailRepository.save(flightDetail);
    }

    //SEARCH FLIGHTS
    public List<FlightDetails> searchFlights(String source, String destination, LocalDate date) {
    	 List<FlightDetails> matchingFlights = flightDetailRepository.findBySourceAndDestination(source, destination);
         
         String dayOfWeek = date.getDayOfWeek().toString();
         
         return matchingFlights.stream()
             .filter(flightDetail -> flightDetail.getNoOfDaysInWeek().contains(dayOfWeek))
             .collect(Collectors.toList());
    }

    //GET FLIGHTS
	public List<FlightDetails> getdata() {
		// TODO Auto-generated method stub
		return flightDetailRepository.findAll();
	}

	//UPDATE FLIGHTS
	public FlightDetails updateFlightDetails(String id, FlightDetails updatedFlightDetails) {
        // Find the existing FlightDetails by ID
       Optional<FlightDetails> optionalFlightDetails = flightDetailRepository.findById(id);

       
            FlightDetails existingFlightDetails = optionalFlightDetails.get();

            // Update the fields 
            existingFlightDetails.setFlightName(updatedFlightDetails.getFlightName());
            existingFlightDetails.setFlightNumber(updatedFlightDetails.getFlightNumber());
            existingFlightDetails.setSource(updatedFlightDetails.getSource());
            existingFlightDetails.setDestination(updatedFlightDetails.getDestination());
            existingFlightDetails.setDepartureTime(updatedFlightDetails.getDepartureTime());
            existingFlightDetails.setArrivalTime(updatedFlightDetails.getArrivalTime());
            existingFlightDetails.setPrice(updatedFlightDetails.getPrice());
            existingFlightDetails.setNoOfDaysInWeek(updatedFlightDetails.getNoOfDaysInWeek());

            // Save the updated FlightDetails 
            return flightDetailRepository.save(existingFlightDetails);
        
    }

	




	
    
      
}