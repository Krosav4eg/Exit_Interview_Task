package com.epam.serhii_potapov.contexts;

import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;



/**
 * Created by Serhii_Potapov on 6/27/2016.
 */
public class MobServerContext {
    private static BrowserMobProxyServer server;
    private static final Logger LOG = Logger.getRootLogger();
    private static final String CHROME_DRIVER_FILE_NAME = "src/main/resources/chromedriver.exe";

    public static void stopServer() {
        server.stop();
    }

    public static BrowserMobProxyServer getServer() {
        return server;
    }

    public static DesiredCapabilities getSeleniumCapabilities() {
        try {
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_FILE_NAME);
        } catch (IllegalStateException e) {
            LOG.error("ChromeDriven was not found!");
        }
        DesiredCapabilities chromeCaps = DesiredCapabilities.chrome();

        server = new BrowserMobProxyServer();
        server.start();
        Proxy proxy = ClientUtil.createSeleniumProxy(MobServerContext.getServer());
        DesiredCapabilities seleniumCapabilities = new DesiredCapabilities(chromeCaps);
        seleniumCapabilities.setCapability(CapabilityType.PROXY, proxy);
        return seleniumCapabilities;
    }

    public static void createNewHar(String harName) {
        server.newHar(harName);
    }
}
