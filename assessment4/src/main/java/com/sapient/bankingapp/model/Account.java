package com.sapient.bankingapp.model;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "accounts")
public class Account {
	// Add properties and proper annotations
	private String id;
	private String accountNumber;
	private BigDecimal balance;
	@DBRef
	private Customer customer;
	private String accountType;
	private String interestRate;
}
