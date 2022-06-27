package org.stepdefinition;

import com.github.dockerjava.api.model.HealthCheck;
import io.cucumber.java.en.And;
import org.apache.log4j.Logger;
import org.apache.velocity.runtime.directive.contrib.For;
import org.base.Global;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.pagemanager.PageObjectManager;
import org.testng.Assert;

import com.aventstack.extentreports.GherkinKeyword;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import javax.swing.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Steps extends Global {
	public static Logger log;
	public static WebDriver driver;
	public static List<String> Contactlist, Comparelist;


	//	@Given("Launch the url")
//	public void launch_the_url() {
//		driver = getDriver();
//		maximizeWindow();
//		implicitWait();
//		launchURL(readPropertyFileData().getProperty("url"));
//	}
	@Given("Launch the url")
	public void launch_the_url() throws Throwable {
		driver = getDriver();
		maximizeWindow();
		implicitWait();
		launchURL(ReadDatafromJson("Contact_Name", "url"));
	}
//
//	@When("Enter Valid Username")
//	public void i_enter_the_username() throws Throwable {
//		log = readLog4jData();
//		log.info("User is navigate to Salesforce site");
//		enterData(PageObjectManager.getInstance().getLoginPage().getUserName(),
//				readPropertyFileData().getProperty("UserName"));
//		log.info("User enter the correct username");
//	}

	@When("Enter Valid Username")
	public void i_enter_the_username() throws Throwable {
		log = readLog4jData();
		log.info("User is navigate to Salesforce site");
		enterData(PageObjectManager.getInstance().getLoginPage().getUserName(),
				ReadDatafromJson("Contact_Name", "UserName"));
		log.info("User enter the correct username");
	}

	//	@When("Enter Valid Password")
//	public void i_enter_the_password() throws Throwable {
//		enterData(PageObjectManager.getInstance().getLoginPage().getPassword(),
//				readPropertyFileData().getProperty("Password"));
//		log.info("User enter the correct password");
//	}
	@When("Enter Valid Password")
	public void i_enter_the_password() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getPassword(),
				ReadDatafromJson("Contact_Name", "Password"));
		log.info("User enter the correct password");
	}

	@Then("Click on Contact Name Button")
	public void I_Click_Contact_Name() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getContactName());
		log.info("User click the Contact Name Button");
		Thread.sleep(5000);
	}

	@Then("Click on Contact Email Button")
	public void I_Click_Contact_Email() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getContactEmail());
		log.info("User click the Contact Name Button");
	}
//	@When("Enter the First Name")
//	public void i_enter_the_FirstName() throws Throwable {
////		readCompleteDataFromEXcel();
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readPropertyFileData().getProperty("FirstName"));
////		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,0));
//     	log.info("User enter the First Name");
//	}

	@When("Enter the First Name")
	public void i_enter_the_FirstName() throws Throwable {
//		readCompleteDataFromEXcel();
		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(), ReadDatafromJson("Contact_Name", "FirstName"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,0));
		log.info("User enter the First Name");
	}

	//	@When("Enter the Last Name")
//	public void i_enter_the_LastName() throws Throwable {
//		enterData(PageObjectManager.getInstance().getLoginPage().getLastName(),readPropertyFileData().getProperty("LastName"));
////		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,1));
//		log.info("User enter the Last Name");
//	}
	@When("Enter the Last Name")
	public void i_enter_the_LastName() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getLastName(), ReadDatafromJson("Contact_Name", "LastName"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,1));
		log.info("User enter the Last Name");
	}

	@Then("Click on Search Button")
	public void I_Click_Search_Button() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getSearchButton());
		log.info("User click the Contact Name Button");
		Thread.sleep(10000);
	}

	@Then("Validate Email Text Box is displayed")
	public void I_Validate_Email_TextBox() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getSearchButton());
		log.info("User click the Contact Name Button");
	}

	@Then("Validate Password Text Box is displayed")
	public void I_Validate_Password_TextBox() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getSearchButton());
		log.info("User click the Contact Name Button");
	}

	@Then("Click on FAQ")
	public void I_Click_FAQ() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getFaq());
		log.info("User click the Contact Name Button");
	}

	@Then("Click on Remember Me")
	public void I_Click_Remember_Me() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getRememberMe());
		log.info("User click the Contact Name Button");
	}

	@When("Click on Forget Password")
	public void I_Click_Forgot_Password() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getForgotPassword());
		log.info("User click the Contact Name Button");
	}

	@Then("Click On Login Button")
	public void I_Click_Login_Button() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getLoginButton());
		log.info("User click Click On Login Button");
	}

	@Then("Validate Email Field is displayed")
	public void I_Email_Field() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getEmailPlaceholder().isDisplayed());
		log.info("Validate Email Field is displayed");
	}

	@Then("Validate Password Field is displayed")
	public void I_Validate_Password_Field() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getPasswordPlaceholder().isDisplayed());
		log.info("Validate Password Field is displayed");
	}

	@Then("Validate Login Page Title is displayed")
	public void I_Validate_Page_Title() throws Throwable {
		log = readLog4jData();
		log.info("Validate Login Page Title is displayed");
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getLoginTitle().isDisplayed());
		log.info("Validate Login Page Title is displayed");
	}

	@Then("Validate FAQ Link is displayed")
	public void I_Validate_FAQ() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getFaq().isDisplayed());
		log.info("Validate FAQ Link is displayed");
	}

	@Then("Validate Remember Me Checkbox is displayed")
	public void I_Validate_Remember_Me() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getRememberMe().isDisplayed());
		log.info("Validate Remember Me Checkbox is displayed");
	}

	@Then("Validate Forgot Password Link is displayed")
	public void I_Validate_Forgot_Password() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getForgotPassword().isDisplayed());
		log.info("Validate Forgot Password Link is displayed");
	}

	@Then("Validate Login Button is displayed")
	public void I_Validate_Login_Button() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getLoginButton().isDisplayed());
		log.info("Validate Login Button is displayed");
	}
