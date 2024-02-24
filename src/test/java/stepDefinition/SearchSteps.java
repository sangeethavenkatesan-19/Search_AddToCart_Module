package stepDefinition;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;
import pages.SearchPage;

public class SearchSteps {
	String driverPath ="C:\\eclipse workspace\\eclipse_Workspace_3\\RLL_Search_Add_To_Cart\\src\\test\\resources\\drivers\\windows\\chromedriver.exe";
	String siteUrl = "https://www.firstcry.com";
	WebElement searchBox;
	SearchPage p;
	WebDriver driver;
	
	@Given("^Open the Chrome and launch Firstcry application$")
	public void open_the_chrome_and_launch_firstcry_application() {
		System.setProperty("webdriver.chrome.driver", driverPath);
	    driver = new ChromeDriver();
	    p = PageFactory.initElements(driver, SearchPage.class);
	    driver.get(siteUrl);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}

	@Given("Maximize the Chrome browser window")
	public void maximize_the_chrome_browser_window() {
		driver.manage().window().maximize();
	}

	@When("^Enter the Product that has to be searched \"([^\"]*)\"$")
	public void enter_the_product_that_has_to_be_searched(String productName) throws InterruptedException {
		searchBox=driver.findElement(By.xpath("//*[@id=\"search_box\"]"));
		p.enterSearchText();
		searchBox.sendKeys(productName);
	}

	@Then("^Click the Search button$")
	public void click_the_search_button() {
		p.clickSearchButton();
	}

	@Then("^Verify the title \"([^\"]*)\"$")
	public void verify_the_title(String pageTitle) {
		assertEquals(pageTitle, driver.getTitle());
		driver.close();
	} 
}