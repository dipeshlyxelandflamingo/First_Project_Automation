package youfoodlabs.youfoodlabs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PLP {

	WebDriver driver;

	@BeforeTest
	void openbrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// to open website
		driver.get("https://yufoodsco.com/collections/fruit-juices-100-natural");

		// to maximize window
		driver.manage().window().maximize();

		// common code for waiting
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// to close pop up (agar dikhega to open kr deha nhi to wait krega )
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@class='js-popup-close newsletter__popup-container-close']")));

		popup.click();

		// to close the pop up
		// WebElement CloseButton = driver.findElement(By.className("js-popup-close
		// newsletter__popup-container-close"));
		// CloseButton.click();

	}

	// to click on Noodles filter
	@Test
	void TC_01() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement button = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Noodles']")));

		button.click();

		// Thread.sleep(3000);

		// WebElement button =
		// driver.findElement(By.xpath("//button[normalize-space()='Noodles']"));
		// button.click();

		// to close the Noodles button
		WebElement filter = driver.findElement(By.xpath("//button[normalize-space()='Noodles']"));
		filter.click();

		// to click on pasta button (filter)
		WebElement pasta = driver.findElement(By.xpath("//button[normalize-space()='Pasta']"));
		pasta.click();

		// to close filter
		WebElement Pastaa = driver.findElement(By.xpath("//button[normalize-space()='Pasta']"));
		Pastaa.click();

		// to open 100% fruit juice
		WebElement fruit = driver.findElement(By.xpath("//button[normalize-space()='100% Fruit Juices']"));
		fruit.click();

		// to close filter
		WebElement juice = driver.findElement(By.xpath("//button[normalize-space()='100% Fruit Juices']"));
		juice.click();

		// to open Rice & instant mixes
		WebElement rice = driver.findElement(By.xpath("//button[normalize-space()='100% Fruit Juices']"));
		rice.click();

		// to close filter
		WebElement instant = driver.findElement(By.xpath("//button[normalize-space()='100% Fruit Juices']"));
		instant.click();

		// to open comobos
		WebElement combo = driver.findElement(By.xpath("//button[normalize-space()='Combos']"));
		combo.click();

		// to close filter
		WebElement combos = driver.findElement(By.xpath("//button[normalize-space()='Combos']"));
		combos.click();

		// to open explore filter
		WebElement explore = driver.findElement(By.xpath("//button[normalize-space()='Explore']"));
		explore.click();

		// to close filter
		WebElement explorer = driver.findElement(By.xpath("//button[normalize-space()='Explore']"));
		explorer.click();
	}

	@Test
	void TC_02() throws Exception {

		// wait for the quantity buttons to load
		// WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Locate the + button to increase quantity
		// ebElement increaseButton =
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/span[2]"));
		// ncreaseButton.click();

		// scroll
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, 500)", "");

		// increase quantity (100% coconut water)
		WebElement increaseButton = driver.findElement(By.xpath(
				"//body[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/span[2]"));
		increaseButton.click();

		// decrease quantity (100% coconut water)
		WebElement decreaseButton = driver.findElement(By.xpath(
				"//body[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/span[1]"));
		decreaseButton.click();

		// click on add to cart button
		WebElement addToCart = driver.findElement(By.xpath(
				"//body[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[2]/div[1]/form[1]/div[2]/input[1]"));
		addToCart.click();

		// click close button on mini cart
		WebElement miniCart = driver
				.findElement(By.xpath("//button[@aria-label='Close cart']//div[@class='icn-close']"));
		miniCart.click();

		// click on product detail
		WebElement detail = driver.findElement(By.xpath(
				"//a[@title='100% Coconut Water - Pack of 6']//img[@class='lazyload-fade first-image lazyautosizes lazyloaded']"));
		detail.click();

		// coming back to listing page
		WebElement breadcrumb = driver
				.findElement(By.xpath("//div[@id='breadcrumb']//a[contains(text(),'Fruit Juices – 100% Natural')]"));
		breadcrumb.click();

	}

// FOR SECOND PRODUCT
	@Test
	void TC_03() throws Exception {

		// scroll
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, 500)", "");

		// increase quantity (Berry Blast)
		WebElement increaseButton = driver.findElement(By.xpath(
				"//body[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[6]/div[2]/div[2]/div[1]/form[1]/div[1]/div[1]/span[2]"));
		increaseButton.click();

		// decrease quantity (Berry Blast)
		WebElement decreaseButton = driver.findElement(By.xpath(
				"//body[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[6]/div[2]/div[2]/div[1]/form[1]/div[1]/div[1]/span[1]"));
		decreaseButton.click();

		// click on add to cart button
		WebElement addToCart = driver.findElement(By.xpath(
				"//body[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[6]/div[2]/div[2]/div[1]/form[1]/div[2]/input[1]"));
		addToCart.click();

		// close mini cart
		WebElement miniCart = driver.findElement(By.xpath(
				"//body[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[6]/div[2]/div[2]/div[1]/form[1]/div[2]/input[1]"));
		miniCart.click();

		// click on product detail
		WebElement detail = driver.findElement(By.xpath(
				"//a[@title='Berry Blast - 100% Fruit Juice - Pack of 3']//img[@class='lazyload-fade first-image lazyautosizes lazyloaded']"));
		detail.click();

		// coming back to listing page
		WebElement listing = driver
				.findElement(By.xpath("//div[@id='breadcrumb']//a[contains(text(),'Fruit Juices – 100% Natural')]"));
		listing.click();

	}

	// FOR THIRD PRODUCT
	@Test
	void TC_04() throws Exception {

		// scroll
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, 500)", "");

		// increase quantity (tropical juice 100% fruit juice)
		WebElement increaseButton = driver.findElement(By.xpath(
				"//body[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[6]/div[3]/div[2]/div[1]/form[1]/div[1]/div[1]/span[2]"));
		increaseButton.click();

		// decrease quantity (tropical juice 100% fruit juice)
		WebElement decreaseButton = driver.findElement(By.xpath(
				"//body[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[6]/div[3]/div[2]/div[1]/form[1]/div[1]/div[1]/span[1]"));
		decreaseButton.click();

		// add to cart
		WebElement addToCart = driver.findElement(By.xpath(
				"//body[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[6]/div[3]/div[2]/div[1]/form[1]/div[2]/input[1]"));
		addToCart.click();

		// close mini cart
		WebElement miniCart = driver
				.findElement(By.xpath("//button[@aria-label='Close cart']//div[@class='icn-close']"));
		miniCart.click();

		// click on product detail
		WebElement detail = driver.findElement(By.xpath(
				"//a[@title='Tropical Punch 100% Fruit Juice - Pack of 3']//img[@class='lazyload-fade first-image lazyautosizes lazyloaded']"));
		detail.click();

		// back to listing page
		WebElement listing = driver
				.findElement(By.xpath("//div[@id='breadcrumb']//a[contains(text(),'Fruit Juices – 100% Natural')]"));
		listing.click();

		// close mini cart
		WebElement miniCartListing = driver.findElement(By.xpath("//button[@aria-label='Close cart']"));
		miniCartListing.click();

	}

}
