package Com.Ecommerce.Testcases;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

import Com.Ecommerce.Baseclass.Ecommerce_Base_class;
import Com.Ecommerce.Pageclasses.New_registration;
import net.bytebuddy.utility.RandomString;

public class New_registration_Testcases extends Ecommerce_Base_class {

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void Registration() {

		New_registration TC = new New_registration();

		TC.Register();
		logger.info("Click on register");
		TC.SelectGender();
		logger.info("Select gender");
		TC.SetFirstname("Pradeep");
		logger.info("First Name");
		TC.SetLastname("Kardile");
		logger.info("Last Name");
		
		TC.Select_Day();
		logger.info("Select Day");
		TC.Select_Month();
		logger.info("Select Months");
		TC.Select_Year();
		logger.info("Select Year");

		String Name = RandomString.make(5);  
		TC.SetEmail(Name+"PK12@gmail.com"); 
		
		
												                                      // registration.
		TC.SetPassword("123ABC");
		logger.info("Set Password");
		TC.SetConfirmPassword("123ABC");
		logger.info("confirm Password");
		TC.ClickRegisterButton();
		logger.info("Button");

		boolean Validate = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"))
				.isDisplayed();

		String Exp = "Your registration completed";

		if (Exp.equals(Validate)) {

			System.out.println("Correct Text");
		} else {

			System.out.println("InCorrect Text");
		}
	}

}
