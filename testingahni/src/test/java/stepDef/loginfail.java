package stepDef;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
public class loginfail {
	WebDriver driver;
	 String baseUrl = "https://www.saucedemo.com/";
	 
	 @Given("user should be open link")
	 public void user_should_be_open_link() {
	     WebDriverManager.chromedriver().setup();
	     ChromeOptions opt = new ChromeOptions();
	     
	     driver = new ChromeDriver(opt);
	     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	     driver.manage().window().maximize();
	     driver.get(baseUrl);
	 }
	 @When("user input invalid username and password")
	 public void user_input_invalid_username_and_password() throws Exception {
	     driver.findElement(By.id("user-name")).sendKeys("haiahni");
	     Thread.sleep(500);
	     driver.findElement(By.id("password")).sendKeys("pwdsalah");
	     Thread.sleep(500);
	 }
	 @And("click button login")
	 public void user_click_button_login() throws Exception {
	  driver.findElement(By.id("login-button")).click();
	  Thread.sleep(500);
	 }
	 @Then("cannot sign in")
	 public void cannot_sign_in() {
	  Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match a')]")).getText());
	  System.out.println("Scenario : Login as invalid username");
	  System.out.println("If Failed Login, You Can See Error " + driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match a')]")).getText());
	  driver.quit();
	 }
}
