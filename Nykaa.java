package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.nykaa.com/");
		
		Actions act=new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//a[text()='brands']"));
		act.moveToElement(element).perform();
		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
		driver.findElement(By.xpath("(//div[@class='css-150nd8c']/a[contains(text(),'Paris')])[1]")).click();
		String title = driver.getTitle();
		if(title.contains("L'Oreal Paris"))
		{
			System.out.println("Verified the Title");
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		driver.findElement(By.xpath("(//div[@class='control-indicator radio '])[3]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='filter-open css-1gdff5r']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'css-1nozswx')]")).click();
		driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
		driver.findElement(By.xpath("(//div[@class='control-indicator checkbox '])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		//driver.findElement(By.xpath("//input[@class='css-1kkm963']")).sendKeys("Color Protection");
		driver.findElement(By.xpath("//span[text()='Color Protection']/ancestor::label")).click();
		WebElement ver = driver.findElement(By.xpath("//span[text()='Shampoo']"));
		String text = ver.getText();
		Thread.sleep(1000);
		if(text.contains("Shampoo"))
		{
			System.out.println("Filters Applied successfully");
		}
		driver.findElement(By.xpath("//a[@class='css-qlopj4']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> obj=new ArrayList<String>(windowHandles);
		driver.switchTo().window(obj.get(1));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='180ml']")).click();
		WebElement price = driver.findElement(By.xpath("(//span[text()='₹209'])[1]"));
		String priceV = price.getText();
		System.out.println("The Product Price:"+priceV);
		driver.findElement(By.xpath("(//button[@class=' css-13zjqg6']/span[text()='Add to Bag'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();
		driver.switchTo().frame(0);
		WebElement findElement1 = driver.findElement(By.xpath("//span[@class='css-1um1mkq e171rb9k3']"));
		String gTotal = findElement1.getText();
		System.out.println(gTotal);
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("(//button[@class='css-110s749 e8tshxd1'])[2]")).click();
		driver.findElement(By.xpath("(//img[@class='css-16z7tzi ek8d9s80'])[2]")).click();
		WebElement findElement3 = driver.findElement(By.xpath("//p[@class='css-1e59vjt eka6zu20']"));
		String pay = findElement3.getText();
		if(pay.equals(gTotal))
		{
			System.out.println("The total is same");
		}
		else
		{
			System.out.println("The total is not same");
		}
		driver.quit();
		
	}

}
