package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    @Given("Basarili giris yapma")
    public void basariliGirisYapma() {
    }

    @When("Kullanıcı ana sayfayı açar")
    public void kullanıcıAnaSayfayıAçar() {
    }

    @When("{string} menü öğeleri görünmelidir")
    public void menüÖğeleriGörünmelidir(String arg0) {
    }

    @When("Kullanıcı  {string} menü öğesine tıklar")
    public void kullanıcıMenüÖğesineTıklar(String arg0) {
    }

    @Then("Kullanıcı {string} sayfasında olmalıdır")
    public void kullanıcıSayfasındaOlmalıdır(String arg0) {
    }
}
