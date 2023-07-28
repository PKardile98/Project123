package Com.Ecommerce.Testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import Com.Ecommerce.Baseclass.Ecommerce_Base_class;
import Com.Ecommerce.Pageclasses.Links_POM;

public class Broken_link_TestCase extends Ecommerce_Base_class {

	
	
	@Test
	public void B_links() throws IOException {
		
		Links_POM PK1 = new Links_POM(driver);
		PK1.L1();
		
	}
}
