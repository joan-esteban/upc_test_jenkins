package practica.screens;

import org.openqa.selenium.By;

import practica.lib.SupportScreen;
import practica.lib.SupportScreenInterface;

public class Screen03 implements SupportScreenInterface {
	
	SupportScreen support;
	
	public Screen03(SupportScreen givenSupportScreen){
		support = givenSupportScreen;
	}
		
	@Override
	public String getName(){
		return "screen03";
	}
	
	@Override
	public String getUrlPath(){
		return "/index3.html";
	}
	
	@Override
	public boolean isBrowserInThisScreen(){
		return support.isCurrentUrlPathOrAlert(getUrlPath());
	}
	
	
	public String getToken(){
		return support.getTextItemContents(By.className("custom_dummy_label"));
	}
	
	public void fillInputBox(String token){
		support.fillDefaultTextBox(token);
	}
	
	public boolean submit(){
		support.clickContinuar();
		return true;
	}
}
