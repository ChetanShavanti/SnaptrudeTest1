package com.testStep;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;

import java.awt.MouseInfo;
import java.awt.PointerInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;

public class LoginSteps {
  public String before = null;
  private WebDriver driver;

  public LoginSteps() {
    // Initialize WebDriver in the constructor
    System.setProperty("webdriver.chrome.driver", "E:\\JAVA\\JavaSoft\\ChromeDriverFolder\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

  public void openSnapTrude() throws InterruptedException {
    driver.get("https://app.snaptrude.com/login");
    Thread.sleep(5000);

  }

  public void enterUsername(String username) throws InterruptedException {
    driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]")).sendKeys(username);
    Thread.sleep(2000);
  }

  public void enterPassword(String password) throws InterruptedException {
    driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[@type='submit']")).click();

  }

  //    public void clickSignInButton() throws InterruptedException{
  //    	
  //    	driver.findElement(By.xpath( "//button[@type='submit']"	 )).click();
  //
  //        Thread.sleep(5000);
  //
  //    }

  public void verifyUserIDNotFoundErrorMessage() throws InterruptedException {
    Thread.sleep(2000);
    boolean wrongID = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[1]/div")).isDisplayed();
    System.out.println(wrongID);
    if (wrongID) {
      System.out.println("Wrong User ID Testcase Passed ");
      Thread.sleep(8000);

    }
  }

  public void verifyIncorrectUserNameOrPasword() throws InterruptedException {
    Thread.sleep(2000);
    boolean wrongPass = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[1]/div")).isDisplayed();
    System.out.println(wrongPass);
    if (wrongPass) {
      System.out.println("Test case Passed ");
      Thread.sleep(8000);

    }
  }

  public void verifyUserNameAndPaswordAreCorrect() throws InterruptedException {
    Thread.sleep(5000);
    boolean isMyWorkspaceVisible = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[2]/button/p")).isDisplayed();
    System.out.println(isMyWorkspaceVisible);
    if (isMyWorkspaceVisible) {

      System.out.println("  Scenario passed: Login successful.  ");
      Thread.sleep(8000);

    } else {
      System.out.println("[ Scenario failed: My Workspace is not visible on the display.   ");
    }
  }

  public void selectTestProject() throws InterruptedException {
    Thread.sleep(3000);
    driver.findElements(By.className("project-card-ready")).get(0).click();
    Thread.sleep(2000);

  }

  public void verifyProjectClicked() throws InterruptedException {

    boolean ProjectClicked = driver.findElement(By.xpath("//*[@data-tooltip-id=\"Views\"]")).isDisplayed();
    if (ProjectClicked) {
      System.out.println("Scenario passed: Project Opened successfully.");
    } else {
      System.out.println("Scenario failed: Unable To open Project.");
    }

  }

  public void drawRectangle() throws InterruptedException {
	  WebElement canvas = driver.findElement(By.id("canvas"));
	  
	  Actions actions = new Actions(driver);
	  actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
	  actions.sendKeys(Keys.DELETE).perform();
	  System.out.println("Cleared Canvas" );
	  actions.moveToElement(canvas).click().perform();
	  Thread.sleep(1000);
	  actions.moveByOffset(80, 0).click().perform();
	  Thread.sleep(1000);
	  actions.moveByOffset(0, 120).click().perform();
	  Thread.sleep(1000);
	  actions.moveByOffset(-80, 0).click().perform();
	  Thread.sleep(1000);
	  actions.moveByOffset(0, -120).click().perform();
	  Thread.sleep(2000);
	  canvas.sendKeys(Keys.ESCAPE);
	  Thread.sleep(2000);
actions.moveByOffset(5, 5).click().perform();
Thread.sleep(3000);

  }

  
  
  
  
  public void verifyRectangle() throws InterruptedException {

	  WebElement inputElement = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[9]/div[2]/div[2]/section[1]/div[2]/div[4]/div/form/div/div/div/input"));
	  String valueLength = inputElement.getAttribute("value");
	  System.out.println("Value of the input element: " + valueLength);

	  //Width of Rectangle
	  Thread.sleep(1000);
	  WebElement width = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[9]/div[2]/div[2]/section[1]/div[2]/div[5]/div/form/div/div/div/input"));
	  String valueWidth =  width.getAttribute("value");
	  System.out.println("Width  of the Object: " + valueWidth);
	  
	  
	  if (valueWidth.equals(valueLength)) {
			System.out.println("\u001B[31m Scenario 3 Failed : Unable to draw rectangle. \u001B");
		}
		else {
			System.out.println("\u001B[32m Scenario 3 Passed :  Rectangle successfully drawn. \u001B");
		}
  }

  
  
  
  
  public void drawCircle() throws InterruptedException {

    Actions actions = new Actions(driver);
	  WebElement canvas = driver.findElement(By.id("canvas"));

driver.findElement(By.xpath( " /html/body/div[1]/div[3]/div[7]/div[1]/div[4]/div[3]/div[1]/span  "	 )).click();
actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
actions.sendKeys(Keys.DELETE).perform();
System.out.println("Cleared Canvas" );
driver.findElement(By.xpath( " //*[@data-tooltip-id=\"drawCircle\"]  "	 )).click();

actions.moveByOffset(0, 0).click().perform();
Thread.sleep(2000);
actions.moveByOffset(60, 0).click().perform();
Thread.sleep(5000);
 

canvas.sendKeys(Keys.ESCAPE);
Thread.sleep(2000);


actions.moveByOffset(-30, 0).click().perform();
Thread.sleep(3000);



  }

  public void verifyCircle() throws InterruptedException {
	  WebElement inputElementRadius = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[9]/div[2]/div[2]/section[1]/div[2]/div[4]/div/form/div/div/div/input"));

if (inputElementRadius.isDisplayed()) {
	System.out.println("\u001B[32m Scenario 4 Passed : Circle is drawn radius is displayed. \u001B");
}
else {
	System.out.println("\u001B[32m Scenario 4 Failed :  Unable to draw Circle. \u001B");
}
  }

  
  
  
  
  
  
  
  
  public void drawHexagon() throws InterruptedException {
	  WebElement canvas = driver.findElement(By.id("canvas"));

    Actions actions = new Actions(driver);

Thread.sleep(5000);
actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
actions.sendKeys(Keys.DELETE).perform();
driver.findElement(By.xpath( "//*[@data-tooltip-id=\"draw\"]"	 )).click();
actions.moveByOffset(0, 0).click().perform();
actions.moveByOffset(60, 0).click().perform();
Thread.sleep(500);
actions.moveByOffset(30, 52).click().perform();
Thread.sleep(500);
actions.moveByOffset(-30, 52).click().perform();
Thread.sleep(500);
actions.moveByOffset(-60, 0).click().perform();
Thread.sleep(500);
actions.moveByOffset(-30, -52).click().perform();
Thread.sleep(500);
actions.moveByOffset(0, 0).click().perform();
Thread.sleep(500);

canvas.sendKeys(Keys.ESCAPE);

actions.moveByOffset(10, 0).click().perform();
Thread.sleep(3000);


  }

  public void verifyHexagon() throws InterruptedException {


WebElement inputElementHexa = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[9]/div[2]/div[2]/section[1]/div[2]/div[4]/div/form/div/div/div/input"));


if (inputElementHexa.isDisplayed()) {
	  driver.findElement(By.xpath( "//*[@data-tooltip-id=\"2d-3d-view-toogle\"]"	 )).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath( "//*[@data-tooltip-id=\"2d-3d-view-toogle\"]"	 )).click();
	System.out.println("\u001B[32m Scenario 5 Passed : Hexagon is drawn and  displayed a 3D view of Hexagon. \u001B");
}
else {
	System.out.println("\u001B[32m Scenario 5 Failed :  Unable to draw Circle. \u001B");
}
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  

  public void drawWalls() throws InterruptedException {

    Actions actions = new Actions(driver);
	  WebElement canvas = driver.findElement(By.id("canvas"));

actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
actions.sendKeys(Keys.DELETE).perform();

driver.findElement(By.xpath( "//*[contains(text(),'Wall')]" )).click();
Thread.sleep(1000);

//driver.findElement(By.xpath( ""	 )).get(0).click();
actions.moveByOffset(150, 0).click().perform();
Thread.sleep(1000);
actions.moveByOffset(0, 250).click().perform();
Thread.sleep(1000);
actions.moveByOffset(-150, 0).click().perform();
Thread.sleep(1000);
actions.moveByOffset(0, -250).click().perform();
Thread.sleep(2000);
actions.moveByOffset(0, 0).click().perform();
driver.findElement(By.xpath( "//*[@data-tooltip-id=\"2d-3d-view-toogle\"]"	 )).click(); //3D
Thread.sleep(50000);




Thread.sleep(2000);
canvas.sendKeys(Keys.ESCAPE);
Thread.sleep(2000);

actions.moveByOffset(0, 1).click().perform();
Thread.sleep(3000);


  }

  public void verifyWalls() throws InterruptedException {


WebElement inputElementWallProp = driver.findElement(By.xpath("//*[contains(text(),'Wall Type')]"));

if (inputElementWallProp.isDisplayed()) {
	System.out.println("\u001B[32m  Scenario 7 passed : Wall successfully drawn. \u001B ");
}
else {
	System.out.println("\u001B[31m  Scenario 7 Failed :  Unable to draw Wall. \u001B");
}

  }
  
  
  
  
  
  
  
  
  
  

  public void drawFloor() throws InterruptedException {

    Actions actions = new Actions(driver);
	  WebElement canvas = driver.findElement(By.id("canvas"));

Thread.sleep(2000);
canvas.sendKeys(Keys.ESCAPE);
driver.findElement(By.xpath( "/html/body/div[1]/div[3]/div[7]/div[1]/div[4]/div[3]/div[2]/div[1]/div[1]/img" )).click();
driver.findElement(By.xpath( "/html/body/div[1]/div[3]/div[9]/div[2]/div[2]/section[1]/div[2]/span[10]/img" )).click();
actions.moveByOffset(150, 0).click().perform();
Thread.sleep(1000);
actions.moveByOffset(0, 250).click().perform();
Thread.sleep(1000);
actions.moveByOffset(-150, 0).click().perform();
Thread.sleep(1000);
actions.moveByOffset(0, -250).click().perform();
actions.moveByOffset(0, 0).click().perform();
Thread.sleep(2000);
canvas.sendKeys(Keys.ESCAPE);
Thread.sleep(2000);
actions.moveByOffset(50, 50).click().perform();
Thread.sleep(3000);


  }

  public void verifyFloor() throws InterruptedException {
	  WebElement inputElementFloor = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[9]/div[2]/div[2]/section[1]/div[2]/div[1]/div/p"));

	  if (inputElementFloor.isDisplayed()) {
			System.out.println("\u001B[32m  Scenario 8 passed : Floor successfully drawn. \u001B ");
		}
		else {
			System.out.println("\u001B[31m  Scenario 8 Failed :  Unable to draw Floor. \u001B");
		}

  }

  
  
  
  
  

  public void closeBrowser() {
    driver.quit();
  }
}