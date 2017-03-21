package practica.lib;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SupportScreen {
	private static final Logger LOGGER = Logger.getLogger( SupportScreen.class.getName() );
	
	public static final By commonInputWeb = By.id("input");
	public static final By commonButtonContinuarWeb = By.id("next");
	static WebDriver driver;
	
	public SupportScreen(WebDriver givenDriver){
		driver = givenDriver;
	}
	
	// Casi todas las pantallas tiene un boton Continuar
	public void clickContinuar(){
		click(commonButtonContinuarWeb);
	}
	// Casi todas las pantallas tiene un TextBox
	public void fillDefaultTextBox(String text){
		setTextItemContents(text,commonInputWeb);
	}
	
	public String getBrowserUrl(){
		return driver.getCurrentUrl();
	}
	public boolean isAlertPresent() {
	    try {
	        driver.switchTo().alert();
	        return true;
	    } // try
	    catch (Exception e) {
	    	LOGGER.log( Level.FINER, "trying to swith to alert",e );
	    } // catch
	    return false;
	}
	
	public boolean isCurrentUrlPathOrAlert(String expectedPath){
		String path;
		String expectedPathCooked = expectedPath.replaceFirst("/", "");
		if (isAlertPresent()){
			path="{alert}";
		} else {
			try {
				path = new URL( getBrowserUrl() ).getPath();
			} catch (MalformedURLException e) {
				return false;
			}
			path = path.replaceFirst("/", "");
		}
		return expectedPathCooked.replaceFirst("/", "").equals(path);
	}

	
	public void waitToExistsNWindows(int numberWindowsExpected, int timeoutInSeconds) throws InterruptedException{
		// http://www.seleniumhq.org/docs/04_webdriver_advanced.jsp
		int sleepMs = 50;
		int numberRetries = timeoutInSeconds * 1000 / sleepMs;
		while ( (driver.getWindowHandles().size() < numberWindowsExpected) && (numberRetries>0) )  {
			Thread.sleep(sleepMs);
			numberRetries = numberRetries - 1;
		}
		if (driver.getWindowHandles().size() < numberWindowsExpected){
			throw  new InterruptedException();
		}
	}
	
	public void activeAnyWindow(){
		driver.switchTo().window(driver.getWindowHandles().iterator().next());
	}
	
	public void activeWindowThatURLContains(String url){
		String winHandleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
			if (driver.getCurrentUrl().contains(url)){
				return;
			}
		}
		driver.switchTo().window(winHandleBefore);
		throw new NoSuchElementException();
	}
	
	public void click(By by){
		WebElement webButton = driver.findElement(by);
		webButton.click();
	}
	
	public int clickAllMatching(By by){
		int howMany = 0;
		for (WebElement web : driver.findElements(by) ){
			web.click();
			howMany++;
		}
		return howMany;
	}
	
	public void setTextItemContents(String text, By by){
		WebElement webInput = driver.findElement(by);
		webInput.sendKeys(text);
	}
	
	
	
	public String getTextItemContents(By by){
		WebElement element = driver.findElement(by);
		return element.getText();
	}
	
	public void showElement(String elementId){
		((JavascriptExecutor) driver).executeScript("document.getElementById('"+elementId+"').style.display = 'block';");
		
	}
	
	public boolean waitAlert(){
		try {
	        WebDriverWait wait = new WebDriverWait(driver, 2);
	        wait.until(ExpectedConditions.alertIsPresent());
	        return true;
	    } catch (Exception e) {
	    	LOGGER.log( Level.FINER, "waiting for alert", e);
	    }
		return false;
	}
	
	public void acceptAlert(){
		Alert alert = driver.switchTo().alert();
        alert.accept();
	}
	
	public void sendTextToAlert(String text){
		Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
	}
	
	public void dragItemTo(By sourceObject, By targetObject){
		WebElement divSource = driver.findElement(sourceObject);
		WebElement divTarget = driver.findElement(targetObject);
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(divSource)
				   .moveToElement(divTarget)
				   .release(divTarget)
				   .build();
		dragAndDrop.perform();
	}
	
	public void closeCurrentWindow(){
		driver.close();
	}
	
	public WebDriver getDriver(){
		return driver;
	}
	

}
