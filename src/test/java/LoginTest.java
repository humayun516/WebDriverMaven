import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public static WebDriver driver;

	@BeforeSuite
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	}

	@Test
	public void doLogin() {

		driver.get("https://www.zoho.com/");
		driver.findElement(By.xpath("//a[@class='zh-login']")).click();
		driver.findElement(By.xpath("//input[@id='login_id']")).sendKeys("humayunnasir1@yahoo.com");
		driver.findElement(By.xpath("//form[@id='login']//button[@id='nextbtn']")).click();
		driver.findElement(By.id("password")).sendKeys("Engineer_2018");
		driver.findElement(By.cssSelector("#nextbtn")).click();
	}

	@AfterSuite
	public void tearDown() {

		driver.quit();

	}

}
