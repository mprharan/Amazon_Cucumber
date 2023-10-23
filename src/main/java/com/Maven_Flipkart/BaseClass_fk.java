package com.Maven_Flipkart;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass_fk {

	public static WebDriver d = null;

	public static void userInput(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public static void clickOnElement(WebElement element) {
		element.click();
	}

	public static void sleep() throws InterruptedException {
		Thread.sleep(1000);
	}

	public static WebDriver browserLaunch(String value) {
		try {
			if (value.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				d = new ChromeDriver();
			} else if (value.equalsIgnoreCase("edge")) {
				d = new EdgeDriver();
			} else if (value.equalsIgnoreCase("gecko")) {
				d = new FirefoxDriver();
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
		d.manage().window().maximize();
		return d;
	}

	public static void close() {
		d.close();
	}

	public static void launchUrl(String url) {
		d.get(url);
	}

	public static void implicitlyWait() {
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static String getTitle() {
		String title = d.getTitle();
		return title;
	}

	public static String getCurrentUrl() {
		String currentUrl = d.getCurrentUrl();
		return currentUrl;
	}

	public static void navigateTo(String url) {
		try {
			d.navigate().to(url);
		} catch (Exception e) {
			throw new TimeoutException("Unable To Load The Page");
		}
	}

	public static void navigateForward() {
		d.navigate().forward();
	}

	public static void navigateBack() {
		d.navigate().back();
	}

	public static void refresh() {
		d.navigate().refresh();
	}

	public static List<WebElement> dropDownOptions(WebElement element) {
		Select s1 = new Select(element);
		List<WebElement> options = s1.getOptions();
		return options;
	}

	public static void dropDownSelect(String options, WebElement element, String value) {
		Select s = new Select(element);
		try {
			if (options.equalsIgnoreCase("value")) {
				s.selectByValue(value);
			} else if (options.equalsIgnoreCase("text")) {
				s.selectByVisibleText(value);
			} else if (options.equalsIgnoreCase("index")) {
				int n = Integer.parseInt(value);
				s.deselectByIndex(n);
			}
		} catch (Exception e) {
			throw new RuntimeException("Can't Select A Value");
		}
	}

	public static void popup(String options) {
		if (options.equalsIgnoreCase("ok")) {
			d.switchTo().alert().accept();
		} else if (options.equalsIgnoreCase("cancel")) {
			d.switchTo().alert().dismiss();
		}
	}

	public static void sendKeysAlert(String value) {
		d.switchTo().alert().sendKeys(value);
	}

	public static void frameSwitch(String element) {
		d.switchTo().frame(element);
	}

	public static void capture(String name) throws IOException {
		try {
			TakesScreenshot scs = (TakesScreenshot) d;
			File screenshotAs = scs.getScreenshotAs(OutputType.FILE);
			File destination = new File("D:\\Selenium scs\\" + name + ".png");
			FileHandler.copy(screenshotAs, destination);
		}  catch (Exception e) {
			throw new RuntimeException("Can't Take SCS");
		}
	}
}
