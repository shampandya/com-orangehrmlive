package project2;
/**
 * Project-2 - ProjectName : com-orangehrmlive
 * BaseUrl = https://opensource-demo.orangehrmlive.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Forgot your password?’ link.
 * 7. Print the current url.
 * 8. Navigate back to the login page.
 * 9. Refresh the page.
 * 10. Enter the email to email field.
 * 11. Enter the password to password field.
 * 12. Click on Login Button.
 * 13. Close the browser.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Com_OrangehrmLive {
    static String browser = "Chrome";
    static String baseurl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        if(browser.equalsIgnoreCase("Chrome")){
             driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        }else if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }else {
            System.out.println("Invalid Input");
        }
        driver.get(baseurl);  // open url
        //Maximize the window
        driver.manage().window().maximize();
        //Timeout for hold the page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println(driver.getTitle()); // print the title of the page
        System.out.println(driver.getCurrentUrl()); // print the current url
        System.out.println(driver.getPageSource());  // get the page source
        WebElement pass = driver.findElement(By.className("orangehrm-login-forgot-header"));
        pass.click();
        System.out.println(driver.getCurrentUrl()); // print the current url
        driver.navigate().back();  // navigate back to the login page
        driver.navigate().refresh();  // refresh the page
        driver.findElement(By.name("username")).sendKeys("Admin");  // enter the username to username field
        driver.findElement(By.name("password")).sendKeys("admin123");  //enter the password to password field
        //Click on login button
        WebElement login = driver.findElement(By.className("orangehrm-login-button"));
        login.click();

        driver.quit();
    }
}
