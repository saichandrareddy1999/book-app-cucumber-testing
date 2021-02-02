package com.legato.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDefinitions {
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
	@Given("user gets redirect to the login page")
	public void user_gets_redirect_to_the_login_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("http://127.0.0.1:8080/?#");
		Thread.sleep(3000);
	}

	@When("User enter the username and password")
	public void user_enter_the_username_and_password() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("signinEmail")).sendKeys("aa@gmail.com");
	    driver.findElement(By.id("signinPassword")).sendKeys("aa123");
	}

	@And("Click the submit button in the page")
	public void click_the_submit_button_in_the_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"sec_main\"]/div/div/form/button")).click();
		Thread.sleep(3000);
	}

	@Then("user has to login successfully")
	public void user_has_to_login_successfully() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.switchTo().alert().accept();	 
	    Thread.sleep(3000);
	    
	}

	@Then("User redirect to home page")
	public void user_redirect_to_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("link_logout")).click();
	}

	@When("^User enter the username as (.*) and password as (.*) in the field$")
	public void user_enter_the_username_as_preethi_gmail_com_and_password_as_preethi_in_the_field(String username, String pwd) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("signinEmail")).sendKeys(username);
	    driver.findElement(By.id("signinPassword")).sendKeys(pwd);
	}

	

}
