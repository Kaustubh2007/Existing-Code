package SampleCode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "D:\\SeleniumSoftware\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		WebDriver obj = new FirefoxDriver();
		obj.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		obj.get("http://store.demoqa.com/");
		WebElement element = obj.findElement(By.linkText("Product Category"));
		Actions action = new Actions (obj);
		action.moveToElement(element).build().perform();
		obj.findElement(By.linkText("iPads")).click();
		obj.findElement(By.xpath("//*[@id=\"default_products_page_container\"]/div[3]/div[2]/form/div[2]/div[1]/span/input")).click();
	}

}
