package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.uo.pojo.AddressPojo;

public class FakerAddressUtility {

	
	public static AddressPojo getFakerAddress() {
		
		Faker faker = new Faker(Locale.US);
		AddressPojo addressPojo = new AddressPojo(faker.company().name(),faker.address().buildingNumber(),faker.address().streetAddress(),faker.address().city(),faker.address().state(),faker.numerify("#####"),faker.phoneNumber().cellPhone(),faker.phoneNumber().cellPhone(),"Notes","Office Address");
		return addressPojo;
	}

}
