package Stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.UUID;

import static java.util.UUID.randomUUID;
import static org.junit.Assert.assertEquals;

public class MyStepdefs {
    WebDriver driver = new FirefoxDriver();

    @Given("user is on the correct website")
    public void userIsOnTheCorrectWebsite() {
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
    }

    @When("user enters valid date of birth")
    public void userEntersValidDateOfBirth() {
        WebElement datepicker = driver.findElement(By.id("dp"));
        datepicker.click();

        WebElement yearclick = driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/thead/tr[2]/th[2]"));
        yearclick.click();


        for (int i = 0; i < 24; i++) {
            WebElement leftArrow = driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/thead/tr[2]/th[1]/i"));
            leftArrow.click();
        }

        WebElement monthPick = driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr/td/span[1]"));
        monthPick.click();

        WebElement dayPick = driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/tbody/tr[1]/td[7]"));
        dayPick.click();

        String expected = "01/01/2000";
        assertEquals(expected, datepicker.getAttribute("value"));

    }


    @When("user enters valid  correct firstname")
    public void userEntersValidCorrectFirstname() {
        WebElement firstName = driver.findElement(By.id("member_firstname"));
        firstName.sendKeys("Jonas");
    }

    @When("user enters valid correct lastname")
    public void userEntersValidCorrectLastname() {
        WebElement lastName = driver.findElement(By.id("member_lastname"));
        lastName.sendKeys("Rasmusson");
    }

    @When("user enters valid email adress")
    public void userEntersValidEmailAdress() {
        final String randomEmail=generateRandomEmail();
        WebElement email = driver.findElement(By.id("member_emailaddress"));
        WebElement emailConformation = driver.findElement(By.id("member_confirmemailaddress"));
        email.sendKeys(randomEmail);
        emailConformation.sendKeys(randomEmail);
    }


    @When("user enters valid password")
    public void userEntersValidPassword() {
        WebElement password = driver.findElement(By.id("signupunlicenced_password"));
        WebElement passwordConfirm = driver.findElement(By.id("signupunlicenced_confirmpassword"));
        password.sendKeys("HeJsan4321");
        passwordConfirm.sendKeys("HeJsan4321");
    }

    @When("user clicks terms and conditions box")
    public void userClicksTermsAndConditionsBox() {
        WebElement terms = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[11]/div/div[2]/div[1]/label/span[3]"));
        terms.click();
    }

    @When("user clicks above required age box")
    public void userClicksAboveRequiredAgeBox() {
        WebElement agereq = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[11]/div/div[2]/div[2]/label/span[3]"));
        agereq.click();
    }

    @When("user clicks code of ethics box")
    public void userClicksCodeOfEthicsBox() {
        WebElement codeofEthic = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[11]/div/div[7]/label/span[3]"));
        codeofEthic.click();
    }

    @Then("an account is created")
    public void anAccountIsCreated() {
        WebElement confirmButton = driver.findElement(By.name("join"));
        confirmButton.click();
        WebElement lockerButton= driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/a"));
        String expected="GO TO MY LOCKER";
        String actual= lockerButton.getText();
        assertEquals(expected,actual);
    }


    @Then("a error message is shown")
    public void aErrorMessageIsShown() {
        WebElement youMust = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[11]/div/div[2]/div[1]/span/span"));
        String actual = youMust.getText();
        String expected = "You must confirm that you have read and accepted our Terms and Conditions";
        assertEquals(expected, actual);
    }

    @When("user enters diffrent password confirmation")
    public void userEntersDiffrentPasswordConfirmation() {
        WebElement password = driver.findElement(By.id("signupunlicenced_password"));
        password.sendKeys("HeJsan4321");
        WebElement passwordConfirm = driver.findElement(By.id("signupunlicenced_confirmpassword"));
        passwordConfirm.sendKeys("EJsan4321");

    }


    @Then("a password does not match is shown")
    public void aPasswordDoesNotMatchIsShown() {
        WebElement passwordWrong = driver.findElement(By.cssSelector("span.field-validation-error:nth-child(3) > span:nth-child(1)"));
        String actual = passwordWrong.getText();
        String expected = "Password did not match";
        assertEquals(expected, actual);
    }


    @Then("a last name is missing is shown")
    public void aLastNameIsMissingIsShown() {
        WebElement lastNameReq = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[5]/div[2]/div/span/span"));
        String actual = lastNameReq.getText();
        String expected = "Last Name is required";
        assertEquals(expected, actual);
    }


    @When("user click confirm and join button")
    public void userClickConfirmAndJoinButton() {
        WebElement confirmButton = driver.findElement(By.name("join"));
        confirmButton.click();
    }


    private String generateRandomEmail() {
       return "random" + randomUUID() + "@gmail.com";
    }


}


