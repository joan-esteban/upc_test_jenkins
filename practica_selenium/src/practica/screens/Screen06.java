package practica.screens;

import org.openqa.selenium.By;

import practica.lib.SupportScreen;
import practica.lib.SupportScreenInterface;

public class Screen06 implements SupportScreenInterface  {
	public static final String ELEMENT_ID="hidden\"";
	
	SupportScreen support;
	
	public Screen06(SupportScreen givenSupportScreen){
		support = givenSupportScreen;
	}
	
	@Override
	public String getName(){
		return "screen06";
	}
	
	@Override
	public String getUrlPath(){
		return "/index6.html";
	}
	
	@Override
	public boolean isBrowserInThisScreen(){
		return support.isCurrentUrlPathOrAlert(getUrlPath());
	}
	
	public void showHiddenButton(){
		support.showElement(ELEMENT_ID);
	}
	
	public void clickHiddenButton(){
		support.click(By.id(ELEMENT_ID));
	}
	
	public boolean acceptAlert(){
		if (!support.waitAlert()){
			return false;
		}
		support.acceptAlert();
		return true;
	}
}
