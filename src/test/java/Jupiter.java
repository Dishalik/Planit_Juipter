import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Jupiter_cart_advance_sel;
import pages.Jupiter_carts_item_sel;
import pages.Jupiter_validate_error_sel;
import pages.Jupiter_validate_submission_sel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Jupiter{

        public static void main(String args[]) throws InterruptedException, IOException {
            System.setProperty("webdriver.chrome.driver", "src//drivers//chromedriver"); // setproperty to get the driver path


            WebDriver driver = new ChromeDriver();
                setUp(driver); // calling the setup driver

                Jupiter_validate_error(driver); // call the task

                tearDown(driver); // calling to quit the driver after completion of task

        }


            @Before
            public  static void setUp(WebDriver driver) throws IOException {
                Properties prop = new Properties();
                FileInputStream ip= new FileInputStream("src/test/resources/config.properties");
                prop.load(ip);

                String URL1 = prop.getProperty("URL1");
                String URL2 = prop.getProperty("URL2");

                driver.get(URL1);
                driver.manage().window().maximize();

            }
            @After
            public static void tearDown(WebDriver driver) {
                System.out.println("ChromeDriver was successfully Closed!!!");
                driver.quit();
            }
            @Test
            public static void Jupiter_validate_error(WebDriver driver) throws InterruptedException {

               // Task 1
                Jupiter_validate_error_sel.Validate_error(driver);
                System.out.println("Task 1 Test is Passed.");

                // Task 2 this test will run 5 times to ensure 100% pass rate
                for(int i=1; i<=5; i++)
                {
                    Jupiter_validate_submission_sel.Validate_submission(driver);
                    System.out.println( i+ " Test Passed");
                }
                System.out.println("Task 2 Test is Passed 100%"); // when test case are passed it will display in console

                // Task 3 add the items in cart
                Jupiter_carts_item_sel.Cart_item(driver);
                System.out.println("Task 3 Test is Passed.");

                // Task 4 for advance cart verification
                Jupiter_cart_advance_sel.Cart_item_advance(driver);
                System.out.println("Task 4 Test is Passed.");

            }

    }


