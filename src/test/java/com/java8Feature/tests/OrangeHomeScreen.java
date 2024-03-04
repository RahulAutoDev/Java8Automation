package test.java.com.java8Feature.tests;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import main.java.com.java8Features.Base.TestBase;

public class OrangeHomeScreen{
	
	WebDriver driver = TestBase.setDriver();
	

	@Test
	public void verifyHome() throws InterruptedException
	{
		driver.get("https://demo.applitools.com/");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("a");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("a");
		driver.findElement(By.xpath("//a[@id='log-in']")).click();
		//Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.alertIsPresent());
		List<WebElement> eleList = driver.findElements(By.tagName("span")).stream().
						filter(e -> e.getText().trim().length() > 5).collect(Collectors.toList());
		eleList.forEach(e -> System.out.println(e.getText()));
		List<WebElement> strList = eleList.stream().filter(ele -> ele.getText().matches("^((?!s).)*$"))
									.collect(Collectors.toList());
		System.out.println("-------------------------------------------");
		Predicate<WebElement> p1 = ele -> ele.getText().toLowerCase().contains("s");
		strList.stream().forEach(e -> System.out.println(e.getText()));
		strList.removeIf(p1);
		System.out.println("-------------------------------------------");
		strList.forEach(e -> System.out.println(e.getText()));
	}

	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
	
	

	

}
