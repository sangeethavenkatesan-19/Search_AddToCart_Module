package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {

	@FindBy(id="search_box")
	static WebElement searchBar;
	
	@FindBy(xpath="/html/body/div[1]/div[5]/div/div[2]/form/span")
	static WebElement searchButton;
	
	public WebElement enterSearchText() {
		searchBar.click();
		return null;	
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}
}
