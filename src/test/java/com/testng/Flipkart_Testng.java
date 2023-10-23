package com.testng;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.Maven_Flipkart.BaseClass_fk;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart_Testng extends BaseClass_fk {
//	public static WebDriver d;
	String s;
	Integer parseInt;
	int totalNumberOfProducts;

	@Test(priority = -1)
	private void user_launch_the_website() {
//		WebDriverManager.chromedriver().setup();
//		d = new ChromeDriver();
//		d.manage().window().maximize();
//		d.get("https://www.flipkart.com/mens-tshirts/pr?sid=clo,ash,ank,edy&fm=neo%2Fmerchandising&iid=M_66cf9eb9-767e-4452-aed2-4f686fa9fb58_1_372UD5BXDFYS_MC.IF56C41VGEYS&otracker=hp_rich_navigation_2_1.navigationCard.RICH_NAVIGATION_Fashion~Men%2527s%2BTop%2BWear~Men%2527s%2BT-Shirts_IF56C41VGEYS&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_2_L2_view-all&cid=IF56C41VGEYS");
//		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		browserLaunch("chrome");
		launchUrl("https://www.flipkart.com/mens-tshirts/pr?sid=clo,ash,ank,edy&fm=neo%2Fmerchandising&iid=M_66cf9eb9-767e-4452-aed2-4f686fa9fb58_1_372UD5BXDFYS_MC.IF56C41VGEYS&otracker=hp_rich_navigation_2_1.navigationCard.RICH_NAVIGATION_Fashion~Men%2527s%2BTop%2BWear~Men%2527s%2BT-Shirts_IF56C41VGEYS&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_2_L2_view-all&cid=IF56C41VGEYS");
	}

	@Test(priority = 0)
	private void take_the_count_of_the_product_shown_in_the_page() {
		List<WebElement> allProducts = d
				.findElements(By.xpath("//div[@class='_1AtVbE col-12-12']//descendant::div[@style='width: 25%;']"));
		totalNumberOfProducts = allProducts.size();
		System.out.println("The total count of product is : " + totalNumberOfProducts);
	}

	@Test(priority = 1)
	private void checks_the_count_shown_on_top_of_the_page_and_print_as_string() {
		WebElement productText = d.findElement(By.xpath("//span[@class='_2tDckM']"));
		s = getText(productText);
		System.out.println("The Text Shown On Top Is: " + s);
	}

	@Test(priority = 2)
	private void converts_the_count_from_string_value_to_integer_value_and_prints() {
		String[] s1 = s.split(" ");

		String no = s1[3];

		parseInt = Integer.parseInt(no);

		System.out.println("Count Shown In The Site: " + parseInt);
	}

	@Test(priority = 3)
	private void verify_the_count_and_prints() {
		if (parseInt == totalNumberOfProducts) {
			System.out.println("Count Of The Products Is Verified");
		}
		close();
	}

}
