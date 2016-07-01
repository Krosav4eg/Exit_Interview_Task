package com.epam.serhii_potapov.contexts;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Serhii_Potapov on 6/27/2016.
 */
public class WebDriverContext {
    private static WebDriver driver;
    private static final int TIME_OUT_FOR_WAIT_SEC = 20;

    public static void createDriver() {

        driver = new ChromeDriver(MobServerContext.getSeleniumCapabilities());
        driver.manage().timeouts().implicitlyWait(TIME_OUT_FOR_WAIT_SEC, TimeUnit.SECONDS);


        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quiteDriver() {
        if (driver != null && !driver.getWindowHandles().isEmpty()) {
            driver.quit();
        }
    }
}
