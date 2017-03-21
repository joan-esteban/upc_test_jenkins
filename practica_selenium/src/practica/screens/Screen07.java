package practica.screens;

import org.openqa.selenium.By;

import practica.lib.SupportScreen;
import practica.lib.SupportScreenInterface;

public class Screen07 implements SupportScreenInterface  {
	
	public static final String  ELEMENT_ID="hidden\"";
	
	SupportScreen support;
	
	
	public Screen07(SupportScreen givenSupportScreen){
		support = givenSupportScreen;
	}
	@Override
	public String getName(){
		return "screen07";
	}
	@Override
	public String getUrlPath(){
		return "/index7.html";
	}
	
	@Override
	public boolean isBrowserInThisScreen(){
		return support.isCurrentUrlPathOrAlert("{alert}");
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

