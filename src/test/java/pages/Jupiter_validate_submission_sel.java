package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Jupiter_validate_submission_sel {

    public static void Validate_submission(WebDriver driver) {

        // implicit wait until element is found
        WebDriverWait wait = new WebDriverWait(driver, 30);

        // implicit wait until element is found and then click on contact to reach contact page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Contact")));
        driver.findElement(By.linkText("Contact")).click();

        // implicit wait until Forename is found
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("forename")));
        driver.findElement(By.id("forename")).click();
        driver.findElement(By.id("forename")).sendKeys("candidate 1"); // enter the forename
        driver.findElement(By.id("surname")).click();
        driver.findElement(By.id("surname")).sendKeys("sample surname"); // enter the surname
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("candidate.surname@gmail.com"); // enter the email
        driver.findElement(By.id("message")).click();
        driver.findElement(By.id("message")).sendKeys("This is task 2."); // enter the message
        driver.findElement(By.linkText("Submit")).click();

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        // implicit wait until Success Message is displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success")));
        // assert the element is present
        assertThat(driver.findElement(By.cssSelector(".alert-success")).getText(), is("Thanks candidate 1, we appreciate your feedback."));
        driver.findElement(By.cssSelector(".btn:nth-child(2)")).click();

    }

}
