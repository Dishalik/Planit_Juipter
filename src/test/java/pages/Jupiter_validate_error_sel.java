package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class Jupiter_validate_error_sel {

    public static void Validate_error(WebDriver driver) {

        // implicit wait until element is found
        WebDriverWait wait = new WebDriverWait(driver, 15);

        // click on contact to reach contact page
        driver.findElement(By.linkText("Contact")).click();

        // implicit wait until submit button is found
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-primary")));
        driver.findElement(By.cssSelector(".btn-primary")).click();

        // assert the error messages of Forename, Email and Message
        assertThat(driver.findElement(By.cssSelector(".control-group:nth-child(1) > .controls")).getText(), is("Forename is required"));
        assertThat(driver.findElement(By.cssSelector("#email-err")).getText(), is("Email is required"));
        assertThat(driver.findElement(By.cssSelector("#message-group > .controls")).getText(), is("Message is required"));

        // enter the details of Forename, surname, email, telephone number and message
        driver.findElement(By.id("forename")).click();
        driver.findElement(By.id("forename")).sendKeys("Aarya");
        driver.findElement(By.id("surname")).click();
        driver.findElement(By.id("surname")).sendKeys("JAmeson");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("aarya.jameson@gmail.com");
        driver.findElement(By.id("telephone")).click();
        driver.findElement(By.id("telephone")).sendKeys("0413065691");
        driver.findElement(By.id("message")).click();
        driver.findElement(By.id("message")).sendKeys("Please see the entered details");

        // click on submit button
        driver.findElement(By.linkText("Submit")).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // implicit wait until Thank you message is display
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success")));
        driver.findElement(By.cssSelector(".alert-success")).click();
        driver.findElement(By.cssSelector(".btn:nth-child(2)")).click();
    }

}
