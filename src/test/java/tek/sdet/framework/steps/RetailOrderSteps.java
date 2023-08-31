package tek.sdet.framework.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailOrderSteps extends CommonUtility {

	POMFactory pomFactory = new POMFactory();

	//add Item
		@And("User change the category to {string}")
		public void userChangeTheCategoryToSmartHome(String category) {
			click(pomFactory.retailOrderPage().allDepartmentOption);
			selectByVisibleText(pomFactory.retailOrderPage().allDepartmentOption, category);
			logger.info("Category is changed to Smart Home successfully");
		}

		@And("User search for an item {string}")
		public void userSearchForAnItem(String item) {
			sendText(pomFactory.retailOrderPage().searchBox, item);
			logger.info("search for kasa outdoor smart plug");
		}

		@And("User click on Search icon")
		public void userClickOnSearchIcon() {
			click(pomFactory.retailOrderPage().searchIcon);
			logger.info("search button clicked successfully");
		}

		@And("User click on item")
		public void userClickOnItem() {
			click(pomFactory.retailOrderPage().kasa);
			logger.info("item clicked successfully");
		}

		@And("User select quantity {string}")
		public void userSelectQuantity(String quantity) {
			click(pomFactory.retailOrderPage().quantityOption);
			selectByVisibleText(pomFactory.retailOrderPage().quantityOption, quantity);
			logger.info("Quantity(2) is selected");
		}

		@And("User click add to Cart button")
		public void userClickAddToCartButton() {
			click(pomFactory.retailOrderPage().addToCartBtn);
			logger.info("Add to cart button clicked successfully");
		}

		@Then("the cart icon quantity should change to {string}")
		public void theCartIconQuantityShouldChangeTo(String quantity) {
			if (pomFactory.retailOrderPage().quantityOption.equals(quantity)) {
			}
			logger.info("quantity is 2");
		}

	//add address on order

		@And("User changes the category to the {string}")
		public void userChangesTheCategoryToThe(String category) {
			click(pomFactory.retailOrderPage().allDepartmentOption);
			selectByVisibleText(pomFactory.retailOrderPage().allDepartmentOption, category);
			logger.info("Category changed to Electronincs successfully");
		}

		@And("User searchs for an item {string}")
		public void userSearchsForAnItem(String item) {
			sendText(pomFactory.retailOrderPage().searchBox, item);
			logger.info("search for an item");
		}

		@And("User clicks on Search icon")
		public void userClicksOnSearchIcon() {
			clickElementWithJS(pomFactory.retailOrderPage().searchIcon);
			logger.info("search button clicked successfully");
		}

		@And("User clicks on item")
		public void userClicksOnItem() {
			click(pomFactory.retailOrderPage().ApexLegends);
			logger.info("item clicked successfully");
		}

		@And("User selects quantity {string}")
		public void userSelectsQuantity(String quantity) {
			click(pomFactory.retailOrderPage().quantityOption);
			selectByValue(pomFactory.retailOrderPage().quantityOption, quantity);
			logger.info("Quantity selected");
		}

		@And("User clicks add to Cart button")
		public void userClicksAddToCartButton() {
			click(pomFactory.retailOrderPage().addToCartBtn);
			logger.info("add to cart button clicked successfully");
		}

		@And("the carts icon quantity should change to {string}")
		public void theCartsIconQuantityShouldChangeTo(String quantity) {
			if (pomFactory.retailOrderPage().quantityOption.equals(quantity)) {
				logger.info("quantity is 5");
			}
		}

		@And("User click on Cart option")
		public void userClickOnCartOption() {
			click(pomFactory.retailOrderPage().cartBtn);
			logger.info("Cart option clicked successfully");
		}

		@And("User click on Proceed to Checkout button")
		public void userClickOnProceedToCheckoutButton() {
			click(pomFactory.retailOrderPage().proceedCheckoutBtn);
			logger.info("check out option clicked successfully");
		}

		@And("User click on Place Your Order")
		public void userClickOnPlaceYourOrder() {
			click(pomFactory.retailOrderPage().placeOrderBtn);
			logger.info("place order button was clicked successfully");
		}

		@Then("a confirmation message should be displayed {string}") 
		public void aConfirmationMessageShouldBeDisplayed(String message) {
			waitTillPresence(pomFactory.retailOrderPage().orderPlacedSuccessMsg);
			Assert.assertTrue(pomFactory.retailOrderPage().orderPlacedSuccessMsg.isDisplayed());
			logger.info("confirmation Message displayed");
		}

	

	// Cancel Order
	@Then("User click on Orders section")
	public void userClickOnOrdersSection() {
		click(pomFactory.retailOrderPage().OrderLink);
		logger.info("Order link was clicked successfully");
	}

	@Then("User click on first order in list")
	public void userClickOnFirstOrderInList() {
		List<WebElement> listOfOrder = pomFactory.retailOrderPage().listOfOrders;
		for (int i = 0; i < listOfOrder.size(); i++) {
			if (listOfOrder.get(i).getText().equalsIgnoreCase("Hide Details")) {

			} else if (listOfOrder.get(i).getText().equalsIgnoreCase("Show Details")) {
				click(pomFactory.retailOrderPage().listOfOrders.get(i));
			}
		}
		logger.info("First order in the list is clicked");
	}

	@Then("User click on Cancel The Order button")
	public void userClickOnCancelTheOrderButton() {
		List<WebElement> cancelBttns = pomFactory.retailOrderPage().cancelOrderBttn;
		click(cancelBttns.get(0));
		logger.info("Cancel Submit Button was clicked successfully");
	}

	@Then("User select the cancelation Reason {string}")
	public void userSelectTheCancelationReason(String cancelationReason) {
		selectByVisibleText(pomFactory.retailOrderPage().reasonForCancelation, cancelationReason);
		logger.info("Cancelation reason was selected");

	}
	@Then("User click on Cancel Order button")
	public void userClickOnCancelOrderButton() {
		click(pomFactory.retailOrderPage().cancelationSubmitBttn);
		logger.info("order link was click successfully");
	   
	}

	@Then("a cancelation message should be displayed {string}")
	public void aCancelationMessageShouldBeDisplayed(String CancelationSuccessMssg) {
		Assert.assertEquals(CancelationSuccessMssg, pomFactory.retailOrderPage().orderCancelledSuccessMssg.getText());
		logger.info("Cancelation success message was verified successfully");
	}
	// Retun Orders

	@Then("User click on Order section")
	public void userClickOnOrderSection() {
		click(pomFactory.retailOrderPage().OrderLink);
		logger.info("order link was click successfully");
	}

	@Then("User click on 1st order in list")
	public void userClickOn1stOrderInList() {
		List<WebElement> firstOrder = pomFactory.retailOrderPage().ordersList;
		for (int i = 0; i < firstOrder.size(); i++) {
			if (firstOrder.get(i).getText().equalsIgnoreCase("Hide Details")) {

			} else if (firstOrder.get(i).getText().equalsIgnoreCase("Show Details")) {
				click(pomFactory.retailOrderPage().ordersList.get(i));
			}
		}
		logger.info("First order in the list is clicked");
	}

	@Then("User click on Return Items button")
	public void userClickOnReturnItemsButton() {
		click(pomFactory.retailOrderPage().returnBttn);
		logger.info("user clicked on return button successfully");
	}

	@Then("User select the Return Reason of {string}")
	public void userSelectTheReturnReasonOf(String reasonOfReturn) {
		selectByVisibleText(pomFactory.retailOrderPage().returnReason, reasonOfReturn);
		logger.info("return reason was selected successfully");
	}

	@Then("User select the drop off service {string}")
	public void userSelectTheDropOffService(String dropOffserviceFedexSelected) {
		selectByVisibleText(pomFactory.retailOrderPage().dropOffInput, dropOffserviceFedexSelected);
		logger.info("return reason was selected successfully");
	}

	@Then("User click on Return Order button")
	public void userClickOnReturnOrderButton() {
		click(pomFactory.retailOrderPage().orderReturnBtn);
		logger.info("order return button was clicked successfully");
	}

	@Then("a cancelation message should be displayed as {string}")
	public void aCancelationMessageShouldBeDisplayedAs(String orderReturnSuccessMssg) {
		waitTillPresence(pomFactory.retailOrderPage().returnSuccessMss);
		Assert.assertTrue(isElementDisplayed(pomFactory.retailOrderPage().returnSuccessMss));
		logger.info("Return was successful");
	}
//review

	@When("User click on Orders sections")
	public void userClickOnOrdersSections() {
		click(pomFactory.retailOrderPage().OrderLink);
		logger.info("order link was clicked successfully");
	}

	@When("User click on first order in the list")
	public void userClickOnFirstOrderInTheList() {
		List<WebElement> firstOrder = pomFactory.retailOrderPage().ordersList;
		for (int i = 0; i < firstOrder.size(); i++) {
			if (firstOrder.get(i).getText().equalsIgnoreCase("Hide Details")) {

			} else if (firstOrder.get(i).getText().equalsIgnoreCase("Show Details")) {
				click(pomFactory.retailOrderPage().ordersList.get(i));
			}
		}
		logger.info("First order in the list is clicked");
	}

	@Then("User click on Review button")
	public void userClickOnReviewButton() {
		click(pomFactory.retailOrderPage().reviewBtn);
		logger.info("review button was clicked successfully");

	}

	@When("User write Review headline {string} and {string}")
	public void userWriteReviewHeadlineAnd(String headlineInputField, String descriptionField) {
		sendText(pomFactory.retailOrderPage().headLineInput, "Good Quality");
		sendText(pomFactory.retailOrderPage().descriptionInput, "same as picture");
		logger.info("headline was entered successfully");
	}

	@Then("User click Add your Review button")
	public void userClickAddYourReviewButton() {
		click(pomFactory.retailOrderPage().reviewSubmitBtn);
		logger.info("description was added successfully");
	}

	@Then("a review message should be displayed {string}")
	public void aReviewMessageShouldBeDisplayed(String reviewMessageShouldBeDisplay) {
		waitTillPresence(pomFactory.retailOrderPage().reveiwSuccessMessg);
		Assert.assertTrue(reviewMessageShouldBeDisplay, pomFactory.retailOrderPage().reveiwSuccessMessg.isDisplayed());
		logger.info("Your review was added successfully");
	}

}
