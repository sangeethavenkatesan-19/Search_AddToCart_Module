package stepDefinition;

import java.time.Duration;
import java.io.File;
import java.io.IOException;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import pages.FilterCartPage;

public class FilterCartSteps {
	String driverPath ="C:\\eclipse workspace\\eclipse_Workspace_3\\RLL_Search_Add_To_Cart\\src\\test\\resources\\drivers\\windows\\chromedriver.exe";
	String siteUrl = "https://www.firstcry.com";
	WebElement searchBox;
	FilterCartPage a;
	static WebDriver driver;
	
	@Given("Open the ChromeBrowser and launch application")
	public void open_the_chrome_browser_and_launch_application() {
		System.setProperty("webdriver.chrome.driver", driverPath);
	    driver = new ChromeDriver();
	    a = PageFactory.initElements(driver, FilterCartPage.class);
	    driver.get(siteUrl);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}

	@Given("Maximize the browser")
	public void maximize_the_browser() {
		driver.manage().window().maximize();
	}
	
	@When("The pages loades click any one category from homepage")
	public void the_pages_loades_click_any_one_category_from_homepage() throws InterruptedException {
		 a.ClickSelectedMenuButton();
		 Thread.sleep(2000);
	}

	@Then("Move to the redirected page and scroll down to view products")
	public void move_to_the_redirected_page_and_scroll_down_to_view_products() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll down by 500 pixels
        js.executeScript("window.scrollBy(0,500)");
	}

	@When("apply filters according to your requirements")
	public void apply_filters_according_to_your_requirements() throws InterruptedException {
		a.clickSelectedDiscountFilter();
		a.clickSelectedBrands();
		Thread.sleep(8000);
		takeScreenShot("filters-advancesearch.png");
	}

	@When("select a product and add to cart")
	public void select_a_product_and_add_to_cart() throws InterruptedException {
		a.ClickSelectedToy();
		a.addToCartSelectedToy();
		Thread.sleep(8000);
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
