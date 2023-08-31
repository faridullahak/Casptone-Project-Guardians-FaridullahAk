package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailAccountPage extends BaseSetup{
	
	public RetailAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}
	// Update Profile Information
	
	@FindBy(linkText = "Account")
	public WebElement accountLink;
	
	@FindBy(id = "nameInput")
	public WebElement nameField;
	
	@FindBy(id = "personalPhoneInput")
	public WebElement phoneField;
	
	@FindBy(id = "personalUpdateBtn")
	public WebElement updateBttn;
	
	@FindBy(xpath = "//div[text()='Personal Information Updated Successfully']")
	public WebElement personalInfoUpdateSuccessMssg;
	
	
	// Add Payment method
	
	@FindBy(xpath = "//p[text()='Add a payment method']")
	public WebElement addAPaymentMethodLink;
	
	@FindBy(id = "cardNumberInput")
	public WebElement cardNumberField;
	
	@FindBy(id = "nameOnCardInput")
	public WebElement nameOnCardField;
	
	@FindBy(id = "expirationMonthInput")
	public WebElement expirationMonthField;
	
	@FindBy(id = "expirationYearInput")
	public WebElement expireationYearField;
	
	@FindBy(id = "securityCodeInput")
	public WebElement securityCodeField;
	
	@FindBy(id = "paymentSubmitBtn")
	public WebElement paymentSubmitBtn;
	
	@FindBy(xpath = "//div[text()='Payment Method added sucessfully']")
	public WebElement paymentMethodSuccessMssg;
	
	
	//edit payment
		@FindBy(xpath = "//div[@class='false account__payment-item']")
		public WebElement firstPaymentCard;

		@FindBy(xpath = "//button[ text()='Edit']")
		public WebElement editPaymentCard;
		
		@FindBy(id = "paymentSubmitBtn")
		public WebElement updatePaymentBtn;
		
		@FindBy(xpath = "//div[text()='Payment Method updated Successfully']")
		public WebElement updateSuccessMsg;

	//Remove Card
		@FindBy(xpath = "//button[text()='remove']")
		public WebElement cardRemoveBtn;
		@FindBy(xpath = "//h1[@class='account__payment-new-title']")
		public WebElement addCardHeader;
		@FindBy(xpath = "//p[@class='account__payment-sub-title']")
		public WebElement paymentList;
		
	//Add Address
	@FindBy(xpath = "//div[starts-with(@class,'account__address-new-')]")
	public WebElement addAddressLink;
	
	@FindBy(id = "countryDropdown")
	public WebElement AddressCountryDropdown;
	
	@FindBy(id = "fullNameInput")
	public WebElement addressNameField;
	
	@FindBy(id = "phoneNumberInput")
	public WebElement addressPhoneField;
	
	@FindBy(id = "streetInput")
	public WebElement addressStreetField;
	
	@FindBy(id = "apartmentInput")
	public WebElement addressApartmentNum;
	
	@FindBy(id = "cityInput")
	public WebElement addressCityField;
	
	@FindBy(name = "state")
	public WebElement addressStateDropdown;
	
	@FindBy(id = "zipCodeInput")
	public WebElement addressZipCodeField;
	
	@FindBy(id = "addressBtn")
	public WebElement addressAddBttn;
	
	@FindBy(xpath = "//div[text()='Address Added Successfully']")
	public WebElement addressSuccessMssg;
	
	//Update Address
	

	@FindBy(xpath = "//button[@class='account__address-btn' and text()='Edit']")
	public WebElement editAddressBtn; 

	@FindBy(id = "addressBtn")
	public WebElement updateAddressBtn;

	@FindBy(xpath = "//div[text()='Address Updated Successfully']")
	public WebElement addressUpdatedSuccessfully;
	
	// Address Remove
	
	@FindBy(xpath = "//button[text()='Remove']")
	public WebElement addressRemoveBtn;
	
	@FindBy(xpath = "//div[@class='account__address-single']")
	public WebElement addressBar;
	 
}
