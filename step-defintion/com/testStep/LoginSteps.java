package com.testStep;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class LoginSteps {
    public String before =null;
    private WebDriver driver;

    public LoginSteps() {
        // Initialize WebDriver in the constructor
        System.setProperty("webdriver.chrome.driver", "E:\\JAVA\\JavaSoft\\ChromeDriverFolder\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void openSnapTrude() throws InterruptedException {
        driver.get("https://app.snaptrude.com/login");
        Thread.sleep(8000);
    }

    public void enterUsername(String username) {
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]")).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
    }

    public void clickSignInButton() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void verifyUserIDNotFoundErrorMessage() throws InterruptedException {
    	Thread.sleep(8000);
        boolean wrongID = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[1]/div")).isDisplayed();
        System.out.println(wrongID);
        if (wrongID) {
            System.out.println("Wrong User ID Testcase Passed ");
        }
    }
    
    public void verifyIncorrectUserNameOrPasword() throws InterruptedException {
    	Thread.sleep(8000);
        boolean wrongPass = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[1]/div")).isDisplayed();
        System.out.println(wrongPass);
        if (wrongPass) {
            System.out.println("Test case Passed ");
        }
    }
    
    public void verifyUserNameAndPaswordAreCorrect() throws InterruptedException {
    	Thread.sleep(8000);
    	boolean isMyWorkspaceVisible = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[2]/button/p")).isDisplayed();
    	System.out.println(isMyWorkspaceVisible);
    	if (isMyWorkspaceVisible) {

    	    System.out.println("  Scenario passed: Login successful.  ");
    	} else {
    	    System.out.println("[ Scenario failed: My Workspace is not visible on the display.   ");	 
        }
    }
    
    
    public void selectTestProject() throws InterruptedException {
    	Thread.sleep(5000);
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
    	Thread.sleep(8000);
    	WebElement canvasbeforeDraw = driver.findElement(By.id("canvas-wrapper"));
    	Thread.sleep(2000);
    	WebElement canvas = driver.findElement(By.id("canvas"));
    	Thread.sleep(500);
    	before = canvasbeforeDraw.getAttribute("style");
    	
    	
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
    	
    	
 
    }
    
    public void verifyRectangle() throws InterruptedException {
    	
    	WebElement canvasafterRectangle = driver.findElement(By.id("canvas-wrapper"));
    	Thread.sleep(500);
    	String afterRectangle = canvasafterRectangle.getAttribute("style");
    	if (before.equals(afterRectangle)) 
    	{
    		System.out.println("Scenario Failed :  Unable to draw rectangle ");
    	}
    	else {
    		System.out.println("Scenario passed : Rectangle successfully drawn. ");
    	}
    	
 
    }
    
    
 

    	
    	
 
    public void drawCircle() throws InterruptedException {
    	
    	
    	
    	Actions actions = new Actions(driver);

actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
actions.sendKeys(Keys.DELETE).perform();
System.out.println("Cleared Canvas" );
Thread.sleep(8000);
WebElement canvasbeforeDraw = driver.findElement(By.id("canvas-wrapper"));
Thread.sleep(2000);
WebElement canvas = driver.findElement(By.id("canvas"));
Thread.sleep(500);
before = canvasbeforeDraw.getAttribute("style");


System.out.println("Drawing the circle");

driver.findElement(By.xpath( " //*[@data-tooltip-id=\"drawCircle\"]  "	 )).click();
actions.moveByOffset(0, 0).click().perform();
Thread.sleep(2000);
actions.moveByOffset(60, 0).click().perform();
Thread.sleep(5000);
 

    	
 
    }
    
    public void verifyCircle() throws InterruptedException {
    	
    	WebElement canvasafterCircle = driver.findElement(By.id("canvas-wrapper"));
    	Thread.sleep(2000);
    	Thread.sleep(500);
    	String afterCircle = canvasafterCircle.getAttribute("style");
    	if (before.equals(afterCircle)) {
    		System.out.println("Scenario Failed :  Unable to draw Circle ");
    	}
    	else {

    		System.out.println("Scenario passed : Circle successfully drawn. ");
    	}
    }
    	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    public void closeBrowser() {
            driver.quit();
    }
}
