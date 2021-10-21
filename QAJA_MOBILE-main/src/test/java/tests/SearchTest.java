package tests;

import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.pages.factory.OnboardingPageFactory;
import lib.ui.pages.factory.SearchPageFactory;
import lib.ui.pages.factory.StartPageFactory;
import lib.ui.pages.interfaces.IOnboardingPageObject;
import lib.ui.pages.interfaces.ISearchPageObject;
import lib.ui.pages.interfaces.IStartPageObject;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class SearchTest extends CoreTestCase {

    @Test
    public void testFindJavaForIos() {

        MainPageObject mainPo = new MainPageObject(this.driver);

        WebElement skipButton = mainPo.waitForElementPresent(
                "id:Skip",
                "Cannot find Search Wikipedia init search input"
        );
        skipButton.click();

        WebElement searchInit = mainPo.waitForElementPresent(
                "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']",
                "Cannot find Search Wikipedia init search input"
        );
        searchInit.click();

        WebElement searchInput = mainPo.waitForElementPresent(
                "xpath://XCUIElementTypeSearchField[@value = 'Search Wikipedia']",
                "Cannot find search input"

        );
        searchInput.sendKeys("Java");

        WebElement expectedResult = mainPo.waitForElementPresent(
                "xpath://*[./*[contains(@name,'Island of Indonesia')]]",
                "Cannot find result 'Island of Indonesia' on 'Java' search"
        );
        expectedResult.click();


    }

}