import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public static WebDriver driver;
	public WebDriverWait wait;

	@BeforeSuite
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	}

	@Test
	public void doLogin() throws InterruptedException {

		driver.get("http://www.way2automation.com/angularjs-protractor/banking/#/");
		driver.findElement(By.xpath("//button[contains(text(),'Bank Manager Login')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Add Customer')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Ben");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Ten");
		driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys("076");

	}

	@AfterSuite
	public void tearDown() {

		driver.quit();

	}

}
