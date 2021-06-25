package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Jupiter_carts_item_sel {

    public static void Cart_item(WebDriver driver) throws InterruptedException {

        //implicit wait until element is found
        WebDriverWait wait = new WebDriverWait(driver, 30);

        //implicit wait until element is found and then click on contact to reach contact page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Shop")));
        driver.findElement(By.linkText("Shop")).click();

        //loop to Click buy button 2 times on “Funny Cow”
        for(int i=0; i<2; i++)
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#product-6 .btn")));
            driver.findElement(By.cssSelector("#product-6 .btn")).click();
        }

        //Click buy button 1 time on “Fluffy Bunny”
        driver.findElement(By.cssSelector("#product-4 .btn")).click();

        //Click on cart
        driver.findElement(By.cssSelector(".cart-count")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart-item:nth-child(1) > .ng-binding:nth-child(1)")));
        //Assert if the cart has the same items
        assertThat(driver.findElement(By.cssSelector(".cart-item:nth-child(1) > .ng-binding:nth-child(1)")).getText(), is("Funny Cow"));
        assertThat(driver.findElement(By.cssSelector(".cart-item:nth-child(2) > .ng-binding:nth-child(1)")).getText(), is("Fluffy Bunny"));

        //click on Empty Cart
        for(int j=0; j<2; j++) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-danger")));
            driver.findElement(By.cssSelector(".btn-danger")).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-footer > .btn-success")));
            driver.findElement(By.cssSelector(".modal-footer > .btn-success")).click();
        }

}
}
