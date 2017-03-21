package practica.screens;

import org.openqa.selenium.By;

import practica.lib.SupportScreen;
import practica.lib.SupportScreenInterface;

public class Screen09 implements SupportScreenInterface  {

	SupportScreen support;
	
	public Screen09(SupportScreen givenSupportScreen){
		support = givenSupportScreen;
	}
	
	@Override
	public String getName(){
		return "screen09";
	}
	
	@Override
	public String getUrlPath(){
		return "/index9.html";
	}
	
	@Override
	public boolean isBrowserInThisScreen(){
		return support.isCurrentUrlPathOrAlert(getUrlPath());
	}
	
	public String getPassword()  throws InterruptedException{
		
		support.waitToExistsNWindows(2,1);
		support.activeWindowThatURLContains("9popup");
		return support.getTextItemContents(By.id("pass"));
	}
	
	public  void closePopupWindow() throws InterruptedException{
		support.activeWindowThatURLContains("9popup");
		support.closeCurrentWindow();
		support.activeAnyWindow();
	}
	
	public  void setPassword(String pass){
		support.activeWindowThatURLContains("index9");
		support.fillDefaultTextBox(pass);
	}
	
	public void submit(){
		support.clickContinuar();
	}
	
	public boolean isScreenCleared(){
		return !isBrowserInThisScreen();
	}
	

}
