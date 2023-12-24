import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SnapTrude {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",  "E:\\JAVA\\JavaSoft\\ChromeDriverFolder\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        
        
        //scenario 1 : Login
driver.get("https://app.snaptrude.com/login");
Thread.sleep(8000);



//scenario 1(1) : Wrong Id Password

driver.findElement(By.xpath( "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]"	 )).sendKeys("WrongEmail@gmail.com" );
driver.findElement(By.xpath( "//input[@type='password']"	 )).sendKeys("WrongPassword");	
driver.findElement(By.xpath( "//button[@type='submit']"	 )).click();
Thread.sleep(5000);



boolean wrongIdPass = driver.findElement(By.xpath("//*[@class=\"sc-dtTHgf dsQzOW login-error\"]")).isDisplayed();
System.out.println(wrongIdPass);
if (wrongIdPass) {
    System.out.println("\u001B[32m Wrong Email id Pass Test Passed Now Entering Correct Id and Password.  \u001B ");
	driver.get("https://app.snaptrude.com/login");
	Thread.sleep(8000);
} else {
    System.out.println("\u001B[31m Wrong Email id Password Test Failed.  \u001B ");
}



//scenario 1(1) : Correct Id Password

driver.findElement(By.xpath( "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]"	 )).sendKeys("chetan.g.shavanti@gmail.com" );
driver.findElement(By.xpath( "//input[@type='password']"	 )).sendKeys("Test@123");	
driver.findElement(By.xpath( "//button[@type='submit']"	 )).click();
Thread.sleep(5000);



boolean isMyWorkspaceVisible = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[2]/button/p")).isDisplayed();
System.out.println(isMyWorkspaceVisible);
if (isMyWorkspaceVisible) {

    System.out.println(" \u001B[32m  Scenario 1 passed: Login successful. \u001B ");
} else {
    System.out.println("\u001B[31m Scenario 1 failed: My Workspace is not visible on the display.  \u001B ");
}











//scenario 2 : Project Selection
Thread.sleep(5000);
driver.findElements(By.className("project-card-ready")).get(0).click();
Thread.sleep(2000);
boolean ProjectClicked = driver.findElement(By.xpath("//*[@data-tooltip-id=\"Views\"]")).isDisplayed();
if (ProjectClicked) {
    System.out.println("\u001B[32m   Scenario 2 passed: Project Opened successfully. \u001B");
} else {
    System.out.println("\u001B[31m  Scenario 2 failed: Unable To open Project.\u001B");
}






//wrapperStyle Extract
Thread.sleep(2000);
WebElement canvasbeforeDraw = driver.findElement(By.id("canvas-wrapper"));
Thread.sleep(2000);
WebElement canvas = driver.findElement(By.id("canvas"));
Thread.sleep(500);
String before = canvasbeforeDraw.getAttribute("style");
Thread.sleep(500);
//System.out.println("before"+canvasbeforeDraw.getAttribute("style"));
Thread.sleep(2000);














//scenario 3 : Draw Rectangle
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


Thread.sleep(5000);

WebElement canvasafterRectangle = driver.findElement(By.id("canvas-wrapper"));
Thread.sleep(2000);
WebElement canvasRectangle = driver.findElement(By.id("canvas"));
Thread.sleep(500);
String afterRectangle = canvasbeforeDraw.getAttribute("style");
if (afterRectangle.equals(canvasafterRectangle.getAttribute("style"))) {
	System.out.println("\u001B[32m Scenario 3 passed : Rectangle successfully drawn. \u001B");
}
else {
	System.out.println("\u001B[31m Scenario 3 Failed :  Unable to draw rectangle \u001B");
}





//Scenario 4 : Draw circle



actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
actions.sendKeys(Keys.DELETE).perform();
System.out.println("Cleared Canvas" );
driver.findElement(By.xpath( " //*[@data-tooltip-id=\"drawCircle\"]  "	 )).click();
actions.moveByOffset(0, 0).click().perform();
Thread.sleep(2000);
actions.moveByOffset(60, 0).click().perform();
Thread.sleep(5000);
 
WebElement canvasafterCircle = driver.findElement(By.id("canvas-wrapper"));
Thread.sleep(2000);
WebElement canvasCircle = driver.findElement(By.id("canvas"));
Thread.sleep(500);
String afterCircle = canvasbeforeDraw.getAttribute("style");
if (afterCircle.equals(canvasafterCircle.getAttribute("style"))) {
	System.out.println("\u001B[32m Scenario 4 passed : Circle successfully drawn. \u001B  ");
}
else {
	System.out.println("\u001B[31m  Scenario 4 Failed :  Unable to draw Circle \u001B ");
}






//scenario 5 : Draw Hexagon
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
PointerInfo pointerInfo = MouseInfo.getPointerInfo();
java.awt.Point finalPosition = pointerInfo.getLocation();
double tolerance = 1.0; 

WebElement canvasafterHexagon = driver.findElement(By.id("canvas-wrapper"));
Thread.sleep(2000);
WebElement canvasHexagon = driver.findElement(By.id("canvas"));
Thread.sleep(500);
String afterHexagon = canvasbeforeDraw.getAttribute("style");
if (afterHexagon.equals(canvasafterHexagon.getAttribute("style"))) {
	System.out.println("\u001B[32m  Scenario 4 passed : Hexagon successfully drawn. \u001B ");
}
else {
	System.out.println("\u001B[31m  Scenario 4 Failed :  Unable to draw Hexagon. \u001B ");
}






//scenario 6 : Convert to 3D.
driver.findElement(By.xpath( "//*[@data-tooltip-id=\"2d-3d-view-toogle\"]"	 )).click();
boolean view3d = driver.findElement(By.xpath("//*[@data-tooltip-id=\"addLayer3d\"]")).isDisplayed();
System.out.println(view3d);
if (view3d) {
    System.out.println("\u001B[32m   Scenario 6 passed: Shifted to 3D View.  \u001B ");
    Thread.sleep(15000);
    driver.findElement(By.xpath( "//*[@data-tooltip-id=\"2d-3d-view-toogle\"]"	 )).click();
} else {
    System.out.println("\u001B[31m   Scenario 5 failed: Unable to shift 3D View. \u001B ");
}










//scenario 7 : Draw walls 

//Wall Draw
Thread.sleep(1000);

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
driver.findElement(By.xpath( "//*[@data-tooltip-id=\"2d-3d-view-toogle\"]"	 )).click();
Thread.sleep(5000);

WebElement canvasafterWall = driver.findElement(By.id("canvas-wrapper"));
Thread.sleep(2000);
WebElement canvasWall = driver.findElement(By.id("canvas"));
Thread.sleep(500);
String afterWall = canvasbeforeDraw.getAttribute("style");
if (afterWall.equals(canvasafterWall.getAttribute("style"))) {
	System.out.println("\u001B[32m  Scenario 7 passed : Wall successfully drawn. \u001B ");
}
else {
	System.out.println("\u001B[31m  Scenario 7 Failed :  Unable to draw Wall. \u001B");
}








//Scenario 8 : Floor Draw
Thread.sleep(1000);


driver.findElement(By.xpath( "//*[@data-tooltip-id=\"2d-3d-view-toogle\"]"	 )).click();
Thread.sleep(5000);
driver.findElement(By.xpath( "//*[contains(text(),'Floor')]" )).click();

actions.moveByOffset(150, 0).click().perform();
Thread.sleep(1000);
actions.moveByOffset(0, 250).click().perform();
Thread.sleep(1000);
actions.moveByOffset(-150, 0).click().perform();
Thread.sleep(1000);
actions.moveByOffset(0, -250).click().perform();
actions.moveByOffset(0, 0).click().perform();

Thread.sleep(2000);

driver.findElement(By.xpath( "//*[@data-tooltip-id=\"2d-3d-view-toogle\"]"	 )).click();
Thread.sleep(5000);


WebElement canvasafterFloor = driver.findElement(By.id("canvas-wrapper"));
Thread.sleep(2000);
WebElement canvasFloor = driver.findElement(By.id("canvas"));
Thread.sleep(500);
String afterFloor = canvasbeforeDraw.getAttribute("style");
if (afterFloor.equals(canvasafterFloor.getAttribute("style"))) {
	System.out.println("\u001B[32m   Scenario 8 passed : Floor successfully drawn. \u001B  ");
}
else {
	System.out.println(" \u001B[31m  Scenario 8 Failed :  Unable to draw Floor. \u001B  ");
}






//Scenario 9 : Slab Draw
Thread.sleep(1000);


driver.findElement(By.xpath( "//*[@data-tooltip-id=\"2d-3d-view-toogle\"]"	 )).click();
Thread.sleep(5000);
driver.findElement(By.xpath( "//*[contains(text(),'Slab')]" )).click();

actions.moveByOffset(150, 0).click().perform();
Thread.sleep(1000);
actions.moveByOffset(0, 250).click().perform();
Thread.sleep(1000);
actions.moveByOffset(-150, 0).click().perform();
Thread.sleep(1000);
actions.moveByOffset(0, -250).click().perform();
actions.moveByOffset(0, 0).click().perform();

Thread.sleep(2000);
driver.findElement(By.xpath( "//*[@data-tooltip-id=\"2d-3d-view-toogle\"]"	 )).click();
Thread.sleep(5000);



WebElement canvasafterSlab = driver.findElement(By.id("canvas-wrapper"));
Thread.sleep(2000);
WebElement canvasSlab = driver.findElement(By.id("canvas"));
Thread.sleep(500);
String afterSlab = canvasbeforeDraw.getAttribute("style");
if (afterSlab.equals(canvasafterSlab.getAttribute("style"))) {
	System.out.println("\u001B[32m  Scenario 9 passed : Slab successfully drawn. \u001B  ");
}
else {
	System.out.println("\u001B[31m Scenario 9 Failed :  Unable to draw Slab. \u001B ");
}










driver.quit();

	}

}