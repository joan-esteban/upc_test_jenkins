package practica.lib;

public interface SupportScreenInterface {
	
	/**
	 * Return name of screen
	 * @return name of screen
	 */
	public String getName();
	/**
	 * Return suffix of URL for this screen (ex: "index1.html")
	 * @return suffix of URL for this screen
	 */
	public String getUrlPath();
	
	/**
	 * Check if browser is showing this screen
	 * @return true if it's this screen active on browser
	 */
	public  boolean isBrowserInThisScreen();
}
