package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.DecimalFormat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Jupiter_cart_advance_sel {
    private static DecimalFormat df = new DecimalFormat("0.00");
    private static DecimalFormat df1 = new DecimalFormat("0.0");


    public static void Cart_item_advance(WebDriver driver) throws InterruptedException {

        // implicit wait until element is found
        WebDriverWait wait = new WebDriverWait(driver, 30);

        // implicit wait until element is found and then click on contact to reach Shop page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Shop")));
        driver.findElement(By.linkText("Shop")).click();
        // int contains the quantity of the item
        int i;
        int j;
        int k;

        for (i = 0; i < 2; i++) {
            driver.findElement(By.cssSelector("#product-2 .btn")).click(); //Stuffed Frog
        }


        for ( j = 0; j < 5; j++) {
            driver.findElement(By.cssSelector("#product-4 .btn")).click(); //Fluffy Bunny
        }


        for ( k = 0; k < 3; k++) {
            driver.findElement(By.cssSelector("#product-7 .btn")).click(); //Valentine Bear
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart-count")));
        driver.findElement(By.cssSelector(".cart-count")).click();

        // get the price of each item.
        String a= driver.findElement(By.cssSelector(".cart-item:nth-child(1) > .ng-binding:nth-child(2)")).getText();
        assertThat(a, is("$10.99"));
        float item1 = Float.parseFloat(a.substring(1));

        String b= driver.findElement(By.cssSelector(".cart-item:nth-child(2) > .ng-binding:nth-child(2)")).getText();
        assertThat(b, is("$9.99"));
        float item2 = Float.parseFloat(b.substring(1));

        String c= driver.findElement(By.cssSelector(".cart-item:nth-child(3) > .ng-binding:nth-child(2)")).getText();
        assertThat(c, is("$14.99"));
        float item3 = Float.parseFloat(c.substring(1));

        // get the subtotal of the items

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart-item:nth-child(1) > .ng-binding:nth-child(4)")));
        String suba= driver.findElement(By.cssSelector(".cart-item:nth-child(1) > .ng-binding:nth-child(4)")).getText();
        float total1 = item1 * i; //calculating subtotal
        String subtotal1 =  "$" + df.format(total1); //append the $ and store it in string variable
        assertThat(suba, is(subtotal1)); //match with the value from get text


        String subb= driver.findElement(By.cssSelector(".cart-item:nth-child(2) > .ng-binding:nth-child(4)")).getText();
        float total2 = item2 * j; //calculating subtotal
        String subtotal2 = "$"+ df.format(total2); //append the $ and store it in string variable
        assertThat(subb, is(subtotal2));//match with the value from get text


        String subc= driver.findElement(By.cssSelector(".cart-item:nth-child(3) > .ng-binding:nth-child(4)")).getText();
        float total3 = item3 * k; //calculating subtotal
        String subtotal3 = "$" + df.format(total3); ///append the $ and store it in string variable
        assertThat(subc, is(subtotal3)); //match with the value from get text


        // get the final value of the items in cart
        float finaltotal = total1 + total2 + total3;
        String subvalue= driver.findElement(By.cssSelector("tfoot > tr:nth-child(1) > td")).getText();
        String appendfinalvalue= String.valueOf(df1.format(finaltotal)); //store it in string and then verify both
        String Finalvalue = "Total: " +appendfinalvalue;
        assertThat(Finalvalue, is(subvalue));

        // click on Empty Cart
        for(int l=0; l<3; l++) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-danger")));
            driver.findElement(By.cssSelector(".btn-danger")).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-footer > .btn-success")));
            driver.findElement(By.cssSelector(".modal-footer > .btn-success")).click();

        }
    }
}
