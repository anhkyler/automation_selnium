package day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class orangeHRMSite {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();  //add this line 
		options.addArguments("--remote-allow-origins=*"); //add this line
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://demo.opencart.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));//implicit wait 
		
		String text = driver.findElement(By.xpath("//a[text()='MacBook']")).getText();
		
		driver.close();//close the current session or window.
//		driver.quit();//close all sessions or windows
		

	}

}
