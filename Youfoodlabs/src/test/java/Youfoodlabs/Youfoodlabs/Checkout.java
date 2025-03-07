package Youfoodlabs.Youfoodlabs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkout {

	 WebDriver driver;
	    FileInputStream file;
	    FileOutputStream fileOut;
	    XSSFWorkbook workbook;
	    XSSFSheet sheet;
	    DataFormatter formatter;

	    @BeforeTest(description = "openbrowser")
	    void Openbrowser() throws Exception {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.get("https://yufoodsco.com/collections/fruit-juices-100-natural");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        file = new FileInputStream("C:\\Users\\LYXELANDFLAMINGO\\Desktop\\Maintence Project\\Yufoodlabs.xlsx");
	        workbook = new XSSFWorkbook(file);
	        sheet = workbook.getSheet("Checkout Page");
	        formatter = new DataFormatter();

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//a[@class='js-popup-close newsletter__popup-container-close']")));
	        popup.click();
	    }

	    @Test(description = "Add product in Cart")
	    void TC_01() {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement addtocart = wait
	                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='addToCart'])[2]")));
	            addtocart.click();

	            sheet.getRow(1).createCell(3).setCellValue("Product added to cart successfully");
	            sheet.getRow(1).createCell(4).setCellValue("PASS");
	        } catch (Exception e) {
	            sheet.getRow(1).createCell(4).setCellValue("FAIL");
	        }
	    }

	    @Test(description = "click on checkout button from minicart")
	    void TC_02() {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement checkout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
	            checkout.click();

	            sheet.getRow(2).createCell(3).setCellValue("Checkout button clicked successfully");
	            sheet.getRow(2).createCell(4).setCellValue("PASS");
	        } catch (Exception e) {
	            sheet.getRow(2).createCell(4).setCellValue("FAIL");
	        }
	    }

	    @Test(description = "Add contact Email")
	    void TC_03() {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement addemail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
	            addemail.sendKeys("dipesh@yopmail.com");

	            sheet.getRow(3).createCell(3).setCellValue("Email added successfully");
	            sheet.getRow(3).createCell(4).setCellValue("PASS");
	        } catch (Exception e) {
	            sheet.getRow(3).createCell(4).setCellValue("FAIL");
	        }
	    }

	    @Test(description = "Add delivery Detail")
	    void TC_04() {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement fname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
	            fname.sendKeys("Dipesh");

	            WebElement lname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastName")));
	            lname.sendKeys("Sing");

	            Actions ac = new Actions(driver);
	            WebElement Address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipping-address1")));
	            Address.sendKeys("supertech");
	            WebElement Address1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	                    "//span[@aria-label='SUPERTECH ECO VILLAGE-1, Sector 1, Bisrakh Jalalpur, Greater Noida, Uttar Pradesh']")));
	            Thread.sleep(2000);
	            ac.moveToElement(Address1).sendKeys(Keys.ENTER).perform();

	            WebElement mobile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("phone")));
	            mobile.sendKeys("6354899395");

	            sheet.getRow(4).createCell(3).setCellValue("Delivery details added successfully");
	            sheet.getRow(4).createCell(4).setCellValue("PASS");
	        } catch (Exception e) {
	            sheet.getRow(4).createCell(4).setCellValue("FAIL");
	        }
	    }

	    @Test(description = "click on Paynow button")
	    void TC_05() {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement paynow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-pay-button")));
	            paynow.click();

	            sheet.getRow(5).createCell(3).setCellValue("Pay now button clicked successfully");
	            sheet.getRow(5).createCell(4).setCellValue("PASS");
	        } catch (Exception e) {
	            sheet.getRow(5).createCell(4).setCellValue("FAIL");
	        }
	    }

	    @Test(description = "confirm the payment page")
	    void TC_06() {
	        SoftAssert softAssert = new SoftAssert();
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement iframeElement = wait.until(
	                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='razorpay-checkout-frame']")));
	            driver.switchTo().frame(iframeElement);

	            WebElement paymentPageElement = wait.until(ExpectedConditions
	                    .visibilityOfElementLocated(By.xpath("//div[@class='flex grow justify-end gap-2 py-2']")));
	            softAssert.assertTrue(paymentPageElement.isDisplayed(), "Payment page is not visible");

	            sheet.getRow(6).createCell(3).setCellValue("Payment page displayed successfully");
	            sheet.getRow(6).createCell(4).setCellValue("PASS");
	        } catch (Exception e) {
	            sheet.getRow(6).createCell(4).setCellValue("FAIL");
	        }
	        softAssert.assertAll();
	    }

	    @AfterTest
	    void closebrowser() throws Exception {
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