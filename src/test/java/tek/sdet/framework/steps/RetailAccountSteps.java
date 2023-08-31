package tek.sdet.framework.steps;


import java.util.List;

import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;
import tek.sdet.framework.utilities.DataGenerator;


public class RetailAccountSteps extends CommonUtility{
	
	POMFactory pomFactory = new POMFactory();
	
	// Update Profile Information
	
	@When("User click on Account option")
	public void userClickOnAccountOption() {
		click(pomFactory.retailAccountPage().accountLink);
		logger.info("Account link was clicked successfully");
		
	}
	@When("User update Name {string} and Phone {string}")
	public void userUpdateNameAndPhone(String name, String phoneNumber) {
		clearTextUsingSendKeys(pomFactory.retailAccountPage().nameField);
		sendText(pomFactory.retailAccountPage().nameField, name);
		logger.info("Name was entered successfully");
		
		clearTextUsingSendKeys(pomFactory.retailAccountPage().phoneField);
		sendText(pomFactory.retailAccountPage().phoneField, DataGenerator.getPhoneNumber());
		logger.info("Phone Number was entered successfully");
		
//		pomFactory.retailAccountPage().nameField.clear();
//		sendText(pomFactory.retailAccountPage().nameField, name);
//		logger.info("Name was entered successfully");
//		pomFactory.retailAccountPage().phoneField.clear();
//		sendText(pomFactory.retailAccountPage().phoneField, DataGenerator.getPhoneNumber());
//		logger.info("User name and Phone number are entered successfully.");
	}
	@When("User click on Update button")
	public void userClickOnUpdateButton() {
		click(pomFactory.retailAccountPage().updateBttn);
		logger.info("Update button was clicked successfully");
	}
	@Then("user profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		waitTillPresence(pomFactory.retailAccountPage().personalInfoUpdateSuccessMssg);
		String expectedMssg = "Personal Information Updated Successfully";
		String actualMssg = pomFactory.retailAccountPage().personalInfoUpdateSuccessMssg.getText();
		Assert.assertEquals(expectedMssg, actualMssg);
		logger.info("Account information was updated successfully");
		
		//you can use following method as well.
//		waitTillPresence(pomFactory.retailAccountPage().personalInfoUpdateSuccessMssg);
//		Assert.assertTrue(pomFactory.retailAccountPage().personalInfoUpdateSuccessMssg.isDisplayed());
//		logger.info("Account information was updated successfully");
	}
	//  addPaymentMethod
	
