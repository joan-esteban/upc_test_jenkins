package practica.lib;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SupportBrowser {
	private static final Logger LOGGER = Logger.getLogger( SupportBrowser.class.getName() );
	
	private ChromeDriver driver;
	
	public SupportScreen init(){ 
		LOGGER.log( Level.FINER, "init chrome engine");
		ChromeOptions options  = new ChromeOptions();
		ArrayList<String> optionList = new ArrayList<>();
		optionList.add("--incognito");
		options.addArguments(optionList);
		driver = new ChromeDriver(options);
		SupportScreen support;
		support = new SupportScreen(driver);
		return support;
	}
	
	public void goTo(String url){
		driver.get(url);
	}
	
	public String getURL(){
		return driver.getCurrentUrl();
	}
	
	public void close(){
		driver.close();
	}
}
