package stepDef;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class login {
	WebDriver driver;
	 String baseUrl = "https://www.saucedemo.com/";
	 
	 @Given("user harus buka menggunakan link")
	 public void user_harus_buka_menggunakan_link() throws Exception {
	     WebDriverManager.chromedriver().setup();
	     ChromeOptions opt = new ChromeOptions();
	     
	     driver = new ChromeDriver(opt);
	     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	     driver.manage().window().maximize();
	     driver.get(baseUrl);
	 }
	 @When("user input username dan password")
	 public void user_input_username_dan_password() throws Exception {
	     driver.findElement(By.id("user-name")).sendKeys("standard_user");
	     Thread.sleep(500);
	     driver.findElement(By.id("password")).sendKeys("secret_sauce");
	     Thread.sleep(500);
	 }
	 @And("user klik tombol login")
	 public void user_klik_tombol_login() throws Exception {
	  driver.findElement(By.id("login-button")).click();
	  Thread.sleep(500);
	 }
	 @Then("user masuk ke halaman home")
	 public void user_masuk_ke_halaman_home() {
	  Assert.assertEquals("Products",driver.findElement(By.className("title")).getText());
	  System.out.println("Scenario : Login as valid username");
	  System.out.println("If Success Login, You Can See Title Name " + driver.findElement(By.className("title")).getText());
	  driver.quit();
	 }
}
