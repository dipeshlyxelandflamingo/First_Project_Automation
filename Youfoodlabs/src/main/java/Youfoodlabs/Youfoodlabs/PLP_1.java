package Youfoodlabs.Youfoodlabs;
//package Youfoodlabs.Youfoodlabs;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.time.Duration;
//import java.util.List;
//import org.openqa.selenium.JavascriptExecutor;
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//import dev.failsafe.internal.util.Durations;
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//
//public class PLP {
//
//	WebDriver driver;
//	FileInputStream file;
//	XSSFWorkbook workbook;
//	XSSFSheet sheet;
//	DataFormatter formate;
//
//	@BeforeTest(description = "openbrowser")
//	void Openbrowser() throws Exception {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.get("https://yufoodsco.com/collections");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//		file = new FileInputStream("C:\\Users\\LYXELANDFLAMINGO\\Desktop\\Maintence Project\\Yufoodlabs.xlsx");
//		workbook = new XSSFWorkbook(file);
//		sheet = workbook.getSheet("PLP Page");
//		formate = new DataFormatter();
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//a[@class='js-popup-close newsletter__popup-container-close']")));
//
//		popup.click();
//
//	}
//
//	@Test(description = "click on All Product inside EverdyFoods")
//	void TC_01() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement EverdyFoods = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
//				"//img[@src='//yufoodsco.com/cdn/shop/files/Rectangle_605_540x_87f86fd3-82e8-4f1b-8d1e-839e12a6463a_1024x1024.png?v=1631786684']")));
//		EverdyFoods.click();
//
//		String[] allEverdyFoodsproduct = {
//				"(//a[@href=\"/collections/everyday-foods-better-for-you/products/chilli-garlic-fried-rice-pack-of-4\"])[1]",
//				"(//a[@href=\"/collections/everyday-foods-better-for-you/products/desi-chowmein-veg-noodle-meal-pack-of-2\"])[1]",
//				"(//a[@href=\"/collections/everyday-foods-better-for-you/products/fab-noodles-low-carb-high-protein-pack-of-3\"])[1]",
//				"(//a[@href=\"/collections/everyday-foods-better-for-you/products/noodle-meal-combo-pack-kung-pao-chicken-schezwan-stir-fry-pack-of-2\"])[1]",
//				"(//a[@href=\"/collections/everyday-foods-better-for-you/products/kung-pao-chicken-noodle-meal-pack-of-2\"])[1]",
//				"(//a[@href=\"/collections/everyday-foods-better-for-you/products/noodles-combo-pack-hakka-whole-wheat-fab-pack-of-4\"])[1]",
//				"(//a[@href=\"/collections/everyday-foods-better-for-you/products/schezwan-stir-fry-veg-noodle-meal-pack-of-2\"])[1]",
//				"(//a[@href=\"/collections/everyday-foods-better-for-you/products/veg-hakka-noodles-pack-of-3\"])[1]",
//				"(//a[@href=\"/collections/everyday-foods-better-for-you/products/whole-wheat-noodles-pack-of-3\"])[1]" };
//
//		for (String allEverdyFoodsproducts : allEverdyFoodsproduct) {
//			WebElement prodcuts = wait
//					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(allEverdyFoodsproducts)));
//			prodcuts.click();
//			driver.navigate().back();
//
//		}
//	}
//
//	@Test(description = "click on snacking guilt free category")
//	void TC_02() {
//
//		driver.navigate().to("https://yufoodsco.com/collections");
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement Snackingcategory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
//				"//img[@src ='//yufoodsco.com/cdn/shop/files/Rectangle_603_540x_70d2d006-961f-4b77-8f30-8d47ab6a3fc0_1024x1024.png?v=1631786701']")));
//		Snackingcategory.click();
//
//		String[] SnackingGuiltFreeproduct = {
//				"(//a[@href='/collections/snacking-guilt-free/products/chilli-chicken-noodles-pack-of-2'])[1]",
//				"(//a[@href='/collections/snacking-guilt-free/products/pasta-combo-pack-of-4-2-peri-peri-2-three-cheese-pasta'])[1]",
//				"(//a[@href='/collections/snacking-guilt-free/products/red-hot-noodles-veg-pack-of-2'])[1]" };
//
//		for (String SnackingGuiltFreeproducts : SnackingGuiltFreeproduct) {
//			WebElement products = wait
//					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SnackingGuiltFreeproducts)));
//			products.click();
//			driver.navigate().back();
//
//		}
//	}
//
//	(description = "click on Fruit Juices – 100% Natural category")
//	void TC_03() {
//
//		driver.navigate().to("https://yufoodsco.com/collections");
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement category = wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("(//a[@href='/collections/fruit-juices-100-natural'])[1]")));
//		category.click();
//
//		WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
//				"(//a[@href='/collections/fruit-juices-100-natural/products/100-coconut-water-pack-of-6'])[1]")));
//		product.click();
//		driver.navigate().back();
//
//	}
//}
