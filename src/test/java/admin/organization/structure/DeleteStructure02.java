package admin.organization.structure;

import config.env_target;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeleteStructure02 extends env_target {
    @Test //Delete button successful
    public void main(){
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
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.name("username")),
                        ExpectedConditions.visibilityOfElementLocated(By.name("password")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit'][text()[contains(., 'Login')]]"))
                )
        );
        //Set element locate
        //Input username and password
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        //Click login button
        driver.findElement(By.xpath("//button[@type='submit'][text()[contains(., 'Login')]]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/web/index.php/admin/viewAdminModule'][contains(., 'Admin')]"))
        );
        //Set element locate
        //Click on the admin menu
        driver.findElement(By.xpath("//a[@href='/web/index.php/admin/viewAdminModule'][contains(., 'Admin')]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='oxd-topbar-body-nav-tab --parent'][contains(., 'Organization')]"))
        );
        //Set element locate
        //Click on the Organization menu
        driver.findElement(By.xpath("//li[@class='oxd-topbar-body-nav-tab --parent'][contains(., 'Organization')]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='oxd-topbar-body-nav-tab-link'][text()[contains(., 'General Information')]]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='oxd-topbar-body-nav-tab-link'][text()[contains(., 'Locations')]]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='oxd-topbar-body-nav-tab-link'][text()[contains(., 'Structure')]]"))
                )
        );
        //Set element locate
        //Click on the Structure menu
        driver.findElement(By.xpath("//*[@class='oxd-topbar-body-nav-tab-link'][text()[contains(., 'Structure')]]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()[contains(., 'Edit')]]"))
        );
        //Set element locate
        //Click on the edit button
        driver.findElement(By.xpath("//label[text()[contains(., 'Edit')]]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div[3]/ul/li/ul/li[2]/div[1]/span/button"))
        );
        //Set element locate
        //Click dropdown
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div[3]/ul/li/ul/li[2]/div[1]/span/button")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div[3]/ul/li/ul/li[2]/ul/li[1]/div[1]/div/div/div[2]/button[1]"))
        );
        //Set element locate
        //Click on the delete 2 button
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div[3]/ul/li/ul/li[2]/ul/li[1]/div[1]/div/div/div[2]/button[1]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button'][text()[contains(., ' Yes, Delete ')]]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button'][text()[contains(., ' No, Cancel ')]]"))
                )
        );
        //Set element locate
        //Click Yes, Delete button
        driver.findElement(By.xpath("//button[@type='button'][text()[contains(., ' Yes, Delete ')]]")).click();
        //Set case stop tunggu
        //Delete success message
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast'][contains(., 'Successfully Deleted')]"))
        );
        //Quit chrome
        driver.quit();
    }
}
