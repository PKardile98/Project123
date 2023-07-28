package Com.Ecommerce.Pageclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Com.Ecommerce.Baseclass.Ecommerce_Base_class;

public class New_registration extends Ecommerce_Base_class {

	public New_registration() {
		
		PageFactory.initElements(driver, this);

	}

	// Register button
	@FindBy(xpath = "//a[@href=\"/register?returnUrl=%2F\"]")
	public WebElement Login;

	@FindBy(id = "gender-male")
	public WebElement GenderMale;

	@FindBy(id = "FirstName")
	public WebElement Firstname;

	@FindBy(id = "LastName")
	public WebElement Lastname;

	@FindBy(xpath = "//input[@type=\"email\"]")
	public WebElement Email;

	@FindBy(xpath = "//input[@type=\"password\"]")
	public WebElement Password;

	@FindBy(xpath = "(//input[@type=\"password\"])[2]")
	public WebElement ConfirmPassword;

	@FindBy(xpath = "//button[@id=\"register-button\"]")
	public WebElement RegisterButton;

	// List Box

	@FindBy(xpath = "//select[@name=\"DateOfBirthDay\"]")
	public WebElement Day;

	@FindBy(xpath = "//select[@name=\"DateOfBirthMonth\"]")
	public WebElement Month;

	@FindBy(xpath = "//select[@name=\"DateOfBirthYear\"]")
	public WebElement Year;

	public void Register() {
		Login.click();
	}

	public void SelectGender() {
		GenderMale.click();
	}

	public void SetFirstname(String FName) {
		Firstname.sendKeys(FName);
	}

	public void SetLastname(String LName) {
		Lastname.sendKeys(LName);
	}

	public void SetEmail(String EmailID) {
		Email.sendKeys(EmailID);
	}

	public void SetPassword(String PassWord) {
		Password.sendKeys(PassWord);
	}

	public void SetConfirmPassword(String ConfirmPassWord) {
		ConfirmPassword.sendKeys(ConfirmPassWord);
	}

	public void ClickRegisterButton() {
		RegisterButton.click();
	}

	public void Select_Day() {

		Day.click();
		Select S1 = new Select(Day);
		S1.selectByVisibleText("2");

	}

	public void Select_Month() {

		Month.click();
		Select S1 = new Select(Month);
		S1.selectByVisibleText("June");

	}

	public void Select_Year() {

		Year.click();
		Select S1 = new Select(Year);
		S1.selectByVisibleText("1998");

	}
}
