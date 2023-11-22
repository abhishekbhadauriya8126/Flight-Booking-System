package com.paymentService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paymentService.model.TransactionDetails;
import com.paymentService.service.TransactionService;

@CrossOrigin("http://localhost:4200/")
@RequestMapping("/transactionService")
@RestController
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	@GetMapping("/createTransaction/{amount}")
	public TransactionDetails createTransaction(@PathVariable double amount) {
		return transactionService.createTransaction(amount);
	}
 
}