//	@When("Enter Invalid Username")
//	public void i_enter_invalid_username() {
//		enterData(PageObjectManager.getInstance().getLoginPage().getUserName(),
//				readPropertyFileData().getProperty("InvalidUserName"));
//		log.info("User enter Invalid Usernamee");
//	}

	@When("Enter Invalid Username")
	public void i_enter_invalid_username() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getUserName(), ReadDatafromJson("Contact_Name", "InvalidUserName"));
		log.info("User enter Invalid Username");
	}

//	@When("Enter Invalid Password")
//	public void i_enter_invalid_password() {
//		enterData(PageObjectManager.getInstance().getLoginPage().getPassword(),
//				readPropertyFileData().getProperty("InvalidPassword"));
//		log.info("User enter Enter Invalid Password");
//	}

	@When("Enter Invalid Password")
	public void i_enter_invalid_password() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getPassword(), ReadDatafromJson("Contact_Name", "InvalidPassword"));
		log.info("User enter Enter Invalid Password");
	}

	@Then("Validate Error Text when Tried with Invalid Username and Valid Password")
	public void I_Validate_InvalidUsername_validPassword_Field() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getInvalidUsernameResult().isDisplayed());
		log.info("Validate Error Text when Tried with Invalid Username and Valid Password");
	}

	@Then("Validate Error Text when Tried with Invalid Username and Invalid Password")
	public void I_Validate_InvalidUsername_InvalidPassword_Field() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getInvalidUsernamepasswordResult().isDisplayed());
		log.info("Validate Error Text when Tried with Invalid Username and Invalid Password");
	}

	@Then("Validate Error Text when Tried with Invalid Password and Invalid Username")
	public void I_Validate_InvalidPassword_InvalidUsername_Field() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getInvalidpasswordUsernameResult().isDisplayed());
		log.info("Validate Error Text when Tried with Invalid Password and Invalid Username");
	}

	@When("Verify Contact Name is displayed")
	public void I_verify_Contact_Name() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getContactName().isDisplayed());
		log.info("Verify Contact Name is displayed");
	}

	@When("Verify First Name is displayed")
	public void i_verify_FirstName() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getFirstName().isDisplayed());
		log.info("Verify First Name is displayed");
		Thread.sleep(5000);
	}

	@When("Verify Last Name is displayed")
	public void i_verify_LastName() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getLastName().isDisplayed());
		log.info("Verify Last Name is displayed");
		Thread.sleep(5000);
	}

	@When("Verify Individual section is displayed")
	public void i_verify_Individualsection() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getIndividualsection().isDisplayed());
		log.info("Verify Individual section is displayed");
		Thread.sleep(5000);
	}

	//	@When("Enter the First Name with Integer Value")
//	public void i_enter_the_FirstName_with_Integer_Value() throws Throwable {
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),
//				readPropertyFileData().getProperty("FirstName_Integer"));
//		log.info("User enter the First Name");
//		Thread.sleep(3000);
//	}
	@When("Enter the First Name with Integer Value")
	public void i_enter_the_FirstName_with_Integer_Value() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),
				ReadDatafromJson("Contact_Name", "FirstName_Integer"));
		log.info("User enter the First Name");
		Thread.sleep(3000);
	}

	//	@When("Enter the Last Name with Integer Value")
