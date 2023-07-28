package Com.Ecommerce.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.Ecommerce.Baseclass.Ecommerce_Base_class;
import Com.Ecommerce.Pageclasses.Login_Page;
import Com.Ecommerce.Utilities.ExcelUtils;

public class LoginTest_Data extends Ecommerce_Base_class {

	@Test(dataProvider = "Logindata")
	public void Login(String User, String Pass, String Expected) {

		Login_Page TL = new Login_Page();

		TL.Login_tab();
		logger.info("Hit on the login tab");
		TL.registerEmail(User);
		logger.info("Username entered");
		TL.registerPassword(Pass);
		logger.info("Password entered");
		TL.ClickloginButton();
		logger.info("Click on the Login button");

		String Act_Title = driver.getTitle();
		String Exp_Title = "nopcommerce demo store";

		if (Expected.equals("Valid")) {
			if (Act_Title.equals(Exp_Title)) {

				Assert.assertTrue(true);
				logger.info("Login test case pass");
			} else {
				Assert.assertTrue(false);
				logger.info("login test case failed");
			}
		} else if (Expected.equals("Invaild")) {
			if (Act_Title.equals(Exp_Title)) {
				AssertJUnit.assertTrue(false);
				logger.info("Login test case pass");
			} else {
				Assert.assertTrue(true);
				logger.info("Login test case failed");
			}
		}

	}

	@DataProvider(name = "Logindata")
	public Object[][] Getdata() throws IOException {

		String Path ="C:\\Users\\Prashant\\Desktop\\SS1\\11Match_TestData.xlsx";

		int R1 = ExcelUtils.GetRowcount(Path, "Sheet1");
		int C1 = ExcelUtils.GetCellcount(Path, "Sheet1", 1);

		Object logindata[][] = new Object[R1][C1];

		for (int i =1; i<R1; i++) {

			for (int j=0; j<C1; j++) {

				logindata[i-1][j] = ExcelUtils.GetCelldata(Path, "Sheet1", i, j);
			}
		}
		return logindata;
	}

}
