package practica.lib;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SupportScreenTest {
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
	
	@Test
	public void checkUrlOnLanding() throws MalformedURLException {
		browser.goTo(URL);
		assertEquals( "checking landing page with slash", true, supportScreen.isCurrentUrlPathOrAlert("/"));
		assertEquals( "checking landing page without slash", true, supportScreen.isCurrentUrlPathOrAlert(""));
		assertEquals( "alert detected", false, supportScreen.isAlertPresent());
	}
	
	@Test
	public void checkUrlOnAlert() throws MalformedURLException {
		browser.goTo(URL+"/index7.html");
		assertEquals( "alert detected", true, supportScreen.isAlertPresent());
		assertEquals( "there are an alert ", true, supportScreen.isCurrentUrlPathOrAlert("{alert}"));
	}

	

}
