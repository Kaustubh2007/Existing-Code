package SampleCode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Practice1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String baseUrl = "http://demo.guru99.com/test/newtours/";
		System.setProperty("webdriver.gecko.driver", "D:\\SeleniumSoftware\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		//System.setProperty("webdriver.firefox.marionette", "D:\\SeleniumSoftware\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		WebDriver obj = new FirefoxDriver();
		obj.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		obj.get(baseUrl);
		WebElement link_Home = obj.findElement(By.linkText("Home"));
		WebElement td_Home = obj.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td[2]"));
		Actions builder = new Actions(obj);
		Action mouseOverHome  = builder.moveToElement(link_Home).build();
		String bgColor = td_Home.getCssValue("background-color");
		System.out.println("Before hover: " + bgColor);  
		mouseOverHome.perform();        
        bgColor = td_Home.getCssValue("background-color");
        System.out.println("After hover: " + bgColor);
      
	}

}
