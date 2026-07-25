package com.automation.factory;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
	
	private static WebDriver driver;
	
	public static void createDriver() {
		ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();

        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);

        options.setExperimentalOption("prefs", prefs);

        options.addArguments(
                "--disable-features=PasswordLeakDetection"
        );
        
	  driver = new ChromeDriver(options);
	  driver.manage().window().maximize();
	}
    public static WebDriver getDriver() {
    	return driver;
    }
    	public static void quitDriver() {
    		if(driver != null) {
    			driver.quit();
    			driver =null;
    		}
    	}
    }