//	public void i_enter_the_LastName_with_Integer_Value() throws Throwable {
//		enterData(PageObjectManager.getInstance().getLoginPage().getLastName(),
//				readPropertyFileData().getProperty("LastName_Integer"));
//		log.info("User enter the Last Name");
//		Thread.sleep(3000);
//	}
	@When("Enter the Last Name with Integer Value")
	public void i_enter_the_LastName_with_Integer_Value() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getLastName(),
				ReadDatafromJson("Contact_Name", "LastName_Integer"));
		log.info("User enter the Last Name");
		Thread.sleep(3000);
	}

	@And("Verify Error Message is displayed When search with FirstName and LastName only Integer")
	public void i_verify_ContactSearchwithinteger() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getContactSearchwithInteger().isDisplayed());
		log.info("Verify Individual section is displayed");
		Thread.sleep(10000);
	}

	@When("Verify Forget Email Address Field is displayed")
	public void i_verify_Forget_Email_Field() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getForgetPasswordEmail().isDisplayed());
		log.info("Verify Forget Email Address Field is displayed");
		Thread.sleep(5000);
	}
//	@When("Enter Forget Email Address")
//	public void i_enter_the_Forget_Email() throws Throwable {
//		enterData(PageObjectManager.getInstance().getLoginPage().getForgetPasswordEmail(),
//				readPropertyFileData().getProperty("Email"));
//		log.info("Enter Forget Email Address");
//		Thread.sleep(5000);
//	}

	@When("Enter Forget Email Address")
	public void i_enter_the_Forget_Email() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getForgetPasswordEmail(),
				readPropertyFileData().getProperty("Email"));
		log.info("Enter Forget Email Address");
		Thread.sleep(5000);
	}

	@When("Verify Reset Password Button is displayed")
	public void i_verify_Forget_Reset_Email_Field() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getResetPasswordButton().isDisplayed());
		log.info("Verify Forget Email Address Field is displayed");
		Thread.sleep(3000);
	}

	@And("Click On Reset Password Button")
	public void I_Click_Resert_Password_Button() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getResetPasswordButton());
		log.info("User click Click On Login Button");
		Thread.sleep(3000);
	}

	@When("Verify Contact Email is displayed")
	public void I_verify_Contact_Email() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getContactEmail().isDisplayed());
		log.info("Verify Contact Name is displayed");
	}

	@And("Click On Contact Email")
	public void I_Click_Contact_Email_Button() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getContactEmail());
		log.info("User click Click On Login Button");
	}

	@And("Verify Error Message is displayed When search with Invalid Email Address")
	public void i_verify_ContactSearchwithinvalidEmail() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getContactSearchwithInteger().isDisplayed());
		log.info("Verify Individual section is displayed");
	}

	//	@When("Enter Contact Email Address")
//	public void i_enter_the_Contact_Email() throws Throwable {
//		enterData(PageObjectManager.getInstance().getLoginPage().getContactEmailInputbox(),
//				readPropertyFileData().getProperty("Email"));
//		log.info("Enter Forget Email Address");
//	}
	@When("Enter Contact Email Address")
	public void i_enter_the_Contact_Email() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getContactEmailInputbox(),
				ReadDatafromJson("Contact_Name", "Email"));
		log.info("Enter Forget Email Address");
	}

	/*
	@Then("Clear Text in Password Field")
	public void I_clear_text_Username() {
		clickButton(PageObjectManager.getInstance().getLoginPage().getForgotPassword().clear());
		driver.findElement(By.xpath(PageObjectManager.getInstance().getLoginPage().getForgotPassword()).clear());
		log.info("User click the Contact Name Button");
	}
*/
	@When("Clear the Text in Username Field")
	public void i_Clear_username() throws Throwable {
		clearText(PageObjectManager.getInstance().getLoginPage().getUserName());
		log.info("Clear the Text in Username Field");
	}

	@When("Clear the Text in Password Field")
	public void i_clear_password() throws Throwable {
		clearText(PageObjectManager.getInstance().getLoginPage().getPassword());
		log.info("Clear the Text in Password Field");
	}

	@When("Clear the Text in First Name Field")
	public void i_clear_the_FirstName() throws Throwable {
		clearText(PageObjectManager.getInstance().getLoginPage().getFirstName());
		log.info("Clear the Text in First Name Field");
	}

	@When("Clear the Text in Last Name Field")
	public void i_clear_the_LastName() throws Throwable {
		clearText(PageObjectManager.getInstance().getLoginPage().getLastName());
		log.info("Clear the Text in Last Name Field");
	}

	@When("Clear the Text in Contact Email Field")
	public void i_clear_the_contactEmail() throws Throwable {
		clearText(PageObjectManager.getInstance().getLoginPage().getContactEmailInputbox());
		log.info("Clear the Text in First Name Field");
	}

	//	@When("Enter Invalid Contact Email Address")
