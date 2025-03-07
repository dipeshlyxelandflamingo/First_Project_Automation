package Youfoodlabs.Youfoodlabs;

import java.io.FileInputStream;
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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CartPage {

	 WebDriver driver;
	    FileInputStream file;
	    FileOutputStream fileOut;
	    XSSFWorkbook workbook;
	    XSSFSheet sheet;
	    DataFormatter formatter;

	    @BeforeTest
	    void openBrowser() throws Exception {
	        // Initialize WebDriver
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.get("https://yufoodsco.com/collections/noodle-bowls/products/veg-hakka-noodles-pack-of-3");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        file = new FileInputStream("C:\\Users\\LYXELANDFLAMINGO\\Desktop\\Maintence Project\\Yufoodlabs.xlsx");
	        workbook = new XSSFWorkbook(file);
	        sheet = workbook.getSheet("Cart Page");
	        formatter = new DataFormatter();
	    }

	    // Add product into cart and close popup
	    @Test
	    void TC_01() {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement Close_popup = wait.until(ExpectedConditions
	                    .elementToBeClickable(By.xpath("//a[@class='js-popup-close newsletter__popup-container-close']")));
	            Close_popup.click();

	            WebElement clickAddToCart = wait.until(
	                    ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='product-add add-pro-cart']")));
	            clickAddToCart.click();

	            sheet.getRow(1).createCell(3).setCellValue("Product added to cart successfully");
	            sheet.getRow(1).createCell(4).setCellValue("PASS");
	        } catch (Exception e) {
	            sheet.getRow(1).createCell(3).setCellValue("Failed to add product to cart");
	            sheet.getRow(1).createCell(4).setCellValue("FAIL");
	        }
	    }

	    // Increase the qty of product on mini cart
	    @Test
	    void TC_02() {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement minicart = wait
	                    .until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='+'])[1]")));
	            minicart.click();
	            Thread.sleep(5000);

	            sheet.getRow(2).createCell(3).setCellValue("Quantity increased successfully");
	            sheet.getRow(2).createCell(4).setCellValue("PASS");
	        } catch (Exception e) {
	            sheet.getRow(2).createCell(3).setCellValue("Failed to increase quantity");
	            sheet.getRow(2).createCell(4).setCellValue("FAIL");
	        }
	    }

	    // Click On View Cart on Mini Cart to Open Cart Page
	    @Test
	    void TC_03() {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement viewCart = wait.until(ExpectedConditions.elementToBeClickable(
	                    By.xpath("//a[@class='ajax-cart__button-view_cart button secondary-button']")));
	            viewCart.click();
	            Thread.sleep(5000);

	            sheet.getRow(3).createCell(3).setCellValue("View Cart button clicked successfully");
	            sheet.getRow(3).createCell(4).setCellValue("PASS");
	        } catch (Exception e) {
	            sheet.getRow(3).createCell(3).setCellValue("Failed to click View Cart button");
	            sheet.getRow(3).createCell(4).setCellValue("FAIL");
	        }
	    }

	    // Add note
	    @Test
	    void TC_04() {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement Addnote = wait
	                    .until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='closed'])[1]")));
	            Addnote.click();

	            WebElement update_text = wait.until(ExpectedConditions.elementToBeClickable(By.id("note")));
	            update_text.click();
	            update_text.sendKeys("Pack Food Properly");
	            Thread.sleep(3000);

	            sheet.getRow(4).createCell(3).setCellValue("Note added successfully");
	            sheet.getRow(4).createCell(4).setCellValue("PASS");
	        } catch (Exception e) {
	            sheet.getRow(4).createCell(3).setCellValue("Failed to add note");
	            sheet.getRow(4).createCell(4).setCellValue("FAIL");
	        }
	    }

	    // Click on checkout to redirect checkout page
	    @Test
	    void TC_05() {
	        try {
	            Thread.sleep(3000);
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("scroll(0,1000)");
	            Thread.sleep(3000);
	            driver.findElement(By.id("checkout")).click();
	            Thread.sleep(3000);

	            sheet.getRow(5).createCell(3).setCellValue("Redirected to checkout page successfully");
	            sheet.getRow(5).createCell(4).setCellValue("PASS");
	        } catch (Exception e) {
	            sheet.getRow(5).createCell(3).setCellValue("Failed to redirect to checkout page");
	            sheet.getRow(5).createCell(4).setCellValue("FAIL");
	        }
	    }

	    @AfterTest
	    void closeBrowser() throws Exception {
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