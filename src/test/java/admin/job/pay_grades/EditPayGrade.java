package admin.job.pay_grades;

import config.env_target;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;

import java.security.Key;
import java.time.Duration;

public class EditPayGrade extends env_target {
    @Test //Successfully edit pay grade & currency
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
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='oxd-topbar-body-nav-tab --parent'][contains(., 'Job ')]"))
        );
        //Set element locate
        //Click the job menu
        driver.findElement(By.xpath("//li[@class='oxd-topbar-body-nav-tab --parent'][contains(., 'Job ')]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='oxd-topbar-body-nav-tab-link'][text()[contains(., 'Job Titles')]]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='oxd-topbar-body-nav-tab-link'][text()[contains(., 'Pay Grades')]]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='oxd-topbar-body-nav-tab-link'][text()[contains(., 'Employment Status')]]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='oxd-topbar-body-nav-tab-link'][text()[contains(., 'Job Categories')]]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='oxd-topbar-body-nav-tab-link'][text()[contains(., 'Work Shifts')]]"))
                )
        );
        //Set element locate
        //Click on pay grades
        driver.findElement(By.xpath("//*[@class='oxd-topbar-body-nav-tab-link'][text()[contains(., 'Pay Grades')]]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='oxd-text oxd-text--span'][text()[contains(., 'Records Found')]]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[1]/div/div[4]/div/button[2]"))
                )
        );
        //Set element locate
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[1]/div/div[4]/div/button[2]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div[1]/div/form/div[1]/div/div/div/div[2]/input")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div[1]/div/form/div[2]/button[2]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='oxd-text oxd-text--span'][text()[contains(., 'Record Found')]]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div/div/div[5]/div/button[2]"))
                )
        );
        //Set element locate
        //Pay Grade - delete old data and fill in new data
        Actions payGradeActions = new Actions(driver);
        payGradeActions.click(driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div[1]/div/form/div[1]/div/div/div/div[2]/input")))
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys("edit_pay_grade_test")
                .build().perform();
        //Click save button
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div[1]/div/form/div[2]/button[2]")).click();
        //Set case stop tunggu
        //Update success message
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast'][contains(., 'Successfully Updated')]"))
        );
        //Set element locate
        //Edit currency
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div/div/div[5]/div/button[2]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[1]/div/div[2]/input")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/div/div[2]/input")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div[2]/form/div[3]/button[2]"))
                )
        );
        //Set element locate
        //Currency - delete old data and fill in new data
        Actions currencyMinActions = new Actions(driver);
        currencyMinActions.click(driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[1]/div/div[2]/input")))
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys("1500000")
                .build().perform();
        Actions currencyMaxActions = new Actions(driver);
        currencyMaxActions.click(driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/div/div[2]/input")))
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys("5000000")
                .build().perform();
        //Click save button
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div[2]/form/div[3]/button[2]")).click();
        //Set case stop tunggu
        //Update success message
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast'][contains(., 'Successfully Updated')]"))
        );
        //Quit chrome
        driver.quit();
    }

    @Test //Errors or data required
    public void failed(){
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
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='oxd-topbar-body-nav-tab --parent'][contains(., 'Job ')]"))
        );
        //Set element locate
        //Click the job menu
        driver.findElement(By.xpath("//li[@class='oxd-topbar-body-nav-tab --parent'][contains(., 'Job ')]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='oxd-topbar-body-nav-tab-link'][text()[contains(., 'Job Titles')]]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='oxd-topbar-body-nav-tab-link'][text()[contains(., 'Pay Grades')]]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='oxd-topbar-body-nav-tab-link'][text()[contains(., 'Employment Status')]]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='oxd-topbar-body-nav-tab-link'][text()[contains(., 'Job Categories')]]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='oxd-topbar-body-nav-tab-link'][text()[contains(., 'Work Shifts')]]"))
                )
        );
        //Set element locate
        //Click on pay grades
        driver.findElement(By.xpath("//*[@class='oxd-topbar-body-nav-tab-link'][text()[contains(., 'Pay Grades')]]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='oxd-text oxd-text--span'][text()[contains(., 'Records Found')]]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[1]/div/div[4]/div/button[2]"))
                )
        );
        //Set element locate
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[1]/div/div[4]/div/button[2]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div[1]/div/form/div[1]/div/div/div/div[2]/input")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div[1]/div/form/div[2]/button[2]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='oxd-text oxd-text--span'][text()[contains(., 'Record Found')]]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div/div/div[5]/div/button[2]"))
                )
        );
        //Set element locate
        //Pay Grade - blank
        Actions payGradeActions = new Actions(driver);
        payGradeActions.click(driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div[1]/div/form/div[1]/div/div/div/div[2]/input")))
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE)
                .build().perform();
        //Click save button
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div[1]/div/form/div[2]/button[2]")).click();
        //Set case stop tunggu
        //Error messages
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"))
        );
        //Quit chrome
        driver.quit();
    }
}