//	public void i_enter_the_invalid_Contact_Email() throws Throwable {
//		enterData(PageObjectManager.getInstance().getLoginPage().getContactEmailInputbox(),
//				readPropertyFileData().getProperty("InvalidEmail"));
//		log.info("Enter Invalid Contact Email Address");
//	}
	@When("Enter Invalid Contact Email Address")
	public void i_enter_the_invalid_Contact_Email() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getContactEmailInputbox(),
				ReadDatafromJson("Contact_Name", "InvalidEmail"));
		log.info("Enter Invalid Contact Email Address");
	}

	@When("Verify Job Level is displayed")
	public void I_verify_Job_Level() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getContactJobLevel().isDisplayed());
		log.info("Verify Contact Name is displayed");
	}

	@And("Click On Job Level")
	public void I_Click_Job_Level_Button() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getContactJobLevel());
		log.info("User click Click On Login Button");
	}

	@When("Verify Role Section is displayed")
	public void I_verify_Role_Section() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getRolesection().isDisplayed());
		log.info("Verify Contact Name is displayed");
	}

	@When("Verify Job Level Select All Option is displayed")
	public void I_verify_job_level_Select_all() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getJobLevelSelectAll().isDisplayed());
		log.info("Verify Job Level Select All Option is displayed");
	}

	@And("Click On Job Level Select All Option")
	public void I_Click_Job_Level_Select_all_Button() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getJobLevelSelectAll());
		log.info("User click Click On Login Button");
	}

	@When("Verify Job Level Board Member Option is displayed")
	public void I_verify_job_level_Board_Memeber() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getJobBoardMember().isDisplayed());
		log.info("erify Job Level Board Member Option is displayed");
	}

	@And("Click On Job Level Board Member Option")
	public void I_Click_Job_Level_Button_Board_Member() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getJobBoardMember());
		log.info("User click Click On Login Button");
	}

	@When("Verify Job Level C-Level Executive Option is displayed")
	public void I_verify_job_level_cexecutive() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getJobclevelexecutive().isDisplayed());
		log.info("Verify Job Level C-Level Executive Option is displayed");
	}

	@And("Click On Job Level C-Level Executive Option")
	public void I_Click_Job_Level_clevel_Button() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getJobclevelexecutive());
		log.info("User click Click On Login Button");
	}

	@When("Verify Job Level Vice President Option is displayed")
	public void I_verify_job_Vicepresident() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getJobVicepresident().isDisplayed());
		log.info("Verify Job Level Vice President Option is displayed");
	}

	@And("Click On Job Level Vice President Option")
	public void I_Click_Job_Level_Vicepresident_Button() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getJobVicepresident());
		log.info("User click Click On Login Button");
	}

	@When("Verify Job Level Directors Option is displayed")
	public void I_verify_job_level_directors() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getJobDirectors().isDisplayed());
		log.info("Verify Job Level Directors Option is displayed");
	}

	@And("Click On Job Level Directors Option")
	public void I_Click_Job_Level_Button_Directors() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getJobDirectors());
		log.info("User click Click On Login Button");
	}

	@When("Verify Job Level Managers Option is displayed")
	public void I_verify_job_level_managers() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getJobManagers().isDisplayed());
		log.info("Verify Job Level Managers Option is displayed");
	}

	@And("Click On Job Level Manager Option")
	public void I_Click_Job_Level_Button_Manager() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getJobManagers());
		log.info("User click Click On Login Button");
	}

	@And("Validate Search Result")
	public void I_Validate_Search_Result() {
		List<WebElement> allElement = driver.findElements(By.xpath("//*[contains(text(),'Vikas')]"));
		for (WebElement eachElement : allElement) {
			String actualValue = eachElement.getText();
			if (actualValue.contains("Vikas")) {
				System.out.println("The Actual Result values: " + actualValue);
				Assert.assertTrue(actualValue.contains("Vikas"));
			} else {
				System.out.println("Both Actual and Expected are mismatching");
			}
		}
		log.info("Validate Search Result");
	}

	@And("Validate Company Search Result")
	public void I_Validate_Company_Search_Result() {
		List<WebElement> allElement = driver.findElements(By.xpath("//*[contains(text(),'Adobe')]"));
		for (WebElement eachElement : allElement) {
			String actualValue = eachElement.getText();
			if (actualValue.contains("Adobe")) {
				System.out.println("The Actual Result values: " + actualValue);
				Assert.assertTrue(actualValue.contains("Adobe"));
			} else {
				System.out.println("Both Actual and Expected are mismatching");
			}
		}
		log.info("Validate Search Result");
	}

	//	@When("Enter the Search First Name1")
//	public void i_enter_the_FirstName1() throws Throwable {
////		readCompleteDataFromEXcel();
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(), readPropertyFileData().getProperty("FirstName1"));
////		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,0));
//		log.info("Enter the Search First Name1");
//	}
	@When("Enter the Search First Name1")
	public void i_enter_the_FirstName1() throws Throwable {
//		readCompleteDataFromEXcel();
		Thread.sleep(3000);
		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(), ReadDatafromJson("Contact_Name", "FirstName1"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,0));
		log.info("Enter the Search First Name1");
	}

	//	@When("Enter the Search Last Name1")
