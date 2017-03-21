package practica.screens;

import org.openqa.selenium.By;

import practica.lib.SupportScreen;
import practica.lib.SupportScreenInterface;

public class Screen10 implements SupportScreenInterface  {

	public static final  By SOURCE_OBJECT = By.id("source");
	public static final  By TARGET_OBJECT = By.id("target");
	public static final  String SUCCESSFULL_TEXT = "¡Enhorabuena! Has llegado al final de la práctica";
	
	SupportScreen support;
	
	public Screen10(SupportScreen givenSupportScreen){
		support = givenSupportScreen;
	}
	
	@Override
	public String getName(){
		return "screen10";
	}
	
	@Override
	public String getUrlPath(){
		return "/index10.html";
	}
	
	@Override
	public boolean isBrowserInThisScreen(){
		return support.isCurrentUrlPathOrAlert(getUrlPath()) && ("Level 10".equals(getH1Text()));
	}
	
	public void dragTo(By source, By target){
		support.dragItemTo(source, target);
	}
	
	public String getH1Text(){
		return support.getTextItemContents(By.xpath("/html/body/div/div/h1"));
	}
	
	public boolean isScreenCleared(){
		return SUCCESSFULL_TEXT.equals(getH1Text() );
	}
	
	
}
