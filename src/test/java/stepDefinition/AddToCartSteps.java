package stepDefinition;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.io.File;
import java.io.IOException;
 
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddToCartPage;

public class AddToCartSteps {
	String driverPath ="C:\\eclipse workspace\\eclipse_Workspace_3\\RLL_Search_Add_To_Cart\\src\\test\\resources\\drivers\\windows\\chromedriver.exe";
	String siteUrl = "https://www.firstcry.com";
	WebElement searchBox;
	AddToCartPage a;
	static WebDriver driver;
	
	@Given("Open the Firstcry application in chrome Browser")
	public void open_the_firstcry_application_in_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", driverPath);
	    driver = new ChromeDriver();
	    a = PageFactory.initElements(driver, AddToCartPage.class);
	    driver.get(siteUrl);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}

	@Given("Browser should be maximized")
	public void browser_should_be_maximized() {
		driver.manage().window().maximize();
	}

	@When("Search for a product \"([^\"]*)\"$")
	public void search_for_a_product(String productName) throws InterruptedException {
		searchBox=driver.findElement(By.xpath("//*[@id=\"search_box\"]"));
		a.enterSearchText();
		searchBox.sendKeys(productName);
	}

	@Then("Click Search Button")
	public void click_search_button() {
		a.clickSearchButton();
	}
	
	@Then("Click a specific product to view")
	public void click_a_specific_product_to_view() throws InterruptedException {
	    a.ClickSelectedBathTub();
	    a.clickSelectedTricycles();
	    Thread.sleep(2000);
	    takeScreenShot("addtocart-bathtub.png");
	    takeScreenShot("addtocart-tricycles.png");
	}

	@Then("Click AddToCart for a product")
	public void click_add_to_cart_for_a_product() throws InterruptedException {
		a.addCartSelectedBathTub();
	    a.addCartSelectedTricycles();
	    Thread.sleep(2000);
	}

	@Then("Verify the title of the product page \"([^\"]*)\"$")
	public void verify_the_title_of_the_product_page(String pageTitle) {
		assertEquals(pageTitle, driver.getTitle());
		driver.close();
	}
	
	public static void takeScreenShot(String fileName) {
		// 1. type cast driver instance too take screen shot
		TakesScreenshot tsc = (TakesScreenshot) driver ;
		
		// 2. call take screen shot method with file type
		File src = tsc.getScreenshotAs(OutputType.FILE);
		
		// 3. create  file  with screen shot
		try {
			FileHandler.copy(src, new File("screenshot-output\\"+fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
