import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class seleniumtests {
	WebDriver driver;

	@Before
	public void openLoginPage() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/IdeaBoard/login.jsp");
		Assert.assertEquals("login", driver.getTitle());
	}

   @Test
	public void testAllFunctionality() throws InterruptedException {
	   Thread.sleep(5000);
	   WebElement username = driver.findElement(By.name("netId")); 
	   WebElement password = driver.findElement(By.name("password"));
	   WebElement link     = driver.findElement(By.id("abc"));
	   username.sendKeys("abc100");
	   password.sendKeys("abc100");
     	link.click();
	Thread.sleep(5000);
	driver.findElement(By.linkText("viewprofile")).click();
	Thread.sleep(5000);
	Assert.assertEquals("viewprofilepage", driver.getTitle());
	Thread.sleep(2000);
	driver.get("http://localhost:8080/IdeaBoard/userHomePage.jsp");
	Thread.sleep(5000);
    driver.findElement(By.linkText("createidea")).click();
    WebElement title = driver.findElement(By.name("title")); 
    WebElement descrip = driver.findElement(By.name("description"));
    WebElement radioBtn = driver.findElement(By.id("900"));
    WebElement radioBtn1 = driver.findElement(By.id("200"));
    WebElement radioBtn2 = driver.findElement(By.id("600"));
    WebElement link10     = driver.findElement(By.id("pos"));
    title.sendKeys("railway system");
    Thread.sleep(2000);
    descrip.sendKeys("project to be done");
    Thread.sleep(2000);
    radioBtn.click();
    Thread.sleep(2000);
    radioBtn1.click();
    Thread.sleep(2000);
    radioBtn2.click();
    Thread.sleep(2000);
    Assert.assertEquals("createideapage", driver.getTitle());
    link10.click();
    Thread.sleep(5000);
    driver.get("http://localhost:8080/IdeaBoard/userHomePage.jsp");
    Thread.sleep(5000);
    driver.findElement(By.linkText("my_ideas")).click();
    Assert.assertEquals("userideapage", driver.getTitle());
    Thread.sleep(5000);
   }

	@After
	public void closePage() {
		driver.quit();
	}
}