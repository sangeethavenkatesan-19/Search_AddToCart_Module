package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterCartPage {
	@FindBy(xpath="/html/body/div[1]/div[8]/div/div/div[1]/ul/li[5]/a")
	static WebElement selectMenuButton;//toys
	
	@FindBy(xpath="//*[@id=\"fltdisc\"]/div[2]/div[2]/ul/li[1]/a/div/span[1]")
	static WebElement selectDiscountFilter;
	
	@FindBy(xpath="//*[@id=\"fltbrnd\"]/div[2]/div[2]/ul/li[1]/a/div/span[1]")
	static WebElement selectBrands;
	
	@FindBy(xpath="//*[@id=\"maindiv\"]/div[1]/div/div[1]/div[2]/a")
	static WebElement selectProduct;
	
	@FindBy(xpath="/html/body/div[5]/div[2]/div/div[2]/div[5]/div/div[2]/div[2]/div[1]/div/span[1]")
	static WebElement addToCartToy;
	
	public void ClickSelectedMenuButton() {
		selectMenuButton.click();	
	}
	
	public void clickSelectedDiscountFilter() {
		selectDiscountFilter.click();
	}
	
	public void clickSelectedBrands() {
		selectBrands.click();	
	}

	public void ClickSelectedToy() {
		selectProduct.click();
	}
	
	public void addToCartSelectedToy() {
		addToCartToy.click();
	}
}
