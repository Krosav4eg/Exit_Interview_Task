package com.epam.serhii_potapov.tests;

import com.epam.serhii_potapov.contexts.MobServerContext;
import com.epam.serhii_potapov.contexts.WebDriverContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
/**
 * Created by Serhii_Potapov on 6/27/2016.
 */
public class BaseTest {
    private static String harName = "sony.har";

    @BeforeClass
    public void setUp() {
        WebDriverContext.createDriver();
        MobServerContext.createNewHar(harName);
    }

    @AfterClass
    public void tearDown() {
        WebDriverContext.quiteDriver();
        MobServerContext.stopServer();
    }
}
