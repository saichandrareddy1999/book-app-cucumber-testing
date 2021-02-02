package com.legato.stepdefinitions;

import java.util.concurrent.TimeUnit;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//import org.testng.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.testng.Assert.*;

public class RegisterStepDefinitions {
	private WebDriver driver;
	@Before
	public void setup() {
		System.out.println("Precondition");
		System.out.println("setting up driver before Each tests");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@After
	public void tearDown() {
		driver.close();
	}
	@Given("User gets redirtect to the singUp page")
	public void user_gets_redirtect_to_the_sing_up_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("http://127.0.0.1:8080/?#");
		Thread.sleep(3000);
	}

	@When("User has to give fname, lname, Email, password and Confirm password")
	public void user_has_to_give_fname_lname_email_password_and_confirm_password() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("link_signup")).click();
	    driver.findElement(By.id("inputFname")).sendKeys("crony");
	    driver.findElement(By.id("inputLname")).sendKeys("crony");
	    driver.findElement(By.id("inputEmail")).sendKeys("crony@gmail.com");
	    driver.findElement(By.id("inputPassword")).sendKeys("crony");
	    driver.findElement(By.id("inputPasswordConfirm")).sendKeys("crony");
	}
	

	@And("Click the submit button")
	public void click_the_submit_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"sec_main\"]/div/div/form/button")).click();
		Thread.sleep(3000);
	}
	@Then("User should see the successfully added promt message")
	public void user_should_see_the_successfully_added_promt_message() {
	    // Write code here that turns the phrase above into concrete actions
		driver.switchTo().alert().accept();
	}

	@When("^User enter the fname as (.*) lname as (.*) Email as (.*) password as (.*) and Confirm password as (.*) in the fields$")
	public void user_enter_the_fname_as_bindu_lname_as_ch_email_as_bindu_gmail_com_password_as_bindu_and_confirm_password_as_bindu_in_the_fields(String name, String frtname, String email, String pwd, String conpwd) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("link_signup")).click();
	    driver.findElement(By.id("inputFname")).sendKeys(name);
	    driver.findElement(By.id("inputLname")).sendKeys(frtname);
	    driver.findElement(By.id("inputEmail")).sendKeys(email);
	    driver.findElement(By.id("inputPassword")).sendKeys(pwd);
	    driver.findElement(By.id("inputPasswordConfirm")).sendKeys(conpwd);
	}
	@When("^User has to gives (.*), (.*), (.*), (.*) and (.*)$")
	public void user_has_to_gives_fname_lname_email_password_and_confirm_password(String name, String frtname, String email, String pwd, String conpwd) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("link_signup")).click();
	    driver.findElement(By.id("inputFname")).sendKeys(name);
	    driver.findElement(By.id("inputLname")).sendKeys(frtname);
	    driver.findElement(By.id("inputEmail")).sendKeys(email);
	    driver.findElement(By.id("inputPassword")).sendKeys(pwd);
	    driver.findElement(By.id("inputPasswordConfirm")).sendKeys(conpwd);
	    
	}
	


}
