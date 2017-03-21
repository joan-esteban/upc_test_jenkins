package practica.screens;


import practica.lib.SupportScreen;
import practica.lib.SupportScreenInterface;

public class Screen02 implements SupportScreenInterface {
	
	public static final String TEXT_SELENIUM = "selenium";
	
	SupportScreen support;
	
	public Screen02(SupportScreen givenSupportScreen){
		support = givenSupportScreen;
	}
	@Override
	public String getName(){
		return "screen02";
	}
	 
	@Override
	public String getUrlPath(){
		return "/index2.html";
	}
	
	@Override
	public boolean isBrowserInThisScreen(){
		return support.isCurrentUrlPathOrAlert(getUrlPath());
	}
	
	
	public void setTokenInInputBox(String token){
		support.fillDefaultTextBox(token);
	}
	
	
	public boolean submit(){
		support.clickContinuar();
		return true;
	}
	

}