//	public void i_enter_the_LastName1() throws Throwable {
//		enterData(PageObjectManager.getInstance().getLoginPage().getLastName(),readPropertyFileData().getProperty("LastName1"));
////		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,1));
//		log.info("Enter the Search Last Name1");
//	}
	@When("Enter the Search Last Name1")
	public void i_enter_the_LastName1() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getLastName(), ReadDatafromJson("Contact_Name", "LastName1"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,1));
		log.info("Enter the Search Last Name1");
	}

	@And("Click On Contact Search1")
	public void I_Click_Contact_search1() throws Throwable {
		String Contactsearchname1 = ReadDatafromJson("Contact_Name", "ContactSearch1");
//		driver.findElement(By.xpath("//*[contains(text(),\'"+Contactsearchname1+"\')]"));
		clickButton(driver.findElement(By.xpath("//*[contains(text(),\'" + Contactsearchname1 + "\')]")));
		System.out.println("The Label Name is: " + driver.findElement(By.xpath("//*[contains(text(),\'" + Contactsearchname1 + "\')]")).getText());
//		clickButton(PageObjectManager.getInstance().getLoginPage().getContactSearch1());
		log.info("User click Click On Login Button");
		Thread.sleep(3000);
	}

	@When("Verify Reveal Contact Search Button is displayed")
	public void I_verify_Reveal_Search_Button() throws Throwable {
		Assert.assertTrue(PageObjectManager.getInstance().getLoginPage().getContactSearchReveal().isDisplayed());
		log.info("Verify Job Level Managers Option is displayed");
		Thread.sleep(3000);
	}

	@And("Click On Reveal Contact Search Button")
	public void I_Click_Reveal_Contact_search() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getContactSearchReveal());
		log.info("User click Click On Login Button");
		Thread.sleep(3000);
	}

	@And("Get the Total Reveal Count")
	public void I_get_Total_Reveal_Count() throws Throwable {
//		gettext(PageObjectManager.getInstance().getLoginPage().getUpdatedReveal());
		System.out.println(PageObjectManager.getInstance().getLoginPage().getUpdatedReveal().getText());
		log.info("User click Click On Login Button");
		Thread.sleep(3000);
	}

	//	@When("Enter the Search First Name2")
//	public void i_enter_the_FirstName2() throws Throwable {
////		readCompleteDataFromEXcel();
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(), readPropertyFileData().getProperty("FirstName2"));
////		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,0));
//		log.info("Enter the Search First Name2");
//	}
	@When("Enter the Search First Name2")
	public void i_enter_the_FirstName2() throws Throwable {
//		readCompleteDataFromEXcel();
		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(), ReadDatafromJson("Contact_Name", "FirstName2"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,0));
		log.info("Enter the Search First Name2");
	}

	//	@When("Enter the Search Last Name2")
//	public void i_enter_the_LastName2() throws Throwable {
//		enterData(PageObjectManager.getInstance().getLoginPage().getLastName(),readPropertyFileData().getProperty("LastName2"));
////		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,1));
//		log.info("Enter the Search Last Name2");
//	}
	@When("Enter the Search Last Name2")
	public void i_enter_the_LastName2() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getLastName(), ReadDatafromJson("Contact_Name", "LastName2"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,1));
		log.info("Enter the Search Last Name2");
	}

	@And("Click On Contact Search2")
	public void I_Click_Contact_search2() throws Throwable {
		String Contactsearchname2 = ReadDatafromJson("Contact_Name", "ContactSearch2");
//		driver.findElement(By.xpath("//*[contains(text(),\'"+Contactsearchname1+"\')]"));
		clickButton(driver.findElement(By.xpath("//*[contains(text(),\'" + Contactsearchname2 + "\')]")));
		log.info("User click Click On Login Button");
		Thread.sleep(3000);
	}

	//	@When("Enter the Search First Name3")
//	public void i_enter_the_FirstName3() throws Throwable {
////		readCompleteDataFromEXcel();
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(), readPropertyFileData().getProperty("FirstName3"));
////		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,0));
//		log.info("Enter the Search First Name2");
//	}
	@When("Enter the Search First Name3")
	public void i_enter_the_FirstName3() throws Throwable {
//		readCompleteDataFromEXcel();
		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(), ReadDatafromJson("Contact_Name", "FirstName3"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,0));
		log.info("Enter the Search First Name2");
	}

	//	@When("Enter the Search Last Name3")
//	public void i_enter_the_LastName3() throws Throwable {
//		enterData(PageObjectManager.getInstance().getLoginPage().getLastName(),readPropertyFileData().getProperty("LastName3"));
////		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,1));
//		log.info("Enter the Search Last Name2");
//	}
	@When("Enter the Search Last Name3")
	public void i_enter_the_LastName3() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getLastName(), ReadDatafromJson("Contact_Name", "LastName3"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,1));
		log.info("Enter the Search Last Name2");
	}

	//	@And("Click On Contact Search3")
