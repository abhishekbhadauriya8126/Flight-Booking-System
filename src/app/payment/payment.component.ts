import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { OrderServiceService } from '../_services/order-service.service';
import { TokenStorageService } from '../_services/token-storage.service';

declare var Razorpay: any;

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  form: any = {};
  paymentId?: any;
  error?: any;
  username?: any;
  amount?: any;
  numberOfPassengers: any;
  price: any;

  constructor(
    private orderService: OrderServiceService,
    private tokenStorageService: TokenStorageService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    this.numberOfPassengers = 1;
  }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.numberOfPassengers = +params['pass'] || 1; // Use a default value if the parameter is missing or invalid
      this.price = +params['pr'];
      this.calculateAmount();
    });

    this.route.paramMap.subscribe((params) => {
      this.username = params.get('userId')!;
    });

    this.form.amount = this.amount;
    this.form.name = this.username;
  }

  calculateAmount() {
    // Calculate the amount based on the numberOfPassengers and the price per passenger
    this.amount = this.price * this.numberOfPassengers;
  }

  transactionDisplay() {
    this.orderService.createOrder(this.form.amount).subscribe(
      (response) => {
        console.log(response);
        this.openTransactionModel(response);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  openTransactionModel(response: any) {
    var options = {
      order_id: response.order_id,
      key: response.key,
      amount: response.amount,
      currency: response.currency,
      name: 'abhishek',
      description: 'Payment',
      image: '',
      handler: (response: any) => {
        console.log(this.processResponse(response));
      },
      prefill: {
        name: 'abhishek',
        email: 'abhishek@gmail.com',
        contact: '61726781'
      },
      notes: {
        address: 'GHHASKN'
      },
      theme: {
        color: '#F37254'
      }
    };

    var razorPayObject = new Razorpay(options);
    razorPayObject.open();
  }

  processResponse(resp: any) {
    console.log(resp);
    if (resp.razorpay_payment_id) {
      // Payment successful, navigate to the home page
      alert('Booking Successful');
      this.router.navigate(['/home']);
    } else {
      // Payment failed, handle accordingly
    }
  }
}
