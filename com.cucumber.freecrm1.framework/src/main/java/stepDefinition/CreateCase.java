package stepDefinition;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class CreateCase {

	WebDriver driver = null;

	@Given("^User is already on Free CRM Login Page$")
	public void user_is_already_on_Free_CRM_Login_Page()  {

		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumSoftware\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.freecrm.com");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("#1 Free CRM software in the cloud for sales and service", title);
	}

	@When("^User enters username & password$")
	public void user_enters_username_password(DataTable credentials) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)
		for  (Map <String, String> data :  credentials.asMaps(String.class, String.class)) {

			driver.findElement(By.name("username")).sendKeys(data.get("username"));
			driver.findElement(By.name("password")).sendKeys(data.get("password"));
		}
	}

	@Then("^User logs into the application$")
	public void user_logs_into_the_application()  {

		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginBtn);
	}

	@And("^User lands on Free CRM login page$")
	public void user_lands_on_Free_CRM_login_page()  {

		String title1 = driver.getTitle();
		System.out.println(title1);
		Assert.assertEquals("CRMPRO", title1);
	}

	@Then("^User navigates to create New Case page$")
	public void user_navigates_to_create_New_Case_page() throws InterruptedException {

		driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(), 'Cases')]"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(), 'New Case')]")).click();
		Thread.sleep(10000);
	}

	@And("^User enters case details as title & identifier & contact$")
	public void user_enters_case_details_as_title_identifier_contact(DataTable casedetails) throws InterruptedException  {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)

		for (Map <String, String> data1 : casedetails.asMaps(String.class, String.class)) {

			driver.findElement(By.xpath("//input[@name='title']")).sendKeys(data1.get("title"));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='identifier']")).sendKeys(data1.get("identifier"));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='contact_lookup']")).sendKeys(data1.get("contact"));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit' and @value='Save' and @class='button']")).click();
			Thread.sleep(5000);
			/*Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//a[contains(text(), 'Cases')]"))).build().perform();
			Thread.sleep(10000);*/
		}
	}

	/*@Then("^User selects other case details as status & type & priority$")
	public void user_selects_other_case_details_as_status_type_priority() throws InterruptedException  {

		driver.findElement(By.xpath("//option[@value='Enquiring']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[@value='Customer Support']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[@value='Normal']")).click();
		Thread.sleep(2000);
		
		
	}

	 @Then("^User saves the case$")
	public void user_saves_the_case() throws InterruptedException  {

		driver.findElement(By.xpath("//input[@type='submit' and @value='Save' and @class='button']")).click();
		Thread.sleep(10000);
	}*/

	@Then("^User logs out of the CRM application$")
	public void user_logs_out_of_the_CRM_application() throws InterruptedException  {

		driver.findElement(By.xpath("//a[@href='https://www.freecrm.com/index.cfm?logout=1']")).click();
		Thread.sleep(3000);
	}

	@Then("^User quites the browser$")
	public void user_quites_the_browser() {

		driver.quit();
	}



}
