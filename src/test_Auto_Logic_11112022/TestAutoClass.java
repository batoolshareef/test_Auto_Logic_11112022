package test_Auto_Logic_11112022;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class TestAutoClass {

	public static void main(String[] args) throws InterruptedException, IOException {
		// chrome driver
		System.setProperty("webdriver.chrome.driver", "E:\\Chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://127.0.0.1:5500/index.html");

		// firefox driver
//		System.setProperty("webdriver.geck.driver", "E:\\firefoxdriver\\geckodriver.exe");
//		WebDriver driver=new FirefoxDriver();
//		driver.get("http://127.0.0.1:5500/index.html");

		// edge driver
//		System.setProperty("webdriver.edge.driver", "E:\\edgedriver\\edgedriver.exe");
//		WebDriver driver=new EdgeDriver();
//		driver.get("http://127.0.0.1:5500/index.html");

//--------------------1. to delete items in list if index is even

		List<WebElement> stdList = driver.findElements(By.tagName("option"));
		System.out.println("The Size of Student List is: " + stdList.size());

		Thread.sleep(3000);

		for (int i = 0; i < stdList.size(); i++) {

			// System.out.println("The Item No." + (i+1) + " "+ stdList.get(i).getText());
			if ((i % 2) == 0) {
//				System.out.println("The Item No." + (i) + " " + stdList.get(i).getText());

				try {
					driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();
					Thread.sleep(1000);
//
				} catch (Exception e) {
//					// TODO: handle exception
				}
			}

		}
//--------------------2. to display the list items after delete 8 items

		List<WebElement> stdList2 = driver.findElements(By.id("selectNow"));
//		System.out.println("The New List Item After Remove Items is: " + stdList2.size());

		for (int y = 0; y < stdList2.size(); y++) {
			
			stdList2.get(y).click();
			Thread.sleep(3000);
			
//			System.out.println("The Item No." + (y + 1) + " " + stdList2.get(y).getText());
			
////--------------------3. to take screenshot for the list which displayed			
			Date currentDate = new Date();

			String TheAcutalDate = currentDate.toString().replace(":", "-");

			TakesScreenshot src = ((TakesScreenshot) driver);

			File SrcFile = src.getScreenshotAs((OutputType.FILE));

			File Dest = new File(".//ScreenShots/" + TheAcutalDate + ".png");

			FileUtils.copyFile(SrcFile, Dest);	
		}
}
}