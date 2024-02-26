package stepDefinition;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SearchDDT {

	// step1: create webdriver reference
	String driverPath ="C:\\eclipse workspace\\eclipse_Workspace_3\\RLL_Search_Add_To_Cart\\src\\test\\resources\\drivers\\windows\\chromedriver.exe";
	String siteUrl = "https://www.firstcry.com";
	WebElement searchBox,searchButton;
	WebDriver driver;
	WebDriverWait wait;

	// create xlsx reference
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;

	@BeforeMethod
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", driverPath);
	    driver = new ChromeDriver();
	    driver.get(siteUrl);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	    driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterTest() {
		driver.close();
	}
	
	@Test
	public void searchTest() {

		try {
			// Import xlsx sheet
			File src = new File("src\\test\\resources\\test-data\\Search.xlsx");

			// Load the file as FileInputStream.
			FileInputStream fileInput = new FileInputStream(src);

			// Load the workbook
			workbook = new XSSFWorkbook(fileInput);

			// Load the sheet in which data is stored. (0)
			sheet = workbook.getSheetAt(0);

			for (int row = 1; row < sheet.getLastRowNum(); row++) {
				// import data from cell : product_name
				cell = sheet.getRow(row).getCell(1);
				cell.setCellType(CellType.STRING);
				searchBox=driver.findElement(By.id("search_box"));
				searchBox.click();
				searchBox.sendKeys(cell.getStringCellValue());
				Thread.sleep(4000);
				searchButton=driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div[2]/form/span"));
				searchButton.click();
				Thread.sleep(4000);

				driver.findElement(By.id("search_box")).clear();
				
				
				// Write data in the excel.
				FileOutputStream foutput=new FileOutputStream(src);
				
				// Specify the message needs to be written.
				String message = "Successful Search Test";
				
				//Create cell where data needs to be written.
				sheet.getRow(row).createCell(3).setCellValue(message);
				
				// Specify the file in which data needs to be written.
				FileOutputStream fileOutput =new FileOutputStream(src);
				
				//write content
				workbook.write(fileOutput);
				
				  // close the file
				fileOutput.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}