	@When("User click on Add a payment method link")
	public void userClickOnAddAPaymentMethodLink() {
		click(pomFactory.retailAccountPage().addAPaymentMethodLink);
		logger.info("Add Payment Method link was clicked successfully");
	}
	@When("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInformation(DataTable dataTable) {
		List<Map<String, String>> paymentInfo = dataTable.asMaps(String.class, String.class);
		for (int i =0; i< paymentInfo.size();i++) {
		sendText(pomFactory.retailAccountPage().cardNumberField, DataGenerator.getCardNumber());
		sendText(pomFactory.retailAccountPage().nameOnCardField, paymentInfo.get(0).get("nameOnCard"));
		selectByVisibleText(pomFactory.retailAccountPage().expirationMonthField, paymentInfo.get(0).get("expirationMonth"));
		selectByVisibleText(pomFactory.retailAccountPage().expireationYearField, paymentInfo.get(0).get("expirationYear"));
		sendText(pomFactory.retailAccountPage().securityCodeField, paymentInfo.get(0).get("securityCode"));
		}
		logger.info("Payment Information was entered successfully");
		
	}
	@When("User click on Add your card button")
	public void userClickOnAddYourCardButton() {
		click(pomFactory.retailAccountPage().paymentSubmitBtn);
		logger.info("Payment Method Submit bttn clicked successfully");
	}
	@Then("a message should be displayed {string}")
	public void aMessageShouldBeDisplayed(String expectedMssg) {
		
		expectedMssg = pomFactory.retailAccountPage().paymentMethodSuccessMssg.getText();
		waitTillPresence(pomFactory.retailAccountPage().paymentMethodSuccessMssg);
		Assert.assertTrue(pomFactory.retailAccountPage().paymentMethodSuccessMssg.isDisplayed());
		logger.info("Message displayed successfully: " + expectedMssg);
	}
//		
//		if(expectedMssg.contains("Payment Method added")) {
//			waitTillPresence(pomFactory.retailAccountPage().paymentMethodSuccessMssg);
//			Assert.assertEquals(expectedMssg, pomFactory.retailAccountPage().paymentMethodSuccessMssg.getText());
//			logger.info("Expected Message: " + expectedMssg);
//		}else if(expectedMssg.contains("Address Added")) {
//			waitTillPresence(pomFactory.retailAccountPage().addressSuccessMssg);
//			Assert.assertEquals(expectedMssg, pomFactory.retailAccountPage().addressSuccessMssg.getText());
//			logger.info("Expected Message: " + expectedMssg);
//		}else if(expectedMssg.contains("Order Placed")) {
//			waitTillPresence(pomFactory.retailOrderPage().orderPlacedSuccessfullyMssg);
//			Assert.assertEquals(expectedMssg, pomFactory.retailOrderPage().orderPlacedSuccessfullyMssg.getText());
//		}

		
		// EditPaymentMethod
	@When("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSection() {
		click(pomFactory.retailAccountPage().firstPaymentCard);
		click(pomFactory.retailAccountPage().editPaymentCard);
		logger.info("Payment edit button clicked successfully.");	 
	}
	@When("user edit information with below data")
	public void userEditInformationWithBelowData(DataTable dataTable) {
		List<Map<String, String>> cardInfo = dataTable.asMaps(String.class, String.class);
		for (int i = 0; i < cardInfo.size(); i++) {
			pomFactory.retailAccountPage().cardNumberField.clear();
			sendText(pomFactory.retailAccountPage().cardNumberField, DataGenerator.getCardNumber());
			pomFactory.retailAccountPage().nameOnCardField.clear();
			sendText(pomFactory.retailAccountPage().nameOnCardField, cardInfo.get(0).get("nameOnCard"));
			sendText(pomFactory.retailAccountPage().expirationMonthField, cardInfo.get(0).get("expirationMonth"));
			sendText(pomFactory.retailAccountPage().expireationYearField, cardInfo.get(0).get("expirationYear"));
			pomFactory.retailAccountPage().securityCodeField.clear();
			sendText(pomFactory.retailAccountPage().securityCodeField, cardInfo.get(0).get("securityCode"));

		}
		logger.info("Payment information updated");	
	}
	@When("user click on Update Your Card button")
	public void userClickOnUpdateYourCardButton() {
		click(pomFactory.retailAccountPage().updatePaymentBtn);
		logger.info("update payment button clicked successfully");	  
	}
	@Then("message should be displayed {string}")
	public void messageShouldBeDisplayed(String actualMsg) {
		waitTillPresence(pomFactory.retailAccountPage().updateSuccessMsg);
		String expectedMsg = "Payment Method updated sucessfully";
		if (actualMsg == expectedMsg) {
			Assert.assertTrue(pomFactory.retailAccountPage().updateSuccessMsg.isDisplayed());
			logger.info("payment success message displayed successfully.");
		}	  
	}		

	//RemovePaymentCard
	@When("User click on remove option of card section")
	public void userClickOnRemoveOptionOfCardSection() {
		click(pomFactory.retailAccountPage().paymentList);
		click(pomFactory.retailAccountPage().cardRemoveBtn);
		logger.info("card remove button clicked successfully");	
	}
	@Then("payment details should be removed")
	public void paymentDetailsShouldBeRemoved() {
		Assert.assertTrue(pomFactory.retailAccountPage().addCardHeader.isDisplayed());
		logger.info("payment card removed successfully.");
	}		
	//add Address
	@When("User click on Add address option")
	public void userClickOnAddAddressOption() {
		click(pomFactory.retailAccountPage().addAddressLink);
		logger.info("Add Address Link was clicked successfully");
	}
	@When("user fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(DataTable dataTable) {
		List<Map<String, String>> addressInfo = dataTable.asMaps(String.class, String.class);
		selectByVisibleText(pomFactory.retailAccountPage().AddressCountryDropdown, 
				DataGenerator.addressGenerator(addressInfo.get(0).get("country")));
		sendText(pomFactory.retailAccountPage().addressNameField, 
				DataGenerator.addressGenerator(addressInfo.get(0).get("fullName")));
		sendText(pomFactory.retailAccountPage().addressPhoneField, 
				DataGenerator.addressGenerator(addressInfo.get(0).get("phoneNumber")));
		sendText(pomFactory.retailAccountPage().addressStreetField, 
				DataGenerator.addressGenerator(addressInfo.get(0).get("streetAddress")));
		sendText(pomFactory.retailAccountPage().addressApartmentNum, 
				DataGenerator.addressGenerator(addressInfo.get(0).get("apt")));
		sendText(pomFactory.retailAccountPage().addressCityField, 
				DataGenerator.addressGenerator(addressInfo.get(0).get("city")));
		selectByVisibleText(pomFactory.retailAccountPage().addressStateDropdown, 
				DataGenerator.addressGenerator(addressInfo.get(0).get("state")));
		sendText(pomFactory.retailAccountPage().addressZipCodeField, 
				DataGenerator.addressGenerator(addressInfo.get(0).get("zipCode")));
		logger.info("Address form was filled out successfully");
	}
	
