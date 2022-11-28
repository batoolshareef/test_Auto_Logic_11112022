package test_Auto_Logic_11112022;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTestClass {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://127.0.0.1:5500/index.html");

		List<WebElement> stdList = driver.findElements(By.tagName("option"));
		System.out.println("The Size of Student List is: " + stdList.size());

		Thread.sleep(3000);

		for (int i = 0; i < stdList.size(); i++) {

			String stdList1Str1 = stdList.get(i).getText();
//			System.out.println("The Item String No." + (i+1) + " "+ stdList1Str1);

			// System.out.println("The Item No." + (i+1) + " "+ stdList.get(i).getText());

			if ((i % 2) != 0) {
//				
				List<WebElement> stdList2 = driver.findElements(By.tagName("option"));
				String stdList2Str2 = stdList2.get(i).getText();
//				System.out.println("The Item new String No." + (i+1) + " "+ stdList2Str2);

//				System.out.println("The Item No." + (i + 1) + " " + stdList2.get(i).getText());

				if (stdList1Str1.equals(stdList2Str2)) {

//				System.out.println(stdList1Str1  + " " + stdList2Str2);
					try {
						driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();
						Thread.sleep(2000);
//					System.out.println("the 1st string: " + stdList1Str1 + "---" + "the 1st string: " + stdList2Str2);
//
////
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
//			System.out.println("the 1st string: " + stdList1Str1 + "---" + "the 1st string: " + stdList2Str2);

			}

		}

	}

}