//	public void I_Click_Contact_search3() throws Throwable {
//		clickButton(PageObjectManager.getInstance().getLoginPage().getContactSearch3());
//		log.info("User click Click On Login Button");
//		Thread.sleep(3000);
//	}
	@And("Click On Contact Search3")
	public void I_Click_Contact_search3() throws Throwable {
		String Contactsearchname3 = ReadDatafromJson("Contact_Name", "ContactSearch3");
//		driver.findElement(By.xpath("//*[contains(text(),\'"+Contactsearchname1+"\')]"));
		clickButton(driver.findElement(By.xpath("//*[contains(text(),\'" + Contactsearchname3 + "\')]")));
		log.info("User click Click On Login Button");
		Thread.sleep(3000);
	}

	//	@When("Enter the Search First Name4")
//	public void i_enter_the_FirstName4() throws Throwable {
////		readCompleteDataFromEXcel();
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(), readPropertyFileData().getProperty("FirstName4"));
////		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,0));
//		log.info("Enter the Search First Name2");
//	}
	@When("Enter the Search First Name4")
	public void i_enter_the_FirstName4() throws Throwable {
//		readCompleteDataFromEXcel();
		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(), ReadDatafromJson("Contact_Name", "FirstName4"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,0));
		log.info("Enter the Search First Name2");
	}
//	@When("Enter the Search Last Name4")
//	public void i_enter_the_LastName4() throws Throwable {
//		enterData(PageObjectManager.getInstance().getLoginPage().getLastName(),readPropertyFileData().getProperty("LastName4"));
////		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,1));
//		log.info("Enter the Search Last Name2");
//	}

	@When("Enter the Search Last Name4")
	public void i_enter_the_LastName4() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getLastName(), ReadDatafromJson("Contact_Name", "LastName4"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,1));
		log.info("Enter the Search Last Name2");
	}

	@And("Click On Contact Search4")
	public void I_Click_Contact_search4() throws Throwable {
		String Contactsearchname4 = ReadDatafromJson("Contact_Name", "ContactSearch4");
//		driver.findElement(By.xpath("//*[contains(text(),\'"+Contactsearchname1+"\')]"));
		clickButton(driver.findElement(By.xpath("//*[contains(text(),\'" + Contactsearchname4 + "\')]")));
		log.info("User click Click On Login Button");
		Thread.sleep(3000);
	}

	//	@When("Enter the Search First Name5")
//	public void i_enter_the_FirstName5() throws Throwable {
////		readCompleteDataFromEXcel();
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(), readPropertyFileData().getProperty("FirstName5"));
////		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,0));
//		log.info("Enter the Search First Name2");
//	}
	@When("Enter the Search First Name5")
	public void i_enter_the_FirstName5() throws Throwable {
//		readCompleteDataFromEXcel();
		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(), ReadDatafromJson("Contact_Name", "FirstName5"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,0));
		log.info("Enter the Search First Name2");
	}

//	@When("Enter the Search Last Name5")
//	public void i_enter_the_LastName5() throws Throwable {
//		enterData(PageObjectManager.getInstance().getLoginPage().getLastName(),readPropertyFileData().getProperty("LastName5"));
////		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,1));
//		log.info("Enter the Search Last Name2");
//	}

	@When("Enter the Search Last Name5")
	public void i_enter_the_LastName5() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getLastName(), ReadDatafromJson("Contact_Name", "LastName5"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,1));
		log.info("Enter the Search Last Name2");
	}

	@And("Click On Contact Search5")
	public void I_Click_Contact_search5() throws Throwable {
		String Contactsearchname5 = ReadDatafromJson("Contact_Name", "ContactSearch5");
//		driver.findElement(By.xpath("//*[contains(text(),\'"+Contactsearchname1+"\')]"));
		clickButton(driver.findElement(By.xpath("//*[contains(text(),\'" + Contactsearchname5 + "\')]")));
		log.info("User click Click On Login Button");
		Thread.sleep(3000);
	}

	@And("Click On Clear Button")
	public void I_Click_clear_Button() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getClearbutton());
		log.info("User click on Clear Button");
	}

	@And("Click On Do Not Save Button")
	public void I_Click_do_not_save_Button() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getDonotsavebutton());
		log.info("User click on Clear Button");
	}

	@And("Click On Fast Growing Contact List")
	public void I_Click_fast_growing_list() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getFastgrowingContact());
		log.info("User click on Clear Button");
	}

	@And("Click On Add all to List")
	public void I_Click_add_all_list() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getAddalltolistbutton());
		log.info("User click on Add All to List");
	}

	@And("Click On Create New Contact List")
	public void I_Click_create_new_list() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getCreatenewcontactlist());
		log.info("User click on Create New Contact List");
	}

	//	@When("Enter New Contact List")
