package org.stepdefinition;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Loginstep {
	static WebDriver driver;
	
	@Given("user should able to launch argos homepage")
	public void user_can_able_to_launch_homepage() {
	    WebDriverManager.chromedriver().setup();
	    
	    driver = new ChromeDriver();
	    driver.get("https://www.next.co.uk/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    }
	
	@When("user have to click the cross button")
	public void user_have_to_click_the_cross_button() {
		WebElement btncross=driver.findElement(By.xpath("//button[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']"));
		btncross.click();
	}
	
	@When("user have to click the close button")
	public void user_have_to_click_the_close_button() {
		WebElement btnclose=driver.findElement(By.xpath("//span[text()='Close']"));
		btnclose.click();
			
	}
	
	@When("user have to click the account button")
	public void user_have_to_click_the_account_button() {
		WebElement btnaccount=driver.findElement(By.xpath("//span[text()='My Account']"));
		btnaccount.click();
	}

	@When("user has to enter username {string} and password {string}")
	public void the_user_has_to_fill_the_username_and_password(String user, String pass){
	    WebElement txtUsername=driver.findElement(By.id("EmailOrAccountNumber"));
	    txtUsername.sendKeys(user);
	    
	    WebElement txtPassword=driver.findElement(By.id("Password"));
	    txtPassword.sendKeys(pass);
	   }
	
	@When("user have to click the login button")
	public void the_user_have_to_click_the_login_button(){
		WebElement btnlogin=driver.findElement(By.id("SignInNow"));
		btnlogin.click();
		}
	
	@Then("user navigate to invalid login page")
	public void user_navigate_to_invalid_loginpage() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.urlContains("secure"));
	    Assert.assertTrue("Verify the URL", driver.getCurrentUrl().contains("secure"));
	    System.out.println("Sorry, we have been unable to sign you in.Please check your sign in details are correct and try again.");
	    driver.close();
	}
}