	@When("User click Add Your Address button")
	public void userClickAddYourAddressButton() {
		click(pomFactory.retailAccountPage().addressAddBttn);
		logger.info("Add Address Button was clicked successfully");
	}
	@Then("a message should be displayed as {string}")
	public void aMessageShouldBeDisplayedAs(String succMssg) {
		waitTillPresence(pomFactory.retailAccountPage().addressSuccessMssg);
		Assert.assertTrue(succMssg, pomFactory.retailAccountPage().addressSuccessMssg.isDisplayed());
		logger.info("Address Added Successfully message displayed");	
	}
	//Edit Address
	
	@When("User click on edit address option")
	public void userClickOnEditAddressOption() {
	click(pomFactory.retailAccountPage().editAddressBtn);
	logger.info("User clicked on Edit Address button");

	}

	@When("user fill edits address form with below information")
	public void userFillEditsAddressFormWithBelowInformation(DataTable dataTable) {
	List<Map<String, String>> updateAddress = dataTable.asMaps(String.class, String.class);
	selectByVisibleText(pomFactory.retailAccountPage().AddressCountryDropdown, updateAddress.get(0).get("country"));

	clearTextUsingSendKeys(pomFactory.retailAccountPage().addressNameField);
	sendText(pomFactory.retailAccountPage().addressNameField, updateAddress.get(0).get("fullName"));

	clearTextUsingSendKeys(pomFactory.retailAccountPage().addressPhoneField);
	sendText(pomFactory.retailAccountPage().addressPhoneField, updateAddress.get(0).get("phoneNumber"));

	clearTextUsingSendKeys(pomFactory.retailAccountPage().addressStreetField);
	sendText(pomFactory.retailAccountPage().addressStreetField, updateAddress.get(0).get("streetAddress"));

	clearTextUsingSendKeys(pomFactory.retailAccountPage().addressApartmentNum);
	sendText(pomFactory.retailAccountPage().addressApartmentNum, updateAddress.get(0).get("apt"));
	 
	clearTextUsingSendKeys(pomFactory.retailAccountPage().addressCityField);
	sendText(pomFactory.retailAccountPage().addressCityField, updateAddress.get(0).get("city"));

	clearTextUsingSendKeys(pomFactory.retailAccountPage().addressStateDropdown);
	sendText(pomFactory.retailAccountPage().addressStateDropdown, updateAddress.get(0).get("state"));

	clearTextUsingSendKeys(pomFactory.retailAccountPage().addressZipCodeField);
	sendText(pomFactory.retailAccountPage().addressZipCodeField, updateAddress.get(0).get("zipCode"));
	logger.info("User filled the new address information");

	}

	@When("User click update Your Address button")
	public void userClickUpdateYourAddressButton() {
	click(pomFactory.retailAccountPage().updateAddressBtn);
	logger.info("User clicked on update address button");

	}

	@Then("update message should be displayed 'Address Updated Successfully'")
	public void aMessageShouldBeDisplayedAddressUpdateSuccessfully() {
	waitTillPresence(pomFactory.retailAccountPage().addressUpdatedSuccessfully);
	Assert.assertTrue(isElementDisplayed(pomFactory.retailAccountPage().addressUpdatedSuccessfully));
	logger.info("User updated the address successfully");

	}
	//Address Remove
	
	@When("User click on remove option of Address section")
	public void userClickOnRemoveOptionOfAddressSection() {
	click(pomFactory.retailAccountPage().addressRemoveBtn);
	logger.info("User cicked on removeBtn successfully");
	}
	
	@Then("Address details should be removed")
	public void addressDetailsShouldBeRemoved() {
	 if(!isElementDisplayed(pomFactory.retailAccountPage().addressBar));
	 logger.info("Address was removed successfully");
	}
}