package tek.sdet.framework.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;


public class RetailOrderPage extends BaseSetup{
	
	public RetailOrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	//add item
		@FindBy(xpath="//select[@id='search']") 
		public WebElement allDepartmentOption;
		
		@FindBy(xpath="//input[@id='searchInput']") 
		public WebElement searchBox;
		
		@FindBy(xpath = "//button[@class='search__btn']") 
		public WebElement searchIcon;
		
		@FindBy(xpath="//p[contains(text(),'Kasa Outdoor Smart Plug')]")
		public WebElement kasa;
		
		@FindBy (xpath ="//select[@class='product__select']") 
		public WebElement quantityOption;
		
		@FindBy(xpath="//button[@id='addToCartBtn']") 
		public WebElement addToCartBtn;
		
	//add address on order
		@FindBy(xpath="//p[@class='products__name']") 
		public WebElement ApexLegends;
		
		@FindBy(id="cartBtn") 
		public WebElement cartBtn;
		
		@FindBy (id="proceedBtn") 
		public WebElement proceedCheckoutBtn;
		
		@FindBy(xpath="//div[text()='Order Placed Successfully']")
		public WebElement orderPlacedSuccessMsg;
		

		@FindBy(id="placeOrderBtn") 
		public WebElement placeOrderBtn;
		
		@FindBy (xpath="//div[@class='shadow md:w-3/4 bg-white p-4']")
		public WebElement orderConfirmationNumber;
		
		@FindBy(id="cancelBtn") 
		public WebElement orderCancelBtn;
		
		@FindBy(id="buyAgainBtn") 
		public WebElement orderBuyAgainBtn;
	
	
	
	//Cancel order
	
	@FindBy(id = "orderLink")
	public WebElement OrderLink;
	
	@FindBy(xpath = "//div[@class='order']//descendant::p[7]")
	public List<WebElement> listOfOrders;
	
	@FindBy(xpath = "//button[text()='Cancel The Order']")
	public List<WebElement> cancelOrderBttn;
	
	@FindBy(id = "reasonInput")
	public WebElement reasonForCancelation;
	
	@FindBy(id = "orderSubmitBtn")
	public WebElement cancelationSubmitBttn;
	
	@FindBy(xpath = "//p[text()='Your Order Has Been Cancelled']")
	public WebElement orderCancelledSuccessMssg;
	
	// Return Order
	
	@FindBy(id = "//a[@id='orderLink']")
	public WebElement ordersLink;
	
	@FindBy(xpath = "//div[@class='orders__container']//descendant::p[text()='Show Details'][1]")
	public List<WebElement> ordersList;
	
	@FindBy(id = "returnBtn")
	public WebElement returnBttn;
	
	@FindBy(id = "reasonInput")
	public WebElement returnReason;
	
	@FindBy(id = "dropOffInput")
	public WebElement dropOffInput;
	
	@FindBy(id = "orderSubmitBtn")
	public WebElement orderReturnBtn;
	
	@FindBy(xpath = "//p[text()='Return was successfull']")
	public WebElement returnSuccessMss;
	
	//review
	
	
	@FindBy(id = "reviewBtn")
	public WebElement reviewBtn;
	
	@FindBy(id = "headlineInput")
	public WebElement headLineInput;
	
	@FindBy (id = "descriptionInput")
	public WebElement descriptionInput;
	
	@FindBy (id = "reviewSubmitBtn")
	public WebElement reviewSubmitBtn;
	
	@FindBy (xpath = "//div[text()='Your review was added successfully']")
	public WebElement reveiwSuccessMessg;
	
	

}
