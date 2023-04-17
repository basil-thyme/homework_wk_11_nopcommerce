package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.UUID;

public class RegisterTest extends BaseTest {

    static String generatedEmail;
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    /**
     * 1. UserShouldNavigateToRegisterPageSuccessfully
     * click on the ‘Register’ link
     * Verify the text ‘Register’
     */
    @Test
    public void UserShouldNavigateToRegisterPageSuccessfully() {
        WebElement clickRegister = driver.findElement(By.className("ico-register"));
        clickRegister.click();

        //Actual
        WebElement actualText = driver.findElement(By.className("page-title"));
        String actual = actualText.getText();

        //Expected
        String expected = "Register";

        //Assert
        Assert.assertEquals("Text is not visible", expected, actual);

    }

    /**
     * 2. userSholdRegisterAccountSuccessfully
     * click on the ‘Register’ link
     * Select gender radio button
     * Enter First name
     * Enter Last name
     * Select Day Month and Year
     * Enter Email address
     * Enter Password
     * Enter Confirm password
     * Click on REGISTER button
     * Verify the text 'Your registration completed’
     */

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        WebElement clickRegister = driver.findElement(By.className("ico-register"));
        clickRegister.click();

        WebElement radioButtonSelect = driver.findElement(By.xpath("//input[starts-with(@id,'gender')]"));
        radioButtonSelect.click();

        WebElement enterFirstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        enterFirstName.sendKeys("XYZ");

        WebElement enterLastName = driver.findElement(By.name("LastName"));
        enterLastName.sendKeys("ABC");

        WebElement selectDay = driver.findElement(By.name("DateOfBirthDay"));
        selectDay.sendKeys("6");

        WebElement selectMonth = driver.findElement(By.name("DateOfBirthMonth"));
        selectMonth.sendKeys("April");

        WebElement selectYear = driver.findElement(By.name("DateOfBirthYear"));
        selectYear.sendKeys("1985");

        String randomEmail = randomEmail();
        WebElement emailAddress = driver.findElement(By.id("Email"));
        emailAddress.sendKeys(randomEmail);
        RegisterTest.generatedEmail= randomEmail;
        System.out.println("Random email = " + generatedEmail);

        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("Prime1234");

        WebElement confirmPassword = driver.findElement(By.name("ConfirmPassword"));
        confirmPassword.sendKeys("Prime1234");

        WebElement clickRegisterButton = driver.findElement(By.cssSelector("button.button-1.register-next-step-button"));
        clickRegisterButton.click();

        WebElement actualText = driver.findElement(By.className("result"));
        //Actual
        String actual = actualText.getText();
        //Expected
        String expected = "Your registration completed";
        Assert.assertEquals("Text is not visible", expected, actual);

    }

    public String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@example.com";
    }



    @After
    public void tearDown() {
        closeBrowser();

    }


}
