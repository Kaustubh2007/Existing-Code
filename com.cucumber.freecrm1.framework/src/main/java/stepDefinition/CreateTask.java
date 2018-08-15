package stepDefinition;

import java.util.List;

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

public class CreateTask {

	WebDriver driver = null;

	@Given("^User in on Free CRM login Page$")
	public void user_in_on_Free_CRM_login_Page()  {

		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumSoftware\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.freecrm.com");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("#1 Free CRM software in the cloud for sales and service", title);
	}

	/*@When("^User enters credentials as \"([^\"]*)\" & \"([^\"]*)\"$")
	public void user_enters_credentials_as(DataTable credentials)  {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)
		List<List<String>> data = credentials.raw();
		driver.findElement(By.name("username")).sendKeys(data.get(0).get(0));
		driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));

	}
*/	
	@When("^User enters credentials as username & password$")
	public void user_enters_credentials_as_username_password(DataTable credentials)  {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		List<List<String>> data = credentials.raw();
		driver.findElement(By.name("username")).sendKeys(data.get(0).get(0));
		driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
	}

	@Then("^User clicks the login button$")
	public void user_clicks_the_login_button() {

		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js  = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);
	}

	@And("^User lands on Free CRM Home Page$")
	public void user_lands_on_Free_CRM_Home_Page()  {

		String title1 = driver.getTitle();
		System.out.println(title1);
		Assert.assertEquals("CRMPRO", title1);
	}

	@Then("^User navigates to New Task page$")
	public void user_navigates_to_New_Task_page() throws InterruptedException  {

		driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(), 'Tasks')]"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(), 'New Task')]")).click();
		Thread.sleep(10000);
	}

/*	@And("^User enters task details as \"([^\"]*)\" & \"([^\"]*)\" & \"([^\"]*)\" & \"([^\"]*)\" & \"([^\"]*)\"$")
	public void user_enters_task_details_as(DataTable taskdata) throws InterruptedException  {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)

		List<List<String>> data1 = taskdata.raw();
		driver.findElement(By.xpath("//input[@id='title']")).sendKeys(data1.get(0).get(0));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='completion']")).sendKeys(data1.get(0).get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='prospect_lookup']")).sendKeys(data1.get(0).get(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='case_lookup']")).sendKeys(data1.get(0).get(3));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='identifier']")).sendKeys(data1.get(0).get(4));
		Thread.sleep(2000);
	}*/
	
	@And("^User enters task details as title & completion & deal & case & identifier$")
	public void user_enters_task_details_as_title_completion_deal_case_identifier(DataTable taskdata) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	    
		List<List<String>> data1 = taskdata.raw();
		driver.findElement(By.xpath("//input[@id='title']")).sendKeys(data1.get(0).get(0));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='completion']")).sendKeys(data1.get(0).get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='prospect_lookup']")).sendKeys(data1.get(0).get(2));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='case_lookup']")).sendKeys(data1.get(0).get(3));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='identifier']")).sendKeys(data1.get(0).get(4));
		Thread.sleep(2000);
	}

	@Then("^User selects other task details as status,type & priority$")
	public void user_selects_other_task_details_as_status_type_priority() throws InterruptedException  {

		driver.findElement(By.xpath("//option[@value='Complete']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[@value='Delivery']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[@value='Low']")).click();
	}

	@Then("^User saves the task$")
	public void user_saves_the_task() throws InterruptedException  {

		driver.findElement(By.xpath("//input[@type='submit' and @value='Save' and @class='button']")).click();
		Thread.sleep(10000);
	}

	@Then("^User logs out of the Free CRM application$")
	public void user_logs_out_of_the_Free_CRM_application()  {

		driver.findElement(By.xpath("//a[@href='https://www.freecrm.com/index.cfm?logout=1']")).click();
	}

	@Then("^User closed browser$")
	public void user_closed_browser()  {

		driver.quit();
	}


}
