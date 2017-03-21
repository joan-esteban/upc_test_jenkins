package practica.screens;

import practica.lib.SupportScreen;
import practica.lib.SupportScreenInterface;

public class Screen08 implements SupportScreenInterface  {
	
	SupportScreen support;
	
	public Screen08(SupportScreen givenSupportScreen){
		support = givenSupportScreen;
	}
	
	@Override
	public String getName(){
		return "screen08";
	}
	
	@Override
	public String getUrlPath(){
		return "/index8.html";
	}
	
	@Override
	public boolean isBrowserInThisScreen(){
		return support.isCurrentUrlPathOrAlert("{alert}");
	}
	
	public boolean waitAlert(){
		return support.waitAlert();
	}
	
	public boolean sendTextToAlert(String text){
		if (!support.waitAlert()){
			return false;
		}
		support.sendTextToAlert(text);
		support.acceptAlert();
		return true;
	}
}
