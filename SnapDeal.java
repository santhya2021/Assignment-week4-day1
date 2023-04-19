package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.snapdeal.com/");
		Actions act=new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath("//span[@class='catText']"));
		act.moveToElement(e1).perform();
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		driver.findElement(By.xpath("//div[@class='child-cat-count ']"));
		String shoeCount = driver.findElement(By.xpath("(//a[@class='child-cat-node dp-widget-link hashAdded']/div[contains(@class,'child-cat-count ')])[2]")).getText();
		System.out.println("The sports shoe count is: "+shoeCount);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		Thread.sleep(2000);
		
		WebElement arrow = driver.findElement(By.xpath("//div[@class='sort-drop clearfix']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", arrow);
		
		WebElement arrow1 = driver.findElement(By.xpath("//li[@class='search-li sort-active']"));
		jse.executeScript("arguments[0].click();", arrow1);
		
		WebElement price1 = driver.findElement(By.xpath("//input[@name='fromVal']"));
		price1.clear();
		price1.sendKeys("500");
		
		WebElement price2 = driver.findElement(By.xpath("//input[@name='toVal']"));
		price2.clear();
		price2.sendKeys("1200");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='sdCheckbox filters-list '])[4]")).click();
		
		WebElement checkVariable = driver.findElement(By.xpath("//a[@class='clear-filter-pill']"));
		String text = checkVariable.getText();
		
		WebElement checkVariable1 = driver.findElement(By.xpath("//a[@class='clear-filter-pill  ']"));
		String text1 = checkVariable1.getText();
		
		if(text.equals("Rs. 519 - Rs. 649") && text1.equals("Navy"))
		{
			System.out.println("Filter applied successfully");
		}
		else
		{
			System.out.println("Filter Not successful");
		}
		Actions action=new Actions(driver);
		WebElement drag = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
		action.moveToElement(drag).perform();
		
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
		
		Thread.sleep(1000);
		WebElement price = driver.findElement(By.xpath("//span[@class='payBlkBig']"));
		String priceValue = price.getText();
		System.out.println(priceValue);
		
		WebElement discountPrice = driver.findElement(By.xpath("//span[@class='percent-desc ']"));
		String discountPriceValue = discountPrice.getText();
		System.out.println(discountPriceValue);
	}

}
