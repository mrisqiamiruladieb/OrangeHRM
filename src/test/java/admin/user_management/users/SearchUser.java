package admin.user_management.users;

import config.env_target;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchUser extends env_target {
    @Test //successful search user
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
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Type for hints...']")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit'][text()[contains(., ' Search ')]]"))
                )
        );
        //Set element locate
        //Input username
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")).sendKeys("Admin");
        //Click user role
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option'][text()[contains(., '-- Select --')]]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option'][contains(., 'Admin')]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option'][contains(., 'ESS')]"))
                )
        );
        //Set element locate
        //Click ESS user role
        driver.findElement(By.xpath("//div[@role='option'][contains(., 'Admin')]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-select-text oxd-select-text--active'][contains(., 'Admin')]"))
        );
        //Set element locate
        //Input employee name
        driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("Paul");
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option'][contains(., 'Paul  Collings')]"))
        );
        //Set element locate
        //Click Employee Name Paul  Collings
        driver.findElement(By.xpath("//div[@class='oxd-autocomplete-option'][contains(., 'Paul  Collings')]")).click();
        //Click status
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option'][text()[contains(., '-- Select --')]]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option'][contains(., 'Enabled')]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option'][contains(., 'Disabled')]"))
                )
        );
        //Set element locate
        //Click enabled status
        driver.findElement(By.xpath("//div[@role='option'][contains(., 'Enabled')]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-select-text oxd-select-text--active'][contains(., 'Enabled')]"))
        );
        //Set element locate
        //Click search button
        driver.findElement(By.xpath("//button[@type='submit'][text()[contains(., ' Search ')]]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='oxd-text oxd-text--span'][text()[contains(., '(1) Record Found')]]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[3]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[4]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[5]"))
                )
        );
        //Quit chrome
        driver.quit();
    }

    @Test //No Records Found
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
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Type for hints...']")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit'][text()[contains(., ' Search ')]]"))
                )
        );
        //Set element locate
        //Input username
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")).sendKeys("not_found_hehe");
        //Click search button
        driver.findElement(By.xpath("//button[@type='submit'][text()[contains(., ' Search ')]]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='oxd-text oxd-text--span'][text()[contains(., 'No Records Found')]]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-toast-content oxd-toast-content--info'][contains(., 'No Records Found')]"))
                )
        );
        //Quit chrome
        driver.quit();

    }@Test //Invalid employee name
    public void failed2(){
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
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Type for hints...']")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit'][text()[contains(., ' Search ')]]"))
                )
        );
        //Set element locate
        //Input employee name
        driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("nothing haha");
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option'][text()[contains(., 'No Records Found')]]"))
        );
        //Click search button
        driver.findElement(By.xpath("//button[@type='submit'][text()[contains(., ' Search ')]]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'][text()[contains(., 'Invalid')]]"))
        );
        //Quit chrome
        driver.quit();
    }
}
