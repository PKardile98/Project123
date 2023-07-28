package Com.Ecommerce.Testcases;

import org.testng.annotations.Test;

import Com.Ecommerce.Baseclass.Ecommerce_Base_class;
import Com.Ecommerce.Pageclasses.Login_Page;

public class LoginTestcase extends Ecommerce_Base_class {

	
	@Test
	public void Login() {
		
		Login_Page TL = new Login_Page();
		
		TL.Login_tab();
		logger.info("Hit on the login tab");
		TL.registerEmail(Username);
		logger.info("Username entered");
		TL.registerPassword(Password);
		logger.info("Password entered");
		
		TL.ClickloginButton();
}
}

