package SampleCode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Practice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String baseUrl = "https://www.facebook.com/";
		System.setProperty("webdriver.gecko.driver", "D:\\SeleniumSoftware\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		//System.setProperty("webdriver.firefox.marionette", "D:\\SeleniumSoftware\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		WebDriver obj = new FirefoxDriver();
		obj.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		obj.get(baseUrl);
		WebElement txtusername = obj.findElement(By.id("email"));
		Actions builder = new Actions(obj);
		Action seriesOfActions = builder.moveToElement(txtusername).click().keyDown(txtusername, Keys.SHIFT).sendKeys(txtusername, "hello").keyUp(txtusername, Keys.SHIFT).doubleClick(txtusername).contextClick().build();
		seriesOfActions.perform();

	}

}
