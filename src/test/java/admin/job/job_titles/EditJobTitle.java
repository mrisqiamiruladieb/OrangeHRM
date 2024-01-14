package admin.job.job_titles;

import config.env_target;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;

import java.time.Duration;

public class EditJobTitle extends env_target {
    @Test //Successfully edit job title
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
        //Click on job titles
        driver.findElement(By.xpath("//*[@class='oxd-topbar-body-nav-tab-link'][text()[contains(., 'Job Titles')]]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-table'][@role='table']")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[2]/div/div[4]/div/button[2]"))
                )
        );
        //Set element locate
        //Click edit button
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[2]/div/div[4]/div/button[2]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@placeholder='Type description here']")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div/div[2]/div")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@placeholder='Add note']")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit'][text()[contains(., 'Save')]]"))
                )
        );
        //Set element locate
        //Job title - delete old data and fill in new data
        Actions jobTitleActions = new Actions(driver);
        jobTitleActions.click(driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")))
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE)
                .sendKeys("editJobTitle").build().perform();
        //Input job description
        driver.findElement(By.xpath("//textarea[@placeholder='Type description here']")).sendKeys("Proin placerat purus at mauris viverra pharetra. Vestibulum quis cursus.");
        //Input file - job specification
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div/div[2]/input")).sendKeys("C:\\Users\\ACER\\Downloads\\Peduli Lindungi.png");
        //Input note
        driver.findElement(By.xpath("//textarea[@placeholder='Add note']")).sendKeys("Cras ac tempus risus, ut mattis odio. Pellentesque quis est laoreet, sodales sem vel, tempor.");
        //Click save button
        driver.findElement(By.xpath("//button[@type='submit'][text()[contains(., 'Save')]]")).click();
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
        //Click on job titles
        driver.findElement(By.xpath("//*[@class='oxd-topbar-body-nav-tab-link'][text()[contains(., 'Job Titles')]]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-table'][@role='table']")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[2]/div/div[4]/div/button[2]"))
                )
        );
        //Set element locate
        //Click edit button
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[2]/div/div[4]/div/button[2]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit'][text()[contains(., 'Save')]]"))
                )
        );
        //Set element locate
        //Job title - blank
        Actions jobTitleActions = new Actions(driver);
        jobTitleActions.click(driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")))
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE)
                .build().perform();
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
