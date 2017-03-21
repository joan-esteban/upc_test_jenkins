package practica.screens;

import org.openqa.selenium.By;

import practica.lib.SupportScreen;
import practica.lib.SupportScreenInterface;

public class Screen01 implements SupportScreenInterface {
	SupportScreen support;
	
	public Screen01(SupportScreen supportScreen){
		support = supportScreen;
	}
	
	@Override
	public String getName(){
		return "screen01";
	}
	
	@Override
	public String getUrlPath(){
		return "/";
	}
	
	@Override
	public boolean isBrowserInThisScreen(){
		return support.isCurrentUrlPathOrAlert(getUrlPath());
	}
	
	
	public void clickNext(){
		support.click(By.id("start_button"));
	}
	
	

	
}
