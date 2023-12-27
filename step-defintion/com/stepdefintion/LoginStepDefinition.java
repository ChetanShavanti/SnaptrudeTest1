package com.stepdefintion;

import com.testStep.LoginSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginStepDefinition {
  LoginSteps loginSteps = new LoginSteps();

  @Given("user is on Snaptrude login page")
  public void user_is_on_snaptrude_login_page() throws Exception {
    loginSteps.openSnapTrude();
  }

  @When("user enters user name as {string}")
  public void user_enters_user_name_as(String username) throws InterruptedException {
    loginSteps.enterUsername(username);
  }

  @When("user enters password as {string}")
  public void user_enters_password_as(String password) throws InterruptedException {
    loginSteps.enterPassword(password);
    loginSteps.closeBrowser();

  }

  //	@When("user clicks on Sign in button")
  //	public void user_clicks_on_sign_in_button() throws InterruptedException {
  //		loginSteps.clickSignInButton();
  //	    loginSteps.closeBrowser();
  //
  //	}

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
    loginSteps.closeBrowser();

  }

  @Then("user verifies test project is clicked")
  public void user_verifies_test_project_is_clicked() throws InterruptedException {
    loginSteps.verifyProjectClicked();
    loginSteps.closeBrowser();

  }

  @When("user draw a rectangle")
  public void user_draw_a_rectangle() throws InterruptedException {
    loginSteps.drawRectangle();
    loginSteps.closeBrowser();

  }

  @Then("user verifies rectangle is visible")
  public void user_verifies_rectangle_is_visible() throws InterruptedException {
    loginSteps.verifyRectangle();
    loginSteps.closeBrowser();
  }

  @When("user draw a circle")
  public void user_draw_a_circle() throws InterruptedException {
    loginSteps.drawCircle();
    loginSteps.closeBrowser();

  }

  @Then("user verifies circle is visible")
  public void user_verifies_circle_is_visible() throws InterruptedException {
    loginSteps.verifyCircle();
    loginSteps.closeBrowser();
  }

  @When("user draw a Hexagon")
  public void user_draw_a_Hexagon() throws InterruptedException {

    loginSteps.drawHexagon();
    loginSteps.closeBrowser();
  }

  @Then("user verifies Hexagon is visible")
  public void user_verifies_Hexagon_is_visible() throws InterruptedException {
    loginSteps.verifyHexagon();
    loginSteps.closeBrowser();

  }

  @When("user draw a Walls")
  public void user_draw_a_walls() throws InterruptedException {
    loginSteps.drawWalls();
    loginSteps.closeBrowser();
  }

  @Then("user verifies Walls are visible")
  public void user_verifies_walls_are_visible() throws InterruptedException {
    loginSteps.verifyHexagon();
    loginSteps.closeBrowser();
  }

  @When("user draw a Floor")
  public void user_draw_a_floor() throws InterruptedException {

    loginSteps.drawFloor();
    loginSteps.closeBrowser();

  }

  @Then("user verifies Floor is visible")
  public void user_verifies_floor_is_visible() throws InterruptedException {
    loginSteps.verifyFloor();
    loginSteps.closeBrowser();
  }



}