package admin.user_management.users;

import config.env_target;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class EditUser extends env_target {
    @Test //Successfully edit user
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
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-table'][@role='table']")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[6]/div/button[2]"))
                )
        );
        //Set element locate
        //Click edit button
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[6]/div/button[2]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Type for hints...']")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()[contains(., 'Yes')]]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit'][text()[contains(., 'Save')]]"))
                )
        );
        //Set element locate
        //Edit user role
        if (driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div")).getText().contains("Admin")){
            //Click user role
            driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div")).click();
            //Set case stop tunggu
            wait.until(
                    ExpectedConditions.and(
                            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option'][text()[contains(., '-- Select --')]]")),
                            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-select-option'][contains(., 'ESS')]"))
                    )
            );
            //Set element locate
            //Click user role ESS
            driver.findElement(By.xpath("//div[@class='oxd-select-option'][contains(., 'ESS')]")).click();
            //Set case stop tunggu
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-select-text oxd-select-text--active'][contains(., 'ESS')]"))
            );
        }
        else if (driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div")).getText().contains("ESS")){
            //Click user role
            driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div")).click();
            //Set case stop tunggu
            wait.until(
                    ExpectedConditions.and(
                            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option'][text()[contains(., '-- Select --')]]")),
                            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-select-option'][contains(., 'Admin')]"))
                    )
            );
            //Set element locate
            //Click user role Admin
            driver.findElement(By.xpath("//div[@class='oxd-select-option'][contains(., 'Admin')]")).click();
            //Set case stop tunggu
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-select-text oxd-select-text--active'][contains(., 'Admin')]"))
            );
        }
        //Set element locate
        //Edit status
        if (driver.findElement(By.xpath("//div[@class='oxd-select-text oxd-select-text--active'][contains(., 'Enabled')]")).isDisplayed()){
            //Click status
            driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div")).click();
            //Set case stop tunggu
            wait.until(
                    ExpectedConditions.and(
                            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option'][text()[contains(., '-- Select --')]]")),
                            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option'][contains(., 'Disabled')]"))
                    )
            );
            //Set element locate
            //Click disabled status
            driver.findElement(By.xpath("//div[@role='option'][contains(., 'Disabled')]")).click();
            //Set case stop tunggu
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-select-text oxd-select-text--active'][contains(., 'Disabled')]"))
            );
        }
        else if (driver.findElement(By.xpath("//div[@class='oxd-select-text oxd-select-text--active'][contains(., 'Disabled')]")).isDisplayed()){
            //Click status
            driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div")).click();
            //Set case stop tunggu
            wait.until(
                    ExpectedConditions.and(
                            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option'][text()[contains(., '-- Select --')]]")),
                            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option'][contains(., 'Enabled')]"))
                    )
            );
            //Set element locate
            //Click enabled status
            driver.findElement(By.xpath("//div[@role='option'][contains(., 'Enabled')]")).click();
            //Set case stop tunggu
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-select-text oxd-select-text--active'][contains(., 'Enabled')]"))
            );
        }
        //Set element locate
        //Employee Name - Delete old data and fill in new data
        Actions employeeNameActions = new Actions(driver);
        employeeNameActions.click(driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")))
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.SHIFT, "a").build().perform();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-autocomplete-option'][contains(., 'Odis  Adalwin')]"))
        );
        //Set element locate
        //Click Employee Name Odis  Adalwin
        driver.findElement(By.xpath("//div[@class='oxd-autocomplete-option'][contains(., 'Odis  Adalwin')]")).click();
        //Username - delete old data and fill in new data
        Actions usernameActions = new Actions(driver);
        usernameActions.click(driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")))
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE)
                .sendKeys("update_username_tes_1").build().perform();
        //Click change password? Yes
        driver.findElement(By.xpath("//label[text()[contains(., 'Yes')]]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input"))
                )
        );
        //Set element locate
        //Input password
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")).sendKeys("tesUpdatePassword123");
        //Input confirm password
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")).sendKeys("tesUpdatePassword123");
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
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-table'][@role='table']")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[6]/div/button[2]"))
                )
        );
        //Set element locate
        //Click edit button
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[6]/div/button[2]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Type for hints...']")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()[contains(., 'Yes')]]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit'][text()[contains(., 'Save')]]"))
                )
        );
        //Set element locate
        //User Role - blank
        if (driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div")).getText().contains("Admin") ||
                driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div")).getText().contains("ESS")){
            //Click user role
            driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div")).click();
            //Set case stop tunggu
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option'][text()[contains(., '-- Select --')]]"))
            );
            //Set element locate
            //Click user role Select
            driver.findElement(By.xpath("//div[@role='option'][text()[contains(., '-- Select --')]]")).click();
        }
        //Status - blank
        if (driver.findElement(By.xpath("//div[@class='oxd-select-text oxd-select-text--active'][contains(., 'Enabled')]")).isDisplayed() ||
                driver.findElement(By.xpath("//div[@class='oxd-select-text oxd-select-text--active'][contains(., 'Disabled')]")).isDisplayed()){
            //Click status
            driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div")).click();
            //Set case stop tunggu
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option'][text()[contains(., '-- Select --')]]"))
            );
            //Set element locate
            //Click select status
            driver.findElement(By.xpath("//div[@role='option'][text()[contains(., '-- Select --')]]")).click();
        }
        //Employee Name - blank
        Actions blankEmployeeNameActions = new Actions(driver);
        blankEmployeeNameActions.click(driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")))
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE)
                .build().perform();
        //Username - blank
        Actions blankUsernameActions = new Actions(driver);
        blankUsernameActions.click(driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")))
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE)
                .build().perform();
        //Click change password? Yes
        driver.findElement(By.xpath("//label[text()[contains(., 'Yes')]]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input"))
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
