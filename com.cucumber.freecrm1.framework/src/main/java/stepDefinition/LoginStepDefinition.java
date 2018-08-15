package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginStepDefinition {

	WebDriver driver = null;

	@Given("^User is already on Free CRM login Page$")
	public void user_is_already_on_Free_CRM_login_Page()  {

		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumSoftware\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.freecrm.com");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("#1 Free CRM software in the cloud for sales and service", title);
	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String username, String password)  {

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
	}

	@And("^User clicks on login button$")
	public void user_clicks_on_login_button() throws InterruptedException  {

		//driver.findElement(By.xpath("//input[@type='submit' and  @value='Login']")).click();
		//Actions action = new Actions(driver);
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginBtn);	
		Thread.sleep(10000);

	}

	@Then("^User is on Home Page$")
	public void user_is_on_Home_Page() throws InterruptedException  {

		String title1 = driver.getTitle();
		System.out.println(title1);
		Assert.assertEquals("CRMPRO", title1);
		Thread.sleep(10000);

	}

	@Then("^User logs out of the application$")
	public void user_logs_out_of_the_application() throws InterruptedException  {

		/*driver.findElement(By.xpath("//a[@href='https://www.freecrm.com/index.cfm?logout=1']")).click();
		driver.findElement(By.xpath("//a[@href='https://www.freecrm.com/index.cfm?logout=1']")).click();
		driver.findElement(By.xpath("//i[@class='fa fa-sign-out icon-2x']")).click();
		WebElement  logoutBtn =  driver.findElement(By.xpath("//i[@class='fa fa-sign-out icon-2x']")); 
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("argument[0].click();", logoutBtn);
		Thread.sleep(10000);*/
		driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@href='https://www.freecrm.com/index.cfm?logout=1']"))).build().perform();
		Thread.sleep(10000);
	}

	@Then("^User closes the browser$")
	public void user_closes_the_browser()  {

		driver.quit();
	}

}
