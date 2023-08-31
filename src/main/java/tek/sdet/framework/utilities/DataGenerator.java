package tek.sdet.framework.utilities;

import com.github.javafaker.Faker;

public class DataGenerator {
	
public static String addressGenerator(String input) {
		
		Faker faker = new Faker();
		
		String output ="";
		
		if(input.equalsIgnoreCase("countryValue")) {
			output = "United States";
		}else if(input.equalsIgnoreCase("fullnameValue")) {
			output = faker.name().fullName();
		}else if(input.equalsIgnoreCase("PhoneValue")){
			output = faker.phoneNumber().cellPhone();
		}else if(input.equalsIgnoreCase("stAddress")) {
			output = faker.address().streetAddress();
		}else if(input.equalsIgnoreCase("aptValue")) {
			output = faker.address().secondaryAddress();
		}else if(input.equalsIgnoreCase("cityValue")) {
			output = faker.address().city();
		}else if(input.equalsIgnoreCase("stateValue")) {
			output = faker.address().state();
		}else if(input.equalsIgnoreCase("zipCodeValue")) {
			String zipcode = faker.address().zipCode().substring(0,5);
			output = zipcode;
		}
		return output;
		
	}
public static String emailGenerator() {
	String prefix = "Hurrican_";
	String suffix = "@gmail.com";
	int random = (int)(Math.random()*10000);
	String email = prefix + random + suffix;
	return email;
}
public static String getPhoneNumber() {
	String phoneNumber ="2";
	for(int i = 0; i <9; i++) {
		phoneNumber += (int)(Math.random()*10);
	}
	return phoneNumber;
}
public static String getCardNumber() {
 String cardNumber = "";
 for(int i = 0; i <16; i++) {
	 cardNumber += (int)(Math.random()*10);
	}
 return cardNumber;
}
public static String getZipCode() {
 String zipcode ="";
 for (int i =1; i<=5; i++) {
	 zipcode += (int)(Math.random()*10);
 }
 return zipcode;
}
}

