package popups;
// Characteristics:

// We can’t inspect this popup.
// We can’t move this popup.
// This popup will be present in the middle of the webpage under the URL.
// We can’t perform any action on the webpage until we handle this popup.
// This popup will have a message and an OK button (Alert popup).
// If it has OK and Cancel buttons → (Confirmation popup).
// If it has a textbox with OK and Cancel buttons → (Prompt popup).
// 📌 Notes:

// Since alert popup is created using JavaScript language, it is also called a JavaScript popup.
// How do you handle Alert popup or JavaScript popup?

// We can handle Alert popup by using:
// driver.switchTo().alert() statement

// What is the return type of alert() method?

// The return type of alert() method is Alert interface.

// Methods:

// accept():
// It is used to click on OK button.

// dismiss():
// It is used to click on Cancel button.

// getText():
// It is used to get the text from the alert popup.

// sendKeys():
// It is used to enter text into the alert popup (Prompt popup).

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopUps {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.findElement(By.xpath("//a[text()='Alert with OK ']")).click();
		driver.findElement(By.xpath("//button[@onclick=\"alertbox()\"]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']")).click();
		driver.findElement(By.xpath("//button[@onclick=\"confirmbox()\"]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		
		driver.findElement(By.xpath("//a[text()='Alert with Textbox ']")).click();
		driver.findElement(By.xpath("//button[@onclick=\"promptbox()\"]")).click();
		Thread.sleep(2000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("Jhanhavi");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.id("demo1")).getText());
        driver.quit();
	}

}
