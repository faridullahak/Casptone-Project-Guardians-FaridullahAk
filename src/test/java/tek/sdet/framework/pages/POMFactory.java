package tek.sdet.framework.pages;

import tek.sdet.framework.base.BaseSetup;

public class POMFactory extends BaseSetup{
	
	private RetailHomePage retailHomePage;
	private RetailSignInPage retailSignInPage;
	private RetailAccountPage retailAccountPage;
	private RetailOrderPage retailOrderPage;

	
	public POMFactory() {
		this.retailHomePage = new RetailHomePage();
		this.retailSignInPage = new RetailSignInPage();
		this.retailAccountPage = new RetailAccountPage();
		this.retailOrderPage = new RetailOrderPage();
	
	}
	
	public RetailHomePage retailHomePage() {
		return this.retailHomePage;
	}
	
	public RetailSignInPage retailSignInPage() {
		return this.retailSignInPage;
	}
	
	public RetailAccountPage retailAccountPage() {
		return this.retailAccountPage;
	}
	
	public RetailOrderPage retailOrderPage() {
		return this.retailOrderPage;
	}

	
}
