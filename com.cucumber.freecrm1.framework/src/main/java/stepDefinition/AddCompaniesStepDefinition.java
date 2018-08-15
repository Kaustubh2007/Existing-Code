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

public class AddCompaniesStepDefinition {

	WebDriver driver = null;

	@Given("^User is on Login Page$")
	public void user_is_on_Login_Page()  {

		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumSoftware\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.freecrm.com");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("#1 Free CRM software in the cloud for sales and service", title);
	}

	@When("^User enters \"([^\"]*)\" & \"([^\"]*)\"$")
	public void user_enters(String username, String password)  {

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
	}

	@Then("^User clicks on Login button$")
	public void user_clicks_on_Login_button()  {

		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);
	}

	@And("^User lands on Home Page$")
	public void user_lands_on_Home_Page()  {

		String title1 = driver.getTitle();
		System.out.println(title1);
		Assert.assertEquals("CRMPRO", title1);
	}

	@Then("^User navigates to add New Company page$")
	public void user_navigates_to_add_New_Company_page() throws InterruptedException  {

		driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@title='Companies']"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(), 'New Company')]")).click();
		Thread.sleep(10000);
	}

	@Then("^User enters company details as \"([^\"]*)\" & \"([^\"]*)\" & \"([^\"]*)\" & \"([^\"]*)\" & \"([^\"]*)\"$")
	public void user_enters_company_details_as(String company, String industry, String revenue, String phone, String address) throws InterruptedException  {

		driver.findElement(By.xpath("//input[@id='company_name']")).sendKeys(company);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='industry']")).sendKeys(industry);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='annual_revenue']")).sendKeys(revenue);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phone);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys(address);
		Thread.sleep(2000);
	}

	@Then("^User saves company details$")
	public void user_saves_company_details() throws InterruptedException  {

		driver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).click();
		Thread.sleep(10000);
	}

	@Then("^User clicks on LogOut button$")
	public void user_clicks_on_LogOut_button() throws InterruptedException  {

		/*driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@href='https://www.freecrm.com/index.cfm?logout=1']"))).build().perform();
		Thread.sleep(5000);*/

		driver.findElement(By.xpath("//a[@href='https://www.freecrm.com/index.cfm?logout=1']")).click();
	}

	@Then("^User closes browser$")
	public void user_closes_browser()  {

		driver.quit();
	}


}
