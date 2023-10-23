package com.Maven_Flipkart;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {

	public static WebDriver d = null;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver();
		d.get("https://www.flipkart.com/mens-tshirts/pr?sid=clo,ash,ank,edy&fm=neo%2Fmerchandising&iid=M_66cf9eb9-767e-4452-aed2-4f686fa9fb58_1_372UD5BXDFYS_MC.IF56C41VGEYS&otracker=hp_rich_navigation_2_1.navigationCard.RICH_NAVIGATION_Fashion~Men%2527s%2BTop%2BWear~Men%2527s%2BT-Shirts_IF56C41VGEYS&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_2_L2_view-all&cid=IF56C41VGEYS");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> allProducts = d
				.findElements(By.xpath("//div[@class='_1AtVbE col-12-12']//descendant::div[@style='width: 25%;']"));
		int totalNumberOfProducts = allProducts.size();
		System.out.println("The total count of product is : " + totalNumberOfProducts);
//		for (WebElement product : allProducts) {
//			System.out.println(product.getText());
//		}

		WebElement productText = d.findElement(By.xpath("//span[@class='_2tDckM']"));
		String s = productText.getText();
		System.out.println("The Text Shown On Top Is: " + s);

		String[] s1 = s.split(" ");

		String no = s1[3];

		Integer parseInt = Integer.parseInt(no);

		System.out.println("Count Shown In The Site: " + parseInt);

		if (parseInt == totalNumberOfProducts) {
			System.out.println("Count Of The Products Is Verified");
		}
		// System.out.println(no);

	}

}
