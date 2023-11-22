import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent{
  searchArray: any[]=[];
  isLoggedIn:any = false;
  uSource: string="";
  uDestination: string="";
  date: string="";

  
getCurrentDate(): string {
    const currentDate = new Date();
    const year = currentDate.getFullYear();
    const month = (currentDate.getMonth() + 1).toString().padStart(2, '0');
    const day = currentDate.getDate().toString().padStart(2, '0');
    return `${year}-${month}-${day}`;
  }


  private baseUrl = 'http://localhost:8087';

  constructor(private http: HttpClient, private router: Router, private tokenStorage: TokenStorageService) {
    const userToken = window.sessionStorage.getItem('auth-token');
    if (userToken) {
      // User has a valid token, consider them logged in
      this.isLoggedIn = true;
    }
   }
  
  


   searchFlights() {
    // Convert source and destination to uppercase before making the request
    const source = this.uSource.toUpperCase();
    const destination = this.uDestination.toUpperCase();

    this.http.get(`${this.baseUrl}/flightDetails/search/${source}/${destination}/${this.date}`)
      .subscribe((data: any) => {
        if (data && data.length > 0) {
          this.searchArray = data;
        } else {
          // Display an alert when no flights are found
          alert('No flights found on this date.');
        }
      },
      (error) => {
        // Handle error console
        console.error('An error occurred while fetching flights:', error);
        // You can also display an error message to the user
        alert('An error occurred while fetching flights. Please try again later.');
      });
  }

  BookFlight(flightNumber: string, price: number) {
    if (this.isLoggedIn) {
      // The user is logged in, navigate to the booking page
      console.log(flightNumber);
      console.log(this.date);
      this.router.navigate(['/book', flightNumber, this.date,price]);
    } else {
      // The user is not logged in, redirect to the login page
      alert('Please login first.');
      this.router.navigate(['/login']);
    }
  }
  
}
