package com.sapient.bankingapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customers")
public class Customer {
	// Add properties and proper annotations
	@Id
	private String id;
	private String name;
	private String email;
	// Add other customer properties
	private Long mobile;
	private String address;
	private String city;
	private String zip;
	private String state;
	private String country;
}
