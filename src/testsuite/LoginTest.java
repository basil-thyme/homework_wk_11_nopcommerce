package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    /**
     * 1. userShouldNavigateToLoginPageSuccessfully
     * click on the ‘Login’ link
     * Verify the text ‘Welcome, Please Sign In!’
     */


    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Store Locator
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        WebElement loginPageTitle = driver.findElement(By.className("page-title"));
        //Actual
        String actualMessage = loginPageTitle.getText();
        //Expected
        String expectedMessage = "Welcome, Please Sign In!";
        //Assert
        Assert.assertEquals("Text doesn't match", expectedMessage, actualMessage);

    }

    /***  userShouldLoginSuccessfullyWithValidCredentials
     * click on the ‘Login’ link
     * Enter valid username
     * Enter valid password
     * Click on ‘LOGIN’ button
     * Verify the ‘Log out’ text is display*/


    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        WebElement enterValidUsername = driver.findElement(By.xpath("//input[@id = 'Email']"));
        //System.out.println("Generated Email " +RegisterTest.generatedEmail );
        enterValidUsername.sendKeys("random-4e86262d-2018-4288-919e-7c76141b6920@example.com");

        WebElement enterValidPassword = driver.findElement(By.xpath("//input[@id = 'Password']"));
        enterValidPassword.sendKeys("Prime1234");

        WebElement enterLoginButton = driver.findElement(By.cssSelector("button.button-1.login-button"));
        enterLoginButton.click();

        WebElement logoutText = driver.findElement(By.cssSelector("a.ico-logout"));
        //Actual
        String actual = logoutText.getText();

        //Expected
        String expected = "Log out";

        //Assert
        Assert.assertEquals("Logout is not displayed", expected, actual);
    }

    /**
     * click on the ‘Login’ link
     * Enter invalid username
     * Enter invalid password
     * Click on Login button
     * Verify the error message ‘Login was unsuccessful.
     * Please correct the errors and try again. No customer account found’
     */
    @Test
    public void verifyTheErrorMessage() {
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        WebElement enterInvalidUsername = driver.findElement(By.xpath("//input[@id = 'Email']"));
        enterInvalidUsername.sendKeys("randomabc12345@gmail.com");

        WebElement enterInvalidPassword = driver.findElement(By.xpath("//input[@id = 'Password']"));
        enterInvalidPassword.sendKeys("Prime123");

        WebElement enterLoginButton = driver.findElement(By.cssSelector("button.button-1.login-button"));
        enterLoginButton.click();

        //Actual
        WebElement actualMessage = driver.findElement(By.cssSelector("div.message-error.validation-summary-errors"));
        String actual = actualMessage.getText();
        //Expected

        String expected = "Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found";
        //Assert
        Assert.assertEquals("Error message is not displayed", expected, actual);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
