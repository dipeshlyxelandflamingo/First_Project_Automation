package Youfoodlabs.Youfoodlabs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Homepage_Tab {
	
	WebDriver driver;
	FileInputStream file;
	FileOutputStream fileOut;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	DataFormatter formate;

	// new changes homepage tab
	
	
	@BeforeTest(description = "openbrowser")
	void openbrowser() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://yufoodsco.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		file = new FileInputStream("C:\\Users\\LYXELANDFLAMINGO\\Desktop\\Maintence Project\\Yufoodlabs.xlsx");
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet("Homepage_Tab");
		formate = new DataFormatter();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@class='js-popup-close newsletter__popup-container-close']")));
		popup.click();

	}

	@Test(description = "click on shop Tab")
	void TC_01() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions ac = new Actions(driver);

		try {
			WebElement shop = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//a[@class='header__nav__link dlink first-level js-open-dropdown-on-key'])[1]")));

			String[] imageLocators = { "//img[@src='//yufoodsco.com/cdn/shop/files/Noodles-min_450x.jpg?v=1721034501']",
					"//img[@src='//yufoodsco.com/cdn/shop/files/Pasta_540_x_550_-min_450x.jpg?v=1721034543']",
					"//img[@src='//yufoodsco.com/cdn/shop/files/100_-Fruit-Juice_450x.jpg?v=1721191997']",
					"//img[@src='//yufoodsco.com/cdn/shop/files/Instant_Mixes_540_x_550_-min_450x.jpg?v=1721034586']",
					"//img[@src='//yufoodsco.com/cdn/shop/files/instant-mix_450x.jpg?v=1721205321']" };

			for (String imageLocator : imageLocators) {
				ac.moveToElement(shop).perform();
				driver.findElement(By.xpath(imageLocator)).click();
				driver.navigate().back();
			}
			sheet.getRow(1).createCell(3).setCellValue("Open all Products_link");
			sheet.getRow(1).createCell(4).setCellValue("PASS");
		} catch (Exception e) {
			sheet.getRow(1).createCell(4).setCellValue("FAIL");

		}

	}

	@Test(description = "click on shop Tab")
	void TC_02() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions ac = new Actions(driver);

		try {
			WebElement shop = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//a[@class='header__nav__link dlink first-level js-open-dropdown-on-key'])[1]")));

			String[] list = { "(//a[@href='/collections/noodle-bowls'])[2]", "(//a[@href='/collections/pasta'])[2]",
					"(//a[@href='/collections/beverages'])[2]", "(//a[@href='/collections/instant-mixes'])[3]",
					"(//a[@href='/collections/combos'])[3]" };

			for (String lists : list) {
				ac.moveToElement(shop).perform();
				driver.findElement(By.xpath(lists)).click();
				driver.navigate().back();
			}

			sheet.getRow(2).createCell(3).setCellValue("Open all Products_link");
			sheet.getRow(2).createCell(4).setCellValue("PASS");
		} catch (Exception e) {
			sheet.getRow(2).createCell(4).setCellValue("FAIL");

		}
	}

	@Test(description = "click on About Us")
	void TC_03() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			WebElement aboutus = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='/pages/about'])[2]")));
			aboutus.click();

			driver.navigate().back();
			sheet.getRow(3).createCell(3).setCellValue("click on about us");
			sheet.getRow(3).createCell(4).setCellValue("PASS");
		} catch (Exception e) {
			sheet.getRow(3).createCell(4).setCellValue("FAIL");

		}

	}

	@Test(description = "click on our Beginning")
	void TC_04() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			WebElement aboutus = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='/pages/our-beginning'])[2]")));
			aboutus.click();

			driver.navigate().back();
			sheet.getRow(4).createCell(3).setCellValue("click on our Beginning");
			sheet.getRow(4).createCell(4).setCellValue("PASS");
		} catch (Exception e) {
			sheet.getRow(4).createCell(4).setCellValue("FAIL");

		}

	}

	@AfterTest
	void Complete_Test() throws Exception {
		try {
			fileOut = new FileOutputStream("C:\\Users\\LYXELANDFLAMINGO\\Desktop\\Maintence Project\\Yufoodlabs.xlsx");
			workbook.write(fileOut);
		} finally {
			workbook.close();
			file.close();
		}
		driver.quit();
	}

}
