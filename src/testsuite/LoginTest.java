package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp(){
    openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
//        Enter “tomsmith” username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith");
//        Enter “SuperSecretPassword!” password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");
//        Click on ‘LOGIN’ button
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius' and @type='submit']"));
        loginButton.click();
//        Verify the text “Secure Area”
        String expectedMessage = "Secure Area";
        WebElement actualTextElement = driver.findElement(By.xpath("//h2[text()=' Secure Area']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Invalid Text", expectedMessage, actualMessage);
    }

    @Test
    public void verifyTheUsernameErrorMessage(){
//      Enter “tomsmith1” username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith1");
//      Enter “SuperSecretPassword!” password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");
//      Click on ‘LOGIN’ button
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius' and @type='submit']"));
        loginButton.click();
//      Verify the error message “Your password
//     is invalid!”
        String expectedMessage = "Your username is invalid!\n" +
                "×";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@id ='flash']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Invalid text",expectedMessage,actualMessage);
    }

    @Test
    public void verifyThePasswordErrorMessage(){
//    Enter “tomsmith” username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith");
//    Enter “SuperSecretPassword” password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword");
//    Click on ‘LOGIN’ button
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius' and @type='submit']"));
        loginButton.click();
//    Verify the error message “Your password
//     is invalid!”
        String expectedMessage = "Your password is invalid!\n" +
                "×";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Invalid text",expectedMessage,actualMessage);
    }




    @After
    public void tearDown(){
        closeBrowser();
    }
}
