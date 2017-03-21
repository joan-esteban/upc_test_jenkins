package practica.screens;

import org.openqa.selenium.By;

import practica.lib.SupportScreen;
import practica.lib.SupportScreenInterface;

public class Screen04 implements SupportScreenInterface {
	SupportScreen support;
	
	public Screen04(SupportScreen givenSupportScreen){
		support = givenSupportScreen;
	}
	
	@Override
	public String getName(){
		return "screen04";
	}
	
	@Override
	public String getUrlPath(){
		return "/index4.html";
	}
	
	@Override
	public boolean isBrowserInThisScreen(){
		return support.isCurrentUrlPathOrAlert(getUrlPath());
	}
	

	
	public boolean submit(){
		support.clickAllMatching(By.className("btn"));
		return true;
	}
	

}
