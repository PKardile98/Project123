package Com.Ecommerce.Pageclasses;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Links_POM {

	public WebDriver driver;

	public Links_POM(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(tagName = "a") // links
	public List<WebElement> AllLinks;

	public void L1() throws IOException {

		System.out.println("Total links -->" + AllLinks.size());

		int Bronkenlinks = 0;

		for (WebElement L1 : AllLinks) {

			// By using the href we can get the URL of the required link
			String url = L1.getAttribute("href");

			if (url == null || url.isEmpty()) {

				System.out.println("url is empty or null");
			}

			URL L2 = new URL(url);

			// Create the object ULR object"L2"

			// HttpURLConnection httpscode = (HttpURLConnection) L2.openConnection(); //

			CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
			HttpURLConnection httpscode = (HttpURLConnection) L2.openConnection();
			httpscode.connect();
			// 200--ok
			// 400--bad request

			if (httpscode.getResponseCode() >= 400) {

				System.out.println(httpscode.getResponseCode() + "--->" + url + "is--> broken link");
				Bronkenlinks++;

			} else {

				System.out.println(httpscode.getResponseCode() + "--->" + url + "is--> Valid link");

			}

		}
		System.out.println("No. of broken links-->" + Bronkenlinks);

	}

}
