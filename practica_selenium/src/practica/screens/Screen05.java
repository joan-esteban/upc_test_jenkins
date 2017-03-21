package practica.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import practica.lib.SupportScreen;
import practica.lib.SupportScreenInterface;

public class Screen05 implements SupportScreenInterface {
	public static final String LINK_TEXT = "Enlace!";
	
	SupportScreen support;
	
	public Screen05(SupportScreen givenSupportScreen){
		support = givenSupportScreen;
	}
	
	@Override
	public String getName(){
		return "screen05";
	}
	
	@Override
	public String getUrlPath(){
		return "/index5.html";
	}
	
	@Override
	public boolean isBrowserInThisScreen(){
		return support.isCurrentUrlPathOrAlert(getUrlPath());
	}
	
	
	public void clickLink(){
		WebDriver driver = support.getDriver();
		for (WebElement web : driver.findElements(By.linkText(LINK_TEXT)) ){
			web.click();
		}
	}
	
	public void submit(){
		clickLink();
	}

	
}
