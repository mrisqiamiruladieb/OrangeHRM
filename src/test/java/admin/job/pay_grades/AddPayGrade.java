package admin.job.pay_grades;

import config.env_target;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddPayGrade extends env_target {
    @Test //Successfully add pay grade
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
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title'][text()[contains(., 'Pay Grades')]]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button'][text()[contains(., ' Add ')]]"))
                )
        );
        //Set element locate
        //Click add button
        driver.findElement(By.xpath("//button[@type='button'][text()[contains(., ' Add ')]]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/input")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit'][text()[contains(., 'Save')]]"))
                )
        );
        //Set element locate
        //Input pay grade
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/input")).sendKeys("add_pay_grade_test");
        //Click save button
        driver.findElement(By.xpath("//button[@type='submit'][text()[contains(., 'Save')]]")).click();
        //Set case stop tunggu
        //No records found info message
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-toast oxd-toast--info oxd-toast-container--toast'][contains(., 'No Records Found')]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='oxd-text oxd-text--span'][contains(., 'No Records Found')]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title'][text()[contains(., 'Currencies')]]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button'][text()[contains(., ' Add ')]]"))
                )
        );
        //Set element locate
        //Add Currency
        //Click add button
        driver.findElement(By.xpath("//button[@type='button'][text()[contains(., ' Add ')]]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div[2]/form/div[1]/div/div/div/div[2]/div/div")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[1]/div/div[2]/input")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/div/div[2]/input")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div[2]/form/div[3]/button[2]"))
                )
        );
        //Set element locate
        //Select currency
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div[2]/form/div[1]/div/div/div/div[2]/div/div")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option'][@class='oxd-select-option'][contains(., 'IDR - Indonesian Rupiah')]"))
        );
        //Set element locate
        //Click IDR - Indonesian Rupiah currency
        driver.findElement(By.xpath("//div[@role='option'][@class='oxd-select-option'][contains(., 'IDR - Indonesian Rupiah')]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-select-text oxd-select-text--active'][contains(., 'IDR - Indonesian Rupiah')]"))
        );
        //Set element locate
        //Input minimum salary
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[1]/div/div[2]/input")).sendKeys("3000000");
        //Input maximum salary
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/div/div[2]/input")).sendKeys("50000000");
        //Click save button
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div[2]/form/div[3]/button[2]")).click();
        //Set case stop tunggu
        //Save success message
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast'][contains(., 'Successfully Saved')]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='oxd-text oxd-text--span'][text()[contains(., 'Records Found')]]"))
                )
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
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title'][text()[contains(., 'Pay Grades')]]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button'][text()[contains(., ' Add ')]]"))
                )
        );
        //Set element locate
        //Click add button
        driver.findElement(By.xpath("//button[@type='button'][text()[contains(., ' Add ')]]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/input")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit'][text()[contains(., 'Save')]]"))
                )
        );
        //Set element locate
        //Click save button
        driver.findElement(By.xpath("//button[@type='submit'][text()[contains(., 'Save')]]")).click();
        //Set case stop tunggu
        //Error messages
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"))
        );
        //Quit chrome
        driver.quit();
    }
}