//	public void i_enter_the_contact_list() throws Throwable {
//		enterData(PageObjectManager.getInstance().getLoginPage().getEntercreatenamelist(),
//				readPropertyFileData().getProperty("Contactlist"));
//		log.info("User Enter New Contact List");
//	}
	@When("Enter New Contact List")
	public void i_enter_the_contact_list() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getEntercreatenamelist(),
				ReadDatafromJson("Contact_Name", "Contactlist"));
		log.info("User Enter New Contact List");
	}

	@And("Click On Create New Contact List Save Button")
	public void I_Click_create_new_list_save_button() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getcreatenamelistsavebutton());
		System.out.println("Clicked on Save Button");
		log.info("User click on Create New Contact List Save Button");
	}

	@And("Click On Add Contact List Save Button")
	public void I_Click_Add_list_save_button() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getcreatenamelistsavebutton());
		log.info("User click on Create New Contact List Save Button");
	}
	@And("Click On Add Company List Save Button")
	public void I_Click_Add_Company_list_save_button() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getcreatenamelistsavebutton());
		log.info("User click on Create New Contact List Save Button");
	}
	@And("Click On List Tab")
	public void I_Click_List_Tab() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getListtab());
		log.info("User click on List Tab");
	}

	@And("Select Multiple contact to Add Contact List")
	public void I_select_multiple_Contacts() {
		for (int i = 1; i < 6; i++) {
			driver.findElements(By.xpath("(//input[@type='checkbox' and @title='Select'])[" + i + "]")).get(0).click();
			//System.out.println(driver.findElements(By.xpath("(//input[@type='checkbox' and @title='Select'])["+i+"]")).size());
		}
		log.info("Select Multiple contact to Add Contact List");
	}

	@And("Select Multiple Company to Add Company List")
	public void I_select_multiple_Company() {
		for (int i = 1; i < 6; i++) {
			driver.findElements(By.xpath("(//input[@type='checkbox' and @title='Select'])[" + i + "]")).get(0).click();
			//System.out.println(driver.findElements(By.xpath("(//input[@type='checkbox' and @title='Select'])["+i+"]")).size());
		}
		log.info("Select Multiple Company to Add Company List");
	}
	@And("Append Contact details into the List")
	public void I_append_multiple_Contacts() {
		Contactlist = new LinkedList<>();
		for (int i = 1; i < 6; i++) {
			String Contactname = driver.findElements(By.xpath("((//input[@type='checkbox' and @title='Select'])[" + i + "]//following::span)[" + i + "]")).get(0).getText();
			//System.out.println(driver.findElements(By.xpath("(//input[@type='checkbox' and @title='Select'])["+i+"]")).size());
			Contactlist.add(Contactname);
		}
		log.info("Select Multiple contact to Add Contact List");
	}

	@And("Append Company details into the List")
	public void I_append_multiple_Company() {
		Contactlist = new LinkedList<>();
		for (int i = 1; i < 6; i++) {
			String Companyname = driver.findElements(By.xpath("((//input[@type='checkbox' and @title='Select'])[" + i + "]//following::span)[" + i + "]")).get(0).getText();
			//System.out.println(driver.findElements(By.xpath("(//input[@type='checkbox' and @title='Select'])["+i+"]")).size());
			Contactlist.add(Companyname);
		}
		log.info("Append Company details into the List");
	}

	@Then("Select Preview Button")
	public void I_Select_Preview_Button() throws InterruptedException {
		Thread.sleep(5000);
		Actions Clickpreview = new Actions(driver);
		String contactlistnamesearch = readPropertyFileData().getProperty("Contactlist");
		Clickpreview.doubleClick(driver.findElement(By.xpath("(//*[contains(text(),'" + contactlistnamesearch + "')])[2]//following::button[@title='Preview']"))).build().perform();
		//driver.findElement(By.xpath("(//*[contains(text(),'"+contactlistnamesearch+"')])[2]//following::button[@title='Preview']"))
		log.info("Select Multiple contact to Add Contact List");
	}

	@And("Compare Contact details into the List")
	public void I_compare_multiple_Contacts() {
		Comparelist = new LinkedList<>();
		for (int i = 1; i < 3; i++) {
			String Comparename = driver.findElements(By.xpath("((//input[@type='checkbox' and @title='Select'])[" + i + "]//following::span)[" + i + "]")).get(0).getText();
			//System.out.println(driver.findElements(By.xpath("(//input[@type='checkbox' and @title='Select'])["+i+"]")).size());
			Comparelist.add(Comparename);
		}
		System.out.println(Contactlist);
		System.out.println(Comparelist);
		Assert.assertTrue(Contactlist.equals(Comparelist));
		Contactlist.retainAll(Comparelist);
		log.info("Select Multiple contact to Add Contact List");
	}

	@And("Delete Contact List")
	public void I_Delete_Contact_List() throws Throwable {
		Thread.sleep(5000);
		Actions Clickpreview = new Actions(driver);
		String contactlistnamesearch = ReadDatafromJson("Contact_Name", "Contactlist");
		Clickpreview.doubleClick(driver.findElement(By.xpath("(//*[contains(text(),'" + contactlistnamesearch + "')])[2]//following::button[@title='Delete']"))).build().perform();
		//driver.findElement(By.xpath("(//*[contains(text(),'"+contactlistnamesearch+"')])[2]//following::button[@title='Preview']"))
		log.info("Select Multiple contact to Add Contact List");
	}

	@And("Delete Company List")
	public void I_Delete_Company_List() throws Throwable {
		Thread.sleep(5000);
		Actions Clickpreview = new Actions(driver);
		String contactlistnamesearch = ReadDatafromJson("Contact_Name", "Companylist");
		Clickpreview.doubleClick(driver.findElement(By.xpath("(//*[contains(text(),'" + contactlistnamesearch + "')])[2]//following::button[@title='Delete']"))).build().perform();
		//driver.findElement(By.xpath("(//*[contains(text(),'"+contactlistnamesearch+"')])[2]//following::button[@title='Preview']"))
		log.info("Select Multiple contact to Add Contact List");
	}

	@And("Click On Delete Contact List")
	public void I_delete_contact_list() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getDeletecontactList());
		log.info("Click On Delete Contact List");
	}

	@And("Click On Delete Company List")
	public void I_delete_company_list() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getDeletecontactList());
		log.info("Click On Delete Company List");
	}
	@Then("Click On Contact Tab")
	public void I_contact_Tab() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getContactsTab());
		log.info("User click on Clear Button");
	}

	@When("Enter the First Name to search")
	public void i_enter_the_FirstName_to_search() throws Throwable {
//		readCompleteDataFromEXcel();
		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(), ReadDatafromJson("Contact_Name", "Search_name"));
