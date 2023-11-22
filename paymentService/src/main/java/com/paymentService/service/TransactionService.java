package com.paymentService.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.paymentService.model.TransactionDetails;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

@Service
public class TransactionService {
	
	private static final String KEY = "rzp_test_QcpbNJ2UL28CPw";
	private static final String KEY_SECRET = "Dpd4Q1f68klqozXbiE9NynRe";
	private static final String CURRENCY = "INR";
 
	public TransactionDetails createTransaction(double amount) {
		try {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("amount", (amount * 100)); // for rupees
			jsonObject.put("currency", CURRENCY);
			
			
			RazorpayClient razorpayClient = new RazorpayClient(KEY, KEY_SECRET);
			Order order = razorpayClient.orders.create(jsonObject);
//			System.out.println(order);
			return prepareTransactionDetails(order);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	private TransactionDetails prepareTransactionDetails(Order order) {
		String orderId = order.get("id");
		String currency = order.get("currency");
		Integer amount = order.get("amount");
		
		TransactionDetails transactionDetails = new TransactionDetails(orderId, currency, amount, KEY);
		return transactionDetails;
	}
}
