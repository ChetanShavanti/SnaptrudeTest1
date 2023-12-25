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
    Thread.sleep(5000);
    WebElement canvasbeforeDraw = driver.findElement(By.id("canvas-wrapper"));
    Thread.sleep(2000);
    WebElement canvas = driver.findElement(By.id("canvas"));
    Thread.sleep(500);
    before = canvasbeforeDraw.getAttribute("style");

    Actions actions = new Actions(driver);
    actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
    actions.sendKeys(Keys.DELETE).perform();
    System.out.println("Cleared Canvas");
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

    driver.findElement(By.xpath("//*[@data-tooltip-id=\"2d-3d-view-toogle\"]")).click();

    Thread.sleep(5000);

    driver.findElement(By.xpath("//*[@data-tooltip-id=\"2d-3d-view-toogle\"]")).click();

  }

  public void verifyRectangle() throws InterruptedException {

    WebElement canvasafterRectangle = driver.findElement(By.id("canvas-wrapper"));
    Thread.sleep(500);
    String afterRectangle = canvasafterRectangle.getAttribute("style");
    if (before.equals(afterRectangle)) {
      System.out.println("Scenario Failed :  Unable to draw rectangle ");
    } else {
      System.out.println("Scenario passed : Rectangle successfully drawn. ");
    }

  }

  public void drawCircle() throws InterruptedException {

    Actions actions = new Actions(driver);

    actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
    actions.sendKeys(Keys.DELETE).perform();
    System.out.println("Cleared Canvas");
    Thread.sleep(2000);
    WebElement canvasbeforeDraw = driver.findElement(By.id("canvas-wrapper"));
    Thread.sleep(2000);
    WebElement canvas = driver.findElement(By.id("canvas"));
    Thread.sleep(500);
    before = canvasbeforeDraw.getAttribute("style");

    System.out.println("Drawing the circle");

    driver.findElement(By.xpath(" //*[@data-tooltip-id=\"drawCircle\"]  ")).click();
    actions.moveByOffset(0, 0).click().perform();
    Thread.sleep(2000);
    actions.moveByOffset(60, 0).click().perform();
    Thread.sleep(2000);

    driver.findElement(By.xpath("//*[@data-tooltip-id=\"2d-3d-view-toogle\"]")).click();

    Thread.sleep(2000);

    driver.findElement(By.xpath("//*[@data-tooltip-id=\"2d-3d-view-toogle\"]")).click();

  }

  public void verifyCircle() throws InterruptedException {

    WebElement canvasafterCircle = driver.findElement(By.id("canvas-wrapper"));
    Thread.sleep(2000);
    Thread.sleep(500);
    String afterCircle = canvasafterCircle.getAttribute("style");
    if (before.equals(afterCircle)) {
      System.out.println("Scenario Failed :  Unable to draw Circle ");
    } else {

      System.out.println("Scenario passed : Circle successfully drawn. ");
    }
  }

  public void drawHexagon() throws InterruptedException {

    Actions actions = new Actions(driver);

    Thread.sleep(5000);
    actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
    actions.sendKeys(Keys.DELETE).perform();
    driver.findElement(By.xpath("//*[@data-tooltip-id=\"draw\"]")).click();
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
    PointerInfo pointerInfo = MouseInfo.getPointerInfo();
    java.awt.Point finalPosition = pointerInfo.getLocation();
    double tolerance = 1.0;

    driver.findElement(By.xpath("//*[@data-tooltip-id=\"2d-3d-view-toogle\"]")).click();

    Thread.sleep(5000);

    driver.findElement(By.xpath("//*[@data-tooltip-id=\"2d-3d-view-toogle\"]")).click();

  }

  public void verifyHexagon() throws InterruptedException {

    WebElement canvasafterHexagon = driver.findElement(By.id("canvas-wrapper"));
    Thread.sleep(2000);
    Thread.sleep(500);
    String afterHexagon = canvasafterHexagon.getAttribute("style");
    if (before.equals(afterHexagon)) {
      System.out.println("Scenario Failed :  Unable to draw Hexagon ");
    } else {

      System.out.println("Scenario passed : Hexagon successfully drawn. ");
    }
  }

  public void drawWalls() throws InterruptedException {

    Actions actions = new Actions(driver);

    actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
    actions.sendKeys(Keys.DELETE).perform();

    driver.findElement(By.xpath("//*[contains(text(),'Wall')]")).click();

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
    driver.findElement(By.xpath("//*[@data-tooltip-id=\"2d-3d-view-toogle\"]")).click();
    Thread.sleep(5000);

  }

  public void verifyWalls() throws InterruptedException {

    WebElement canvasafterWalls = driver.findElement(By.id("canvas-wrapper"));
    Thread.sleep(2000);
    Thread.sleep(500);
    String afterWalls = canvasafterWalls.getAttribute("style");
    if (before.equals(afterWalls)) {
      System.out.println("Scenario Failed :  Unable to draw Walls ");
    } else {

      System.out.println("Scenario passed : Walls successfully drawn. ");
    }
  }

  public void drawFloor() throws InterruptedException {

    Actions actions = new Actions(driver);

    Thread.sleep(1000);

    driver.findElement(By.xpath("//*[@data-tooltip-id=\"2d-3d-view-toogle\"]")).click();
    Thread.sleep(5000);
    driver.findElement(By.xpath("//*[contains(text(),'Floor')]")).click();

    actions.moveByOffset(150, 0).click().perform();
    Thread.sleep(1000);
    actions.moveByOffset(0, 250).click().perform();
    Thread.sleep(1000);
    actions.moveByOffset(-150, 0).click().perform();
    Thread.sleep(1000);
    actions.moveByOffset(0, -250).click().perform();
    actions.moveByOffset(0, 0).click().perform();

    Thread.sleep(2000);

    driver.findElement(By.xpath("//*[@data-tooltip-id=\"2d-3d-view-toogle\"]")).click();
    Thread.sleep(5000);

  }

  public void verifyFloor() throws InterruptedException {

    WebElement canvasafterFloor = driver.findElement(By.id("canvas-wrapper"));
    Thread.sleep(2000);
    Thread.sleep(500);
    String afterFloor = canvasafterFloor.getAttribute("style");
    if (before.equals(afterFloor)) {
      System.out.println("Scenario Failed :  Unable to draw Floor ");
    } else {

      System.out.println("Scenario passed : Floor successfully drawn. ");
    }
  }

  public void drawSlab() throws InterruptedException {

    Actions actions = new Actions(driver);

    Thread.sleep(1000);

    driver.findElement(By.xpath("//*[@data-tooltip-id=\"2d-3d-view-toogle\"]")).click();
    Thread.sleep(5000);
    driver.findElement(By.xpath("//*[contains(text(),'Slab')]")).click();

    actions.moveByOffset(150, 0).click().perform();
    Thread.sleep(1000);
    actions.moveByOffset(0, 250).click().perform();
    Thread.sleep(1000);
    actions.moveByOffset(-150, 0).click().perform();
    Thread.sleep(1000);
    actions.moveByOffset(0, -250).click().perform();
    actions.moveByOffset(0, 0).click().perform();

    Thread.sleep(2000);

    driver.findElement(By.xpath("//*[@data-tooltip-id=\"2d-3d-view-toogle\"]")).click();
    Thread.sleep(5000);

  }

  public void verifySlab() throws InterruptedException {

    WebElement canvasafterSlab = driver.findElement(By.id("canvas-wrapper"));
    Thread.sleep(2000);
    Thread.sleep(500);
    String afterSlab = canvasafterSlab.getAttribute("style");
    if (before.equals(afterSlab)) {
      System.out.println("Scenario Failed :  Unable to draw Slab ");
    } else {

      System.out.println("Scenario passed : Slab successfully drawn. ");
    }
  }

  public void closeBrowser() {
    driver.quit();
  }
}