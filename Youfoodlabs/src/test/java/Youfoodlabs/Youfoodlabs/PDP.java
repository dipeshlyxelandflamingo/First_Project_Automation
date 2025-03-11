package YUFoodLabs.YUFoodLabs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PDP {
  
	
	WebDriver driver;

	@BeforeTest
	void openbrowser() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// to open website
		driver.get("https://yufoodsco.com/collections/noodle-bowls/products/veg-hakka-noodles-pack-of-3");

		// to maximize window
		driver.manage().window().maximize();

		// common code for waiting
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// to close pop up
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@class='js-popup-close newsletter__popup-container-close']")));

		popup.click();
		Thread.sleep(1000);

	}
	
	@Test
	// TC_01 Contains Bread crumb button, product quantity CTAs & Add to cart)
	void TC_01() throws Exception {

//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// Redirection to listing page & home page via bread crumb button and navigate back to PDP.
		WebElement Listing_breadcrumb = driver.findElement(By.xpath("(//*[@href='/collections/noodle-bowls'])[4]"));
		Listing_breadcrumb.click();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		WebElement Home_breadcrumb = driver.findElement(By.xpath("//*[@class='homepage-link']"));
		Home_breadcrumb.click();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		
		// Increasing & Decreasing Quantity CTA 
		WebElement button = driver.findElement(By.xpath("(//*[@class='btnqty qtyplus icon icon-plus'])[1]"));
		button.click();
		Thread.sleep(1000);
		WebElement Decrease_button = driver.findElement(By.xpath("(//*[@class='btnqty qtyminus icon icon-minus'])[1]"));
		Decrease_button.click();
		
		// Click on Add to Cart button & closing Mini Cart (Variable ATC means = Add to cart_
		WebElement ATC = driver.findElement(By.xpath("//*[@class='add clearfix mb10  AddtoCart js-ajax-submit ']"));
		ATC.click();
		Thread.sleep(1000);
		WebElement Cart_Close = driver.findElement(By.xpath("//*[@class='slideout__trigger-password js-slideout-close']"));
		Cart_Close.click();
		Thread.sleep(1000);
		}
	
	@Test
	// TC_02 Contains All the product images clicks, zoom in and zoom out.
	void TC_02 () throws Exception {
		
		// Find the total number of "Images" buttons
        int P_IMGCount = driver.findElements(By.xpath("//*[@class='lazyload-fade js-thumb-item-img lazyautosizes lazyloaded']")).size();

        // Loop through and click each button one by one
        for (int i = 1; i <= P_IMGCount; i++) {
            // Construct XPath dynamically for each button
            WebElement Img_button = driver.findElement(By.xpath("(//*[@class='lazyload-fade js-thumb-item-img lazyautosizes lazyloaded'])[" + i + "]"));
            Img_button.click();
            Thread.sleep(1000); 
        }
        
        // To Zoom IN Product Image then check left right Arrow buttons then zoom out image
        WebElement ZoomButton = driver.findElement(By.xpath("(//*[@class='zoom_btn'])[6]"));
        ZoomButton.click();
        Thread.sleep(1000);
        WebElement LeftButton = driver.findElement(By.xpath("(//*[@class='pswp__button pswp__button--arrow--left'])[1]"));
        LeftButton.click();
        Thread.sleep(1000);
        WebElement RightButton = driver.findElement(By.xpath("(//*[@class='pswp__button pswp__button--arrow--right'])[1]"));
        RightButton.click();
        Thread.sleep(1000);
        WebElement CloseButton = driver.findElement(By.xpath("(//*[@class='pswp__button pswp__button--close'])[1]"));
        CloseButton.click();
        Thread.sleep(1000);    	
	    }
	
	@Test
	// TC_03 - Click on all the accordions
	void TC_03 () throws Exception {
		
		// Find the total number of "Accordions" buttons
        int Accordions = driver.findElements(By.xpath("//*[@class='c-accordion__header-icons']")).size();

        // Loop through and click each Accordions one by one
        for (int i = 1; i <= Accordions; i++) {
            // Construct XPath dynamically for each button
            WebElement Acc_button = driver.findElement(By.xpath("(//*[@class='c-accordion__header-icons'])[" + i + "]"));
            Acc_button.click();
            Thread.sleep(1000); 
        }
        }
		
    @Test
    
	void TC_04 () throws Exception {
    	   	
    	// Find the total number of "Increase" buttons
        int Inc_Button = driver.findElements(By.xpath("//*[@class='btnqty qtyplus icon icon-plus']")).size();

        // Loop through and click each Increase Button one by one
        for (int i = 2; i <= Inc_Button; i++) {
            // Construct XPath dynamically for each button
            WebElement Increase = driver.findElement(By.xpath("(//*[@class='btnqty qtyplus icon icon-plus'])[" + i + "]"));
            Increase.click();
            Thread.sleep(1000); 
        }
        }
		
    @Test
    
   	void TC_05 () throws Exception {
       	
       	// Find the total number of "Decrease" buttons
           int Dec_Button = driver.findElements(By.xpath("//*[@class='btnqty qtyminus icon icon-minus']")).size();

           // Loop through and click each Decrease Button one by one
           for (int i = 2; i <= Dec_Button; i++) {
               // Construct XPath dynamically for each button
               WebElement Decrease = driver.findElement(By.xpath("(//*[@class='btnqty qtyminus icon icon-minus'])[" + i + "]"));
               Decrease.click();
               Thread.sleep(1000); 
           }
    }
    
 @Test
    
   	void TC_06 () throws Exception {
       	
       	// Find the total number of "Add to Cart" buttons
           int ATCButton = driver.findElements(By.xpath("//*[@class='btn cart-btn-col']")).size();

           // Loop through and click each ATC Button one by one
           for (int i = 1; i <= ATCButton; i++) {
               // Construct XPath dynamically for each button
               WebElement ATC1 = driver.findElement(By.xpath("(//*[@class='btn cart-btn-col'])[" + i + "]"));
               ATC1.click();
               Thread.sleep(1000); 
               driver.navigate().back();
               Thread.sleep(1000); 
           }
    }
 
 @Test
 
 	void TC_07 () throws Exception {
 		
	 WebElement StickyATC = driver.findElement(By.xpath("//*[@class='sticky-add clearfix mb10 AddtoCart secondary-button js-ajax-submit']"));
	 StickyATC.click();
	 Thread.sleep(1000);
	WebElement Cart_Close1 = driver.findElement(By.xpath("//*[@class='slideout__trigger-password js-slideout-close']"));
	Cart_Close1.click();
	Thread.sleep(1000);
	
	// Refresh the page
    driver.navigate().refresh();

    // Wait after refresh
    Thread.sleep(2000);

    // Close the browser
    driver.quit();
 	
 	}
    
    
    
    
}
		
