//		enterData(PageObjectManager.getInstance().getLoginPage().getFirstName(),readData(0,0));
		log.info("User enter the First Name");
	}
	@And("Validate Contact Search Result")
	public void I_Validate_Contact_Search_Result() {
		List<WebElement> allElement = driver.findElements(By.xpath("//*[contains(text(),'Micheal')]"));
		for (WebElement eachElement : allElement) {
			String actualValue = eachElement.getText();
			if (actualValue.contains("Micheal")) {
				System.out.println("The Actual Result values: " + actualValue);
				Assert.assertTrue(actualValue.contains("Micheal"));
			} else {
				System.out.println("Both Actual and Expected are mismatching");
			}
		}
		log.info("Validate Search Result");
	}
	@And("Click On Add all Contact to Existing List")
	public void I_Click_Add_all_Contact_Existing_List() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getAddtoexistinglist());
		log.info("User Click On Add all Contact to Existing List");
	}
	@And("Click on Contact List Drop Down Option")
	public void I_Click_Contact_List_Drop_Down() throws Throwable {
		Select selectcontact = new Select(PageObjectManager.getInstance().getLoginPage().getContactListDropdown());
		selectcontact.selectByVisibleText(ReadDatafromJson("Contact_Name", "Contactlist"));
		log.info("User Click On Add all Contact to Existing List");
	}
	@And("Click on Company List Drop Down Option")
	public void I_Click_Company_List_Drop_Down() throws Throwable {
		Select selectcompany = new Select(PageObjectManager.getInstance().getLoginPage().getContactListDropdown());
		selectcompany.selectByVisibleText(ReadDatafromJson("Contact_Name", "Companylist"));
		log.info("User Click on Company List Drop Down Option");
	}
	@Then("Click On Company Tab")
	public void I_company_Tab() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getCompanyTab());
		log.info("User click on Clear Button");
		Thread.sleep(5000);
	}
	@Then("Click On Company")
	public void I_company_option() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getCompanyName());
		log.info("User click on Clear Button");
	}
	@When("Enter Valid Company Name")
	public void i_enter_the_company_name() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getCompanyInput(),
				ReadDatafromJson("Contact_Name", "Company_name"));
		log.info("User Enter Valid Company Name");
	}
	@And("Click On Create New Company List")
	public void I_Click_create_new_Company_list() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getCreatenewcompanylist());
		log.info("User Click On Create New Company List");
	}
	@And("Click On Add Existing Company List")
	public void I_Click_add_Existing_Company_list() throws Throwable {
		clickButton(PageObjectManager.getInstance().getLoginPage().getAddtoexistingcompanylist());
		log.info("User Click On Add Existing Company List");
	}
	@When("Enter New Company List")
	public void i_enter_the_company_list() throws Throwable {
		enterData(PageObjectManager.getInstance().getLoginPage().getEntercreatenamelist(),
				ReadDatafromJson("Contact_Name", "Companylist"));
		log.info("User Enter New Company List");
	}
	@And("Click On Create New Company List Save Button")
	public void I_Click_create_new_Company_list_save_button() throws Throwable {
		Thread.sleep(5000);
		clickButton(PageObjectManager.getInstance().getLoginPage().getcreatenamelistsavebutton());
		System.out.println("Clicked on Save Button");
		log.info("User Click On Create New Company List Save Button");
	}
}