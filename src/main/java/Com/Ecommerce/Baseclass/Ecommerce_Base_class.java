package Com.Ecommerce.Baseclass;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Com.Ecommerce.configuration.Read_configuration;

public class Ecommerce_Base_class  {

	public static WebDriver driver;
	public static Logger logger;

	Read_configuration RD1 = new Read_configuration();

	public String BaseURL  =  RD1.GetAppURL();
	public String Username = RD1.U_Name();
	public String Password = RD1.Pass();

	
	
	@SuppressWarnings({"deprecation","static-access"})
	@BeforeTest
	@Parameters("Browser")
	public void intialization(String Browsername) {
		
		

		
		logger = logger.getLogger("11_March_Maven");

		PropertyConfigurator.configure("C:\\Users\\Prashant\\eclipse-workspace\\11_March_Maven\\Configuration\\Log4j.properties");

		if(Browsername.equals("Chrome")) {
			
			System.setProperty("webdriver.driver.chrome", RD1.GetChormePath());
			driver = new ChromeDriver();
		}
		else if(Browsername.equals("Firefox")) {
			
			System.setProperty("webdriver.gecko.chrome", RD1.Getgeckopath());
			driver = new FirefoxDriver();
			
		}
		
		logger.info("Open browser");

		driver.manage().window().maximize();
		logger.info("maximize browser ");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get(BaseURL);
		logger.info("Open Application");

	}

	@AfterMethod
	public void Teardown() throws InterruptedException {

		Thread.sleep(3000);
		driver.quit();

	}

}
