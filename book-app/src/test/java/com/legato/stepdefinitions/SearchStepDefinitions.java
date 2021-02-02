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

public class SearchStepDefinitions {
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
	@Given("User redirects to the login page")
	public void user_redirects_to_the_login_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("http://127.0.0.1:8080/?#");
		driver.findElement(By.id("signinEmail")).sendKeys("aa@gmail.com");
	    driver.findElement(By.id("signinPassword")).sendKeys("aa123");
	    driver.findElement(By.xpath("//*[@id=\"sec_main\"]/div/div/form/button")).click();
	    Thread.sleep(3000);
	    driver.switchTo().alert().accept();	
	}
	@When("User Enter the match name in the search field")
	public void user_enter_the_match_name_in_the_search_field() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("search_match")).sendKeys("india");
		
	}

	@And("click the seach button")
	public void click_the_seach_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"sec_main\"]/div/div/div/div[1]/div")).click();
		Thread.sleep(3000);
	}
	@Then("user see the list of matches with the name")
	public void user_see_the_list_of_matches_with_the_name() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"sec_main\"]/div/div/div/div[1]/div/h5[1]")).click();
		Thread.sleep(3000);
	}
	


}
