package com.epam.serhii_potapov.tests;

import com.epam.serhii_potapov.contexts.WebDriverContext;
import com.epam.serhii_potapov.report.RequestsTable;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.epam.serhii_potapov.constatnts.SonyConstants.*;

/**
 * Created by Serhii_Potapov on 6/27/2016.
 */

public class RequestTest extends BaseTest {
    private SoftAssert softAssert = new SoftAssert();

    @Test
    public void verifyHomePageTitle() {
        WebDriverContext.getDriver().get(HOME_PAGE_URL);
        String errMessage = "We are  verifying title of home page";
        softAssert.assertTrue(WebDriverContext.getDriver().getTitle().equals(HOME_PAGE_TITLE), errMessage);
    }

    @Test(dependsOnMethods = {"verifyHomePageTitle"})
    public void verifySonyPonesPage() {
        WebDriverContext.getDriver().get(SONY_PRODUCTS_PHONES_PAGE_URL);
        String errMessage = "We are  verifying title of sony phones page";
        softAssert.assertTrue(WebDriverContext.getDriver().getTitle().equals(SONY_PRODUCTS_PHONES_PAGE_TITLE), errMessage);
    }

    @Test(dependsOnMethods = {"verifySonyPonesPage"})
    public void verifySonyExperiaPage() {
        WebDriverContext.getDriver().get(SONY_EXPERIA_PAGE_URL);
        String errMessage = "We are  verifying title of sony experia page";
        softAssert.assertTrue(WebDriverContext.getDriver().getTitle().equals(SONY_EXPERIA_PAGE_TITLE), errMessage);
    }

    @AfterTest
    public void showInfo() {
        {
            RequestsTable.printRequestInfo();
        }

    }
}