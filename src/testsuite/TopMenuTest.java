package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    /**
     * 1. userShouldNavigateToComputerPageSuccessfully
     * click on the ‘Computers’ Tab
     * Verify the text ‘Computers’
     */
    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        WebElement clickTab = driver.findElement(By.linkText("Computers"));
        clickTab.click();

        //Actual
        WebElement actualText = driver.findElement(By.className("page-title"));
        String actual = actualText.getText();
        //Expected
        String expected = "Computers";
        //Assert
        Assert.assertEquals("Text is not visible", expected, actual);

    }

    /**
     * 2. userShouldNavigateToElectronicsPageSuccessfully
     * click on the ‘Electronics’ Tab
     * Verify the text ‘Electronics’
     */
    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        WebElement clickTab = driver.findElement(By.xpath("//a[@href='/electronics']"));
        clickTab.click();
        //Actual
        WebElement actualText = driver.findElement(By.className("page-title"));
        String actual = actualText.getText();

        //Expected
        String expected = "Electronics";

        //Assert
        Assert.assertEquals("Text is not visible", expected, actual);


    }

    /**
     * 3.userShouldNavigateToApparelPageSuccessfully
     * click on the ‘Apparel’ Tab
     * Verify the text ‘Apparel’
     */
    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {

        WebElement clickTab = driver.findElement(By.xpath("//a[@href='/apparel']"));
        clickTab.click();

        //Actual
        WebElement actualText = driver.findElement(By.className("page-title"));
        String actual = actualText.getText();

        //Expected
        String expected = "Apparel";

        //Assert
        Assert.assertEquals("Text is not visible", expected, actual);

    }

    /**
     * 4.userShouldNavigateToDigitalDownloadsPageSuccessfull
     * click on the ‘Digital downloads’ Tab
     * Verify the text ‘Digital downloads’
     */
    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        WebElement clickTab = driver.findElement(By.linkText("Digital downloads"));
        clickTab.click();

        //Actual
        WebElement actualText = driver.findElement(By.className("page-title"));
        String actual = actualText.getText();

        //Expected
        String expected = "Digital downloads";

        //Assert
        Assert.assertEquals("Text is not visible", expected, actual);


    }

    /**
     * 5. userShouldNavigateToBooksPageSuccessfully
     * click on the ‘Books’ Tab
     * Verify the text ‘Books’
     */
    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {

        WebElement clickTab = driver.findElement(By.linkText("Books"));
        clickTab.click();

        //Actual
        WebElement actualText = driver.findElement(By.className("page-title"));
        String actual = actualText.getText();

        //Expected
        String expected = "Books";

        //Assert
        Assert.assertEquals("Text is not visible", expected, actual);

    }

    /**
     * 6. userShouldNavigateToJewelryPageSuccessfully
     * click on the ‘Jewelry’ Tab
     * Verify the text ‘Jewelry’
     */
    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {
        WebElement clickTab = driver.findElement(By.linkText("Jewelry"));
        clickTab.click();

        //Actual
        WebElement actualText = driver.findElement(By.className("page-title"));
        String actual = actualText.getText();

        //Expected
        String expected = "Jewelry";

        //Assert
        Assert.assertEquals("Text is not visible", expected, actual);

    }

    /**
     * 7. userShouldNavigateToGiftCardsPageSuccessfull
     * click on the ‘Gift Cards’ Tab
     * Verify the text ‘Gift Cards’
     */
    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        WebElement clickTab = driver.findElement(By.linkText("Gift Cards"));
        clickTab.click();

        //Actual
        WebElement actualText = driver.findElement(By.className("page-title"));
        String actual = actualText.getText();

        //Expected
        String expected = "Gift Cards";

        //Assert
        Assert.assertEquals("Text is not visible", expected, actual);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
