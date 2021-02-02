package com.legato.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FavouriteStepDefinitions {
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
	@Given("User has to redirects to login page")
	public void user_has_to_redirects_to_login_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("http://127.0.0.1:8080/?#");
		driver.findElement(By.id("signinEmail")).sendKeys("aa@gmail.com");
	    driver.findElement(By.id("signinPassword")).sendKeys("aa123");
	    driver.findElement(By.xpath("//*[@id=\"sec_main\"]/div/div/form/button")).click();
	    Thread.sleep(3000);
	    driver.switchTo().alert().accept();	
	}
	@When("user click add to favorite button in the home page")
	public void user_click_add_to_favorite_button_in_the_home_page() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"sec_main\"]/div/div/div/div[2]/div/div/button")).click();
	    Thread.sleep(3000);
	    driver.switchTo().alert().accept();	
	}
	@And("user click on favourite")
	public void user_click_on_favourite() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("link_favourite")).click();
		Thread.sleep(3000);
		
	}

	@Then("should display the list of favourite")
	public void should_display_the_list_of_favourite() {
	    // Write code here that turns the phrase above into concrete actions
	   //driver.findElement(By.xpath("//*[@id=\"sec_main\"]/div/div/div/div[1]")).clear();
	}
	@When("user click add to favorite button in home page")
	public void user_click_add_to_favorite_button_in_home_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"sec_main\"]/div/div/div/div[2]/div/div[1]/button")).click();
	    Thread.sleep(3000);
	    //driver.switchTo().alert().accept(); 
	}
	@When("user should see error message")
	public void user_should_see_error_message() {
	    // Write code here that turns the phrase above into concrete actions
		//Thread.sleep(30000);
		Alert alert=driver.switchTo().alert();
		Assert.assertTrue(alert.getText().equals("match already in Favourites"));
		driver.switchTo().alert().accept();
	}
}
