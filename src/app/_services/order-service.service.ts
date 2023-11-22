import { Injectable } from '@angular/core';
 
import { HttpClient, HttpHeaders } from '@angular/common/http';
 
import { Observable } from 'rxjs';
 
 
 
 
 
const httpOptions = {
 
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
 
  };
 
 
 
  declare var Razorpay: any;
 
 
 
 
 
@Injectable({
 
  providedIn: 'root'
 
})
 
export class OrderServiceService {
 
 
 
  constructor(private http: HttpClient) {
 
 
 
  }
 
 
 
  createOrder(amount:any): Observable<any> {
 
      return this.http.get<any>("http://localhost:8090/transactionService/createTransaction/"+amount);
 
  }
 
 
 
  updateOrder(order:any): Observable<any> {
 
      return this.http.put("http://localhost:8087/pg/createOrder", {
 
      razorpayOrderId: order.razorpay_order_id,
 
      razorpayPaymentId: order.razorpay_payment_id,
 
      razorpaySignature: order.razorpay_signature
 
      }, httpOptions);
 
  }
 
}