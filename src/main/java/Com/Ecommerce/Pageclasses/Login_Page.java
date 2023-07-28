package Com.Ecommerce.Pageclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Ecommerce.Baseclass.Ecommerce_Base_class;

public class Login_Page extends Ecommerce_Base_class {
	
	

	public Login_Page () {
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath = "//a[contains(text(),'Log in')]")
	public WebElement Click_login;
	
	@FindBy(xpath="//input[@id='Email']")
	public WebElement RegEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	public WebElement RegPassword;
	
	@FindBy(xpath="//a[contains(text(),\"Log in\")]")
	public WebElement Loginbutton;


	public void registerEmail(String RegEmailID) {
		RegEmail.sendKeys(RegEmailID);
	}

	public void registerPassword(String RegPassWord) {
		RegPassword.sendKeys(RegPassWord);
	}
	public void ClickloginButton() {
		Loginbutton.click();
	}
	
	public void Login_tab() {
		Click_login.click();
	}
	
	
}
