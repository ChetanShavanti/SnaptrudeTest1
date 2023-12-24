package com.stepdefintion;

import com.testStep.LoginSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginStepDefinition {
	LoginSteps loginSteps = new LoginSteps();
	
	@Given("user is on Snaptrude login page")
	public void user_is_on_snaptrude_login_page() throws Exception {
	    System.out.println("ujhgfdf");
	    loginSteps.openSnapTrude();
	}

	@When("user enters user name as {string}")
	public void user_enters_user_name_as(String username) {
		loginSteps.enterUsername(username);
	}
	    

	@When("user enters password as {string}")
	public void user_enters_password_as(String password) {
		loginSteps.enterPassword(password);
	}

	@When("user clicks on Sign in button")
	public void user_clicks_on_sign_in_button() {
		loginSteps.clickSignInButton();
	}

	@Then("user verifies user id not found error message")
	public void user_verifies_user_id_not_found_error_message() throws InterruptedException {
	    loginSteps.verifyUserIDNotFoundErrorMessage();
	    loginSteps.closeBrowser();
	}
	
	@Then("user verifies incorrect username or password error message")
	public void user_verifies_incorrect_username_or_password_error_message() throws InterruptedException {
		loginSteps.verifyIncorrectUserNameOrPasword();
	    loginSteps.closeBrowser();
	}
	
	
	@Then("user verifies user id and password are correct")
	public void user_verifies_user_id_and_password_are_correct() throws InterruptedException {
		loginSteps.verifyUserNameAndPaswordAreCorrect();
	    loginSteps.closeBrowser();
	}
	

@When("user clicks on Test Project")
public void user_clicks_on_test_project() throws InterruptedException {
	loginSteps.selectTestProject();
	
}

@Then("user verifies test project is clicked")
public void user_verifies_test_project_is_clicked() throws InterruptedException {
	loginSteps.verifyProjectClicked();
}


@When("user draw a rectangle")
public void user_draw_a_rectangle() throws InterruptedException {
	loginSteps.drawRectangle();
}

@Then("user verifies rectangle is visible")
public void user_verifies_rectangle_is_visible() throws InterruptedException {
	loginSteps.verifyRectangle();
	loginSteps.closeBrowser();
}


@When("user draw a circle")
public void user_draw_a_circle() throws InterruptedException {
	loginSteps.drawCircle();
}

@Then("user verifies circle is visible")
public void user_verifies_circle_is_visible() throws InterruptedException {
	loginSteps.verifyCircle();
	loginSteps.closeBrowser();
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

