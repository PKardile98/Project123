package Com.Ecommerce.Utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Com.Ecommerce.Baseclass.Ecommerce_Base_class;



public class GenericUtils extends Ecommerce_Base_class {
	
	public static String getScreenshotAs(String TestCasename, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String TimeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		String Name = "- Screenshot -" + TimeStamp;
		
		Path resourceDirectory = Paths.get("src", "test", "resources");
		
		String absolutePath = resourceDirectory.toFile().getAbsolutePath();
		
		System.out.println(absolutePath);
		
		String destination = absolutePath + "//Screenshot//" + TestCasename + "" + Name + ".png";
		
		FileUtils.copyFile(source, new File(destination));
		
		return destination;

	}

	public static void ClickElementUsingJavaScript(WebElement element, WebDriver driver) {
		
		JavascriptExecutor JE = (JavascriptExecutor) driver;
		
		JE.executeScript("arguments[0].click();", element);
	}

	public static WebElement Waitforelement(WebDriver driver, By Locator, int timeout) {
		
		WebDriverWait MyWait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		
		MyWait.until(ExpectedConditions.presenceOfElementLocated(Locator));
		
		return driver.findElement(Locator);
	}	
		
	}
