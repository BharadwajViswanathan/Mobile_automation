package andoird.com.Learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class clickable {
public static void main(String[] args) throws InterruptedException {
	
	WebDriver driver=new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/loginpagePractise/");
	driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();

	WebElement element = driver.findElement(By.xpath("//button[.='Okay']"));

	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.elementToBeClickable(element));
	element.click();

}
}
