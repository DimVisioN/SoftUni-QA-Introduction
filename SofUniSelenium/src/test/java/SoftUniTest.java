import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by ggeor on 11-Mar-17.       Replase 'xxx' with valid credentials
 */
public class SoftUniTest {
    private WebDriver driver;
    private static final String LOGIN_USERNAME = "xxx";
    private static final String LOGIN_PASSWORD = "xxx";
    // before
    @Before
    public void setUp() {
        // code executed before each test
        System.setProperty("webdriver.chrome.driver", "E:\\QA STUFF\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver
                .manage()
                .timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        this.driver
                .manage()
                .window()
                .maximize();
    }

    private void login() {
        this.driver.get("https://www.abv.bg/");

        WebElement usernameField
                = this.driver
                .findElement(By.id("username"));
        usernameField.sendKeys(LOGIN_USERNAME);

        WebElement passwordField
                = this.driver
                .findElement(By.id("password"));
        passwordField.sendKeys(LOGIN_PASSWORD);

        WebElement loginButton
                =this.driver
                .findElement(By.id("loginBut"));
        loginButton.click();

    }

    // test method          whatToTest_whatConditions_expectedResult
    @Test
    public void testLogin_validCredentials_expectedNavigationToProfile(){
        this.login();
        Assert.assertEquals("The profile URL should be: " + "https://nm60.abv.bg/Mail.html",
                "https://nm60.abv.bg/Mail.html",
                this.driver.getCurrentUrl()
        );
    }

    @Test
    public void testLogin_validCredentials_expectedUserName(){
        this.login();

        WebElement loggedUserNameField
                =this.driver
                .findElement(By.xpath("//*[@id=\"middlePagePanel\"]/div[1]/div[1]"));
        String loggedUserNameText = loggedUserNameField.getText().trim();
        boolean expectedUsername = loggedUserNameText.endsWith("xxx xxx");
        Assert.assertTrue("User Name should end with" + "xxx xxx", expectedUsername);
    }

    @Test
    public void testLogin_validCredentials_expectedUserEmail(){
        this.login();

        WebElement loggedUserEmail
                =this.driver
                .findElement(By.xpath("//*[@id=\"middlePagePanel\"]/div[1]/div[2]"));

        String expectedEmail = "xxx@abv.bg";
        Assert.assertEquals("Email should be: " + "(" + expectedEmail + ")",
                "(" + expectedEmail + ")", loggedUserEmail
                        .getText()
                        .trim()
        );
    }

    // after
    @After
    public void tearDown(){
        //what happens after each test
        this.driver.quit();
    }
}
