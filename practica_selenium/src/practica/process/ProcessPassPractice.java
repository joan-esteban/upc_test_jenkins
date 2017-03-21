package practica.process;

import static org.junit.Assert.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import practica.lib.SupportBrowser;
import practica.lib.SupportScreen;
import practica.lib.SupportScreenInterface;
import practica.screens.Screen01;
import practica.screens.Screen02;
import practica.screens.Screen03;
import practica.screens.Screen04;
import practica.screens.Screen05;
import practica.screens.Screen06;
import practica.screens.Screen07;
import practica.screens.Screen08;
import practica.screens.Screen09;
import practica.screens.Screen10;

public class ProcessPassPractice  {

	private static final Logger LOGGER = Logger.getLogger( ProcessPassPractice.class.getName() );
	
	private SupportBrowser browser;
	private SupportScreen supportScreen;
	static final String URL = "http://192.168.56.101";
	
	
	@Before
	public void setUp() {
		browser = new SupportBrowser();
		supportScreen = browser.init();
	}

	@After
	public void tearDown() {
		browser.close();
	}
	
	public void checkBrowserIsInCorrectUrl(SupportScreenInterface screen){
		LOGGER.log( Level.FINER," checkScreen " + screen.getName() );
		assertEquals( screen.isBrowserInThisScreen(), true);
	}
	

	public void passScreen01(Screen01 scr){
		checkBrowserIsInCorrectUrl(scr);
		scr.clickNext();
	}
	
	public void passScreen02(Screen02 scr){
		checkBrowserIsInCorrectUrl(scr);
		scr.setTokenInInputBox(Screen02.TEXT_SELENIUM);
		scr.submit();
	}
	
	public void passScreen03(Screen03 scr){
		checkBrowserIsInCorrectUrl(scr);
		String token = scr.getToken();
		scr.fillInputBox(token);
		scr.submit();
	}
	
	public void passScreen04(Screen04 scr){
		checkBrowserIsInCorrectUrl(scr);
		scr.submit();
	}
	
	public void passScreen05(Screen05 scr){
		checkBrowserIsInCorrectUrl(scr);
		scr.submit();
	}
	
	public void passScreen06(Screen06 scr){
		checkBrowserIsInCorrectUrl(scr);
		scr.showHiddenButton();
		scr.clickHiddenButton();
	}
	
	public void passScreen07(Screen07 scr){
		checkBrowserIsInCorrectUrl(scr);
		assertEquals("Must appeear a alert", scr.acceptAlert(), true);		
	}
	
	public void passScreen08(Screen08 scr){
		checkBrowserIsInCorrectUrl(scr);
		assertEquals("Must appear a alert", scr.waitAlert(), true);
		scr.sendTextToAlert("9");
	}
	
	public void passScreen09(Screen09 scr) throws InterruptedException{
		checkBrowserIsInCorrectUrl(scr);
		String pass = scr.getPassword();
		scr.closePopupWindow();
		scr.setPassword(pass);
		scr.submit();
	}
	
	public void wrongPasswordScreen09(Screen09 scr) throws InterruptedException{
		checkBrowserIsInCorrectUrl(scr);
		String pass = scr.getPassword();
		scr.closePopupWindow();
		scr.setPassword(pass + "a");
		scr.submit();
		String literalForRefused = "password not accepted";
		assertEquals(literalForRefused, false, scr.isScreenCleared());
		scr.setPassword("");
		scr.submit();
		assertEquals(literalForRefused, false, scr.isScreenCleared());
		scr.setPassword(pass+pass);
		scr.submit();
		assertEquals(literalForRefused, false, scr.isScreenCleared());
		scr.setPassword(pass.substring(0,pass.length()-1));
		scr.submit();
		assertEquals(literalForRefused, false, scr.isScreenCleared());
	}
	
	
	public void passScreen10(Screen10 scr) throws InterruptedException{
		checkBrowserIsInCorrectUrl(scr);
		LOGGER.log( Level.FINER,"text=" +scr.getH1Text());
		scr.dragTo(Screen10.SOURCE_OBJECT, Screen10.TARGET_OBJECT);
		assertEquals("cleared screen 10", true, scr.isScreenCleared());
	}
	

	
	@Test
	public void passExerciceAllLevels() throws InterruptedException {
		browser.goTo(URL);
		passScreen01( new Screen01(supportScreen) );
		passScreen02( new Screen02(supportScreen) );
		passScreen03( new Screen03(supportScreen) );
		passScreen04( new Screen04(supportScreen) );
		passScreen05( new Screen05(supportScreen) );
		passScreen06( new Screen06(supportScreen) );
		passScreen07( new Screen07(supportScreen) );
		passScreen08( new Screen08(supportScreen) );
		passScreen09( new Screen09(supportScreen) );
		passScreen10( new Screen10(supportScreen) );
	}
	
	@Test
	public void checkWrongPassword() throws InterruptedException {
		Screen09 scr9 = new Screen09(supportScreen);
		browser.goTo(URL + scr9.getUrlPath());
		wrongPasswordScreen09(scr9);
	}

	
	

}
