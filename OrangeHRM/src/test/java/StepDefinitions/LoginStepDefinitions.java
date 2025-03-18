package StepDefinitions;

import Pages.LoginPage;
import Util.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginStepDefinitions {
    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage;

    public LoginStepDefinitions() {
        loginPage = new LoginPage(driver);
    }

    @Given("login paneline girilir")
    public void loginPanelineGirilir() {
        LoginPage.loginPanelGirilir();
    }

    @When("{string} kullanici adi girilir")
    public void kullaniciAdiGirilir(String username) {
        LoginPage.kullaniciadiGir(username);

    }

    @When("{string} parola girilir")
    public void parolaGirilir(String password) {
        LoginPage.parolaGir(password);
    }

    @When("login butonuna tiklanir")
    public void loginButonunaTiklanir() {
        LoginPage.loginButonTikla();
    }

    @Then("{string} hata mesaji beklenir")
    public void hataMesajiBeklenir(String error) {
        LoginPage.hataMesajiBekle(error);
    }

    @Then("Dashboard acilmesi beklenir")
    public void dashboardAcilmesiBeklenir() {
        LoginPage.dashboardAcilmesiBekle();
    }
}
