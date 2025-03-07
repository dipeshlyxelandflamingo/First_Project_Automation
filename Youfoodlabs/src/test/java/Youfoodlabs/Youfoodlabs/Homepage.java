package Youfoodlabs.Youfoodlabs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Homepage {

	WebDriver driver;
	FileInputStream file;
	FileOutputStream fileOut;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	DataFormatter formatter;
	
	// new changes homepage  // after changes 
	
	// changes 
	
	

	@BeforeTest(description = "openbrowser")
	void LaunchBrowser() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://yufoodsco.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		file = new FileInputStream("C:\\Users\\LYXELANDFLAMINGO\\Desktop\\Maintence Project\\Yufoodlabs.xlsx");
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet("Homepage");
		formatter = new DataFormatter();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@class='js-popup-close newsletter__popup-container-close']")));
		popup.click();
	}

	@Test(description = "click on shop our Range & navigate Back")
	void TC_01() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,500)", "");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			WebElement noodles = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@id='1617612701873']")));
			noodles.click();
			js.executeScript("scroll(0,500)", "");
			driver.navigate().back();

			WebElement Pasta = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@id='1637328126129']")));
			Pasta.click();
			js.executeScript("scroll(0,500)", "");
			driver.navigate().back();

			WebElement Fruitjuices = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@id='1637328093361']")));
			Fruitjuices.click();
			js.executeScript("scroll(0,500)", "");
			driver.navigate().back();

			WebElement Instantmix = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@id='1637328060593']")));
			Instantmix.click();
			js.executeScript("scroll(0,500)", "");
			driver.navigate().back();
			sheet.getRow(1).createCell(3).setCellValue("Open All category on Click");
			sheet.getRow(1).createCell(4).setCellValue("PASS");

		} catch (Exception e) {

			sheet.getRow(1).createCell(4).setCellValue("FAIL");
		}
	}

	@Test(description = "click on whats trending")
	void TC_02() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,500)", "");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			WebElement korean_red_hot_cheez = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@id='28718783168689']")));
			korean_red_hot_cheez.click();
			driver.navigate().back();

			WebElement pink_saur_pasta = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@id='28718783856817']")));
			pink_saur_pasta.click();
			driver.navigate().back();

			WebElement whole_wheat_noodles = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@id='28725640298673']")));
			whole_wheat_noodles.click();
			driver.navigate().back();

			WebElement chilli_chicken_noodles = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@id='28719380168881']")));
			chilli_chicken_noodles.click();
			driver.navigate().back();
			sheet.getRow(2).createCell(3).setCellValue("Open All category on Click");
			sheet.getRow(2).createCell(4).setCellValue("PASS");

		} catch (Exception e) {

			sheet.getRow(2).createCell(4).setCellValue("FAIL");
		}

	}

	@Test(description = "click on Yu Got Featured")
	void TC_03() throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,1400)", "");
		String originalTab = driver.getWindowHandle();

		try {
			// Array of XPath expressions for each element to be clicked
			String[] xpaths = { "//img[@src='//yufoodsco.com/cdn/shop/files/ET_Now.png?v=1669360869']",
					"//img[@src='//yufoodsco.com/cdn/shop/files/livemint-logo-vector_1.png?v=1641214343']",
					"//img[@src='//yufoodsco.com/cdn/shop/files/Outlook_Business.png?v=1669360941']",
					" //img[@src='//yufoodsco.com/cdn/shop/files/download_1.png?v=1641214343']",
					"//img[@src='//yufoodsco.com/cdn/shop/files/CNBC_TV_18.png?v=1669361015']",
					"//img[@src='//yufoodsco.com/cdn/shop/files/business-standard-logo.png?v=1641214343']",
					"//img[@src='//yufoodsco.com/cdn/shop/files/fi-newlogo.jpg?v=1645182841']",
					"//img[@src='//yufoodsco.com/cdn/shop/files/images_3.png?v=1721648655']",
					"//img[@src='//yufoodsco.com/cdn/shop/files/YourStory-Logo.png?v=1721648198']" };

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			for (String xpath : xpaths) {
				// Find the element and click it
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
				Thread.sleep(2000);
				element.click();

				// Switch to the new tab
				for (String windowHandle : driver.getWindowHandles()) {
					if (!windowHandle.equals(originalTab)) {
						driver.switchTo().window(windowHandle);
						break;
					}
				}

				// Close the new tab and switch back to the original tab
				driver.close();
				driver.switchTo().window(originalTab);
			}

			sheet.getRow(3).createCell(3).setCellValue("Open All category on Click");
			sheet.getRow(3).createCell(4).setCellValue("PASS");
		} catch (Exception e) {

			sheet.getRow(3).createCell(4).setCellValue("FAIL");
		}
	}

	@Test(description = "click on Footer's Quick Links")
	void TC_04() throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,500)", "");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			WebElement aboutus = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='/pages/about'])[3]")));
			aboutus.click();

			WebElement contact = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='/pages/contact'])[1]")));
			contact.click();

			WebElement term_condition = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//a[@href='/pages/privacy-t-c-refund-shipping-policy'])[1]")));
			term_condition.click();

			WebElement termOfService = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/policies/refund-policy']")));
			termOfService.click();

			WebElement Refundpolicy = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/policies/terms-of-service']")));
			Refundpolicy.click();

			sheet.getRow(4).createCell(3).setCellValue("Open All link in footer");
			sheet.getRow(4).createCell(4).setCellValue("PASS");
		} catch (Exception e) {

			sheet.getRow(3).createCell(4).setCellValue("FAIL");
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
