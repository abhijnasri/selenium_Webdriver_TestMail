package selenium.email;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class baseClass {
	WebDriver driver;
	protected configurations configuration = new configurations();
	String url = configurations.link;

	@BeforeMethod
	public void setupApplication() throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.get(url);
		Reporter.log("===Application started===", true);
	}
	
	@AfterMethod
	public void closedriver() {
		driver.quit();
		Reporter.log("====browser session end====", true);
	}

	
		
	}

