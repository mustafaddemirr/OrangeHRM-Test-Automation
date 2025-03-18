package Pages;

import Util.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class LoginPage {

     static WebDriver driver;
     static ElementHelper elementHelper;
     static WebDriverWait wait ;

    static String url = "https://opensource-demo.orangehrmlive.com/";
    static By LoginText = By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > h5");
    static By Username = By.cssSelector("input[placeholder='Username']");
    static By Password = By.cssSelector("input[placeholder='Password']");
    static By usernameError = By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > form:nth-child(2) > div:nth-child(2) > div:nth-child(1) > span:nth-child(3)");
    static By passwordError = By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > form:nth-child(2) > div:nth-child(3) > div:nth-child(1) > span:nth-child(3)");
    static By LoginButton = By.cssSelector("button[type='submit']");
    static By InvalidMessage = By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > div > div.oxd-alert.oxd-alert--error > div.oxd-alert-content.oxd-alert-content--error");
    static By DashboardText = By.cssSelector(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");

    public LoginPage(WebDriver driver) {
        LoginPage.driver=driver;
        LoginPage.wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        LoginPage.elementHelper= new ElementHelper(driver);
    }

    public static void loginPanelGirilir() {
        driver.get(url);
        WebElement title = driver.findElement(LoginText);
        String titleText =title.getText();
        assertEquals(titleText,"Login");

    }

    public static void kullaniciadiGir(String username) {

        elementHelper.sendKey(Username,username);

    }

    public static void parolaGir(String password) {
        elementHelper.sendKey(Password,password);
    }

    public static void loginButonTikla() {
        elementHelper.click(LoginButton);
    }

    public static void hataMesajiBekle(String error) {

        String actualError = "";

        if (error.equals("Required")) {
            // Kullanıcı adı required kontrolü
            List<WebElement> UsernameError = driver.findElements(usernameError);
            List<WebElement> PasswordError = driver.findElements(passwordError);

            if (!UsernameError.isEmpty()) {
                actualError = UsernameError.getFirst().getText();
            } else if (!PasswordError.isEmpty()) {
                actualError = PasswordError.getFirst().getText();
            }
        }
        else if (error.equals("Invalid credentials")) {
           List<WebElement> invalidMessage =driver.findElements(InvalidMessage);
           if(!invalidMessage.isEmpty()){
               actualError=invalidMessage.getFirst().getText();
           }
        }
        assertEquals("Hata mesajı beklenenden farklı!", error, actualError);
        driver.quit();
    }

    public static void dashboardAcilmesiBekle() {
        elementHelper.checkVisible(DashboardText);
    }
}
