import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Lala_TC {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod

    public void setup () {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\techno\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://campus.techno.study/");
        driver.manage().window().maximize();
    }

    @Test
    public void setLogin() throws InterruptedException {
        String email ="ismayilovalala2@gmail.com";
        String password = "1234inputTEST";

        WebElement acceptALlCookies = driver.findElement(By.cssSelector("button[class='consent-give']"));
        acceptALlCookies.click();

        WebElement emailInput = driver.findElement(By.id("mat-input-0"));
        emailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.id("mat-input-1"));
        passwordInput.sendKeys(password);


        WebElement loginButton = driver.findElement(By.cssSelector("span[class='mat-button-wrapper']"));
        loginButton.click();

        WebElement calendarButton = driver.findElement(By.cssSelector("button[class='mat-focus-indicator mat-button mat-button-base mat-button-wrapper mat-button-unchecked']"));
        calendarButton.click();

        Thread.sleep(3000);

        String currentURL =driver.getCurrentUrl();
        System.out.println("Current URL : " + currentURL);

        String currentURLTwo = "https://campus.techno.study/courses-calendar";

        if (currentURL.equals(currentURLTwo)) {
            System.out.println("Pass");
        }else
            System.out.println("Fail");



    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}


