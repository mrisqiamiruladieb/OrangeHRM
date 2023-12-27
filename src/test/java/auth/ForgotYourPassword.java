package auth;

import config.env_target;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotYourPassword extends env_target {
    @Test
    public void main(){ //Reset Password link sent successfully
        //Set driver location path
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\drivers\\chromedriver.exe");
        //Maximize driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Set url
        driver.get(baseUrl);
        //Set waktu tunggu
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()[contains(., 'Forgot your password?')]]"))
        );
        //Set element locate
        driver.findElement(By.xpath("//p[text()[contains(., 'Forgot your password?')]]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.name("username")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit'][text()[contains(., 'Reset Password')]]"))
                )
        );
        //Set element locate
        driver.findElement(By.name("username")).sendKeys("lupa_password");
        driver.findElement(By.xpath("//button[@type='submit'][text()[contains(., 'Reset Password')]]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()[contains(., 'Reset Password link sent successfully')]]"))
        );
        //Quit chrome
        driver.quit();
    }
}
