package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static utils.Iconstant.*;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadProperties;

public class BaseClass {

	public WebDriver driver;
	ReadProperties envVar;

	@BeforeSuite
	public void setUpSuit() {
		envVar = new ReadProperties();
	}

	@BeforeMethod
	public void setUpDriver() {
		initDriver(envVar.getProperties(BROWSER));
		initClasses(driver);
		driver.get(envVar.getProperties(URL));
		long pageloadWait = envVar.getNumProperties(PAGELOAD_WAIT);
		long implicitWait = envVar.getNumProperties(IMPLICIT_WAIT);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageloadWait));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));

	}

	private void initDriver(String driverName) {
		switch (driverName) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		}

	}
	
	private void initClasses(WebDriver driver) {
		
	}
	
	@AfterMethod
	public void tearUp() {
		driver.quit();
	}

}
