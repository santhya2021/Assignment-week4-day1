package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ERail_Assignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://erail.in/");
		driver.findElement(By.xpath("//input[@id='txtStationFrom']")).clear();
		driver.findElement(By.xpath("//input[@id='txtStationFrom']")).sendKeys("ms",Keys.TAB);
		driver.findElement(By.xpath("//input[@id='txtStationTo']")).clear();
		driver.findElement(By.xpath("//input[@id='txtStationTo']")).sendKeys("co",Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();
		Thread.sleep(5000);
		List<WebElement> row = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']//tr"));
		int size=row.size();
		System.out.println(size);
		for(int i=2;i<size;i++)
		{
			String text = driver.findElement(By.xpath("(//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']//tr["+i+"]/td[2]")).getText();
			System.out.println(text);	
		}
		driver.close();

	}

}
