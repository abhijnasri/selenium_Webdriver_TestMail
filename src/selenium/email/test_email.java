package selenium.email;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
public class test_email extends baseClass{
	
	protected configurations configuration = new configurations();
		
	@Test
	public void sendMail() throws InterruptedException, IOException {
		Properties loc = new Properties();
		FileInputStream fr = new FileInputStream("C:\\Users\\UC501790\\eclipse-workspace\\chezuba\\properties\\locators.properties");
		loc.load(fr);
		WebElement mail_id = driver.findElement(By.id(loc.getProperty("emailid")));
		mail_id.sendKeys(configurations.email);
		
		WebElement next_button = driver.findElement(By.xpath(loc.getProperty("next1")));
		next_button.click();
		Thread.sleep(10000);
		
		WebElement nextbutton = driver.findElement(By.xpath(loc.getProperty("next2")));
		nextbutton.click();
		Thread.sleep(3000);
		
		WebElement password = driver.findElement(By.name(loc.getProperty("password")));
		password.sendKeys(configurations.pwd);
		
		WebElement nextbutton3 = driver.findElement(By.xpath(loc.getProperty("next3")));
		nextbutton3.click();
		Thread.sleep(3000);
		
		WebElement compose = driver.findElement(By.xpath(loc.getProperty("compose")));
		
		compose.click();
		
		WebElement to = driver.findElement(By.name(loc.getProperty("toField")));
		to.sendKeys(configurations.email);
		
		WebElement sub = driver.findElement(By.name(loc.getProperty("subjectField")));
		sub.sendKeys(configurations.subject);
		Thread.sleep(3000);
		
		WebElement body = driver.findElement(By.xpath(loc.getProperty("body")));
		body.sendKeys(configurations.body_text);
		
		
		WebElement label = driver.findElement(By.xpath(loc.getProperty("label")));
		label.click();
		Thread.sleep(3000);
		
		WebElement label_action = driver.findElement(By.xpath(loc.getProperty("labelAction")));
		label_action.click();
		Thread.sleep(3000);
		
		WebElement social = driver.findElement(By.xpath(loc.getProperty("social")));
		social.click();
		
		Thread.sleep(3000);
		WebElement send = driver.findElement(By.xpath(loc.getProperty("sendButton")));
		send.click();
		
		//System.out.println("mail sent");
		driver.findElement(By.xpath(loc.getProperty("socialTab"))).click();
		Thread.sleep(5000);
		
		WebElement star = driver.findElement(By.xpath(loc.getProperty("star")));
		star.click();
		Thread.sleep(5000);
		
		WebElement open_mail = driver.findElement(By.xpath(loc.getProperty("openMail")));
		open_mail.click();
		
		
		//verify subject
		WebElement exp = driver.findElement(By.className("hP"));
		String expected = exp.getText();
		String actual = "Test Mail";
	
		Assert.assertEquals(actual, expected);
		Reporter.log("===test done===", true);
			
	}
	


}
