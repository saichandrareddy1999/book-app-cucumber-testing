package com.legato.stepdefinitions;

import java.util.concurrent.TimeUnit;

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

public class DashboardStepDefinitions {
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
	
	@Given("User redirects to login page")
	public void user_redirects_to_home_page() throws InterruptedException  {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("http://127.0.0.1:8080/?#");
		driver.findElement(By.id("signinEmail")).sendKeys("aa@gmail.com");
	    driver.findElement(By.id("signinPassword")).sendKeys("aa123");
	    driver.findElement(By.xpath("//*[@id=\"sec_main\"]/div/div/form/button")).click();
	    Thread.sleep(3000);
	    driver.switchTo().alert().accept();
	}

	@Given("user able to see the information displayed about matches")
	public void user_able_to_see_the_information_displayed_about_matches() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"sec_main\"]/div/div/div/div[1]/h5")).click();
		Thread.sleep(3000);
	}

	@And("user click add to favorite button it should add to favorite")
	public void user_click_add_to_favorite_button_it_should_add_to_favorite() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.xpath("//*[@id=\"sec_main\"]/div/div/div/div[1]/div/div/button")).click();
	    Thread.sleep(3000);
	}
	@Then("user should see the promt message as added successfully")
	public void user_should_see_the_promt_message_as_added_successfully() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.switchTo().alert().accept();	 
	    Thread.sleep(3000); 
	}
	@When("user click add to recommendation button it should add to recommendation")
	public void user_click_add_to_recommendation_button_it_should_add_to_recommendation() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"sec_main\"]/div/div/div/div[1]/div/div[2]/button")).click();
	    Thread.sleep(3000);
	}

}
