package day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMLoginTest {

	public static void main(String[] args) {
//		manually
//		System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver_win32\\chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();  //add this line 
		options.addArguments("--remote-allow-origins=*"); //add this line
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));//implicit wait 
		
		WebElement userName = driver.findElement(By.name("username"));
		userName.clear();//clean text box
		userName.sendKeys("Admin");//enter data
		
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		
		//title validation
		String pageTitle = driver.getTitle();
		String expectedTitle = "OrangeHRM";
		if(pageTitle.equalsIgnoreCase(expectedTitle)) System.out.println("good");
		else System.out.println("Bad"); 
		//ending
		
		//label validation
		String lblMenu = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[3]/div/div[1]/div/p")).getText();
		String expLabel = "Quick Launch";
		
		if(lblMenu.equalsIgnoreCase(expLabel)) System.out.println("good");
		else System.out.println("Bad"); 
		//end label validation
		driver.close();//close the current session or window.
//		driver.quit();//close all sessions or windows
		
		
		
		
	}

}
