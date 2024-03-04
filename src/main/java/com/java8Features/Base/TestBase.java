package main.java.com.java8Features.Base;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	
	private final static Supplier<WebDriver> chromesupplier = () -> {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	};
	
	private final static Supplier<WebDriver> firefoxsupplier = () -> {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	};
	
	private static final Map<String, Supplier<WebDriver>> MAP = new HashMap<>();
	
	
	static {
		MAP.put("chrome",chromesupplier);
		MAP.put("firefox",firefoxsupplier);
	}
	
	public static WebDriver getDriver(String browser)
	{
		return MAP.get(browser).get();
	}
	
	public static WebDriver setDriver()
	{
		driver = getDriver("firefox");
		return driver;
	}

	
	
	

}
