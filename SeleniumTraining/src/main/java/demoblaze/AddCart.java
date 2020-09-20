package demoblaze;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddCart {
	public WebDriver driver;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		System.out.println("launching chrome browser");
		String chromeDriverPath = System.setProperty("user.dir","\\chromedriver.exe");
		System.out.println(chromeDriverPath);
		driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test 
	public void addCart() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Nokia lumia 1520")).click();
		driver.findElement(By.linkText("Add to cart")).click();
		WebDriverWait wait=new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}