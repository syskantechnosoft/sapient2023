package com.sapient.selenium_cucumber_demo.datatable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

public class StepDefinition {
	WebDriver driver = null;

	@Given("^the user on the user registration page.$")
	public void the_user_on_the_user_registration_page() {
		// Intiate web browser instance. driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Siva\\Downloads\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://info.workday.com/WDLiveWebinar-RYB_Registration.html");
	}

	@When("^user enter valid data on the page$")
	public void user_enter_valid_data_on_the_page(DataTable table) {
		// Initialize data table
		
		List<List<String>> data = table.raw();
		System.out.println("Test Output From Data Table :"+data.get(1).get(1));

		// Enter data
//		driver.findElement(By.id(null))
		driver.findElement(By.id("FirstName")).sendKeys(data.get(1).get(1));
		driver.findElement(By.id("LastName")).sendKeys(data.get(2).get(1));
		driver.findElement(By.id("Email")).sendKeys(data.get(3).get(1));
		driver.findElement(By.id("Company")).sendKeys(data.get(4).get(1));
//		driver.findElement(By.name("Functional_Role__c")).sendKeys(data.get(5).get(1));

		Select dropdownB = new Select(driver.findElement(By.name("Functional_Role__c")));
		dropdownB.selectByValue("IT");

		Select dropdownM = new Select(driver.findElement(By.name("Job_Level__c")));
		dropdownM.selectByValue("Faculty");

		Select dropdownY = new Select(driver.findElement(By.name("Employee_Range__c")));
		dropdownY.selectByValue("0-350");

		Select dropdownC = new Select(driver.findElement(By.name("Country")));
		dropdownY.selectByValue("India");
		
		driver.findElement(By.className("mktoButton")).click();
		// Click submit button driver.findElement(By.name("websubmit")).click();
	}

	@Then("^the user registration should be successful.$")
	public void the_user_registration_should_be_successful() {
		if (driver.getCurrentUrl().equalsIgnoreCase("https://info.workday.com/FY21.Q4.EMEA.NS.WorkdayLiveWebinar-Platform.IT.webinar_Confirmation.html")) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Failed");
		}
		driver.close();
	}
}
