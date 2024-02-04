package pim.configuration;

import config.env_target;
import util.FileUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.io.File;

public class DataImport extends env_target {
    @Test
    public void download_the_sample() throws IOException {
        //Set driver location path
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\drivers\\chromedriver.exe");
        //Change Download Directory
        //Setting new download directory path
        Map<String, Object> prefs = new HashMap<String, Object>();
        //Use File.separator as it will work on any OS
        prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "drivers" + File.separator + "BrowserDownloadedFiles");
        //Adding cpabilities to ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        // Launching browser with desired capabilities
        driver = new ChromeDriver(options);
        //Maximize driver
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
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='oxd-main-menu-item'][contains(., 'PIM')]"))
        );
        //Set element locate
        //Click pim menu on the side bar
        driver.findElement(By.xpath("//a[@class='oxd-main-menu-item'][contains(., 'PIM')]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='oxd-topbar-body-nav-tab --parent'][contains(., 'Configuration')]"))
        );
        //Set element locate
        //Click configuration on the nav bar
        driver.findElement(By.xpath("//li[@class='oxd-topbar-body-nav-tab --parent'][contains(., 'Configuration')]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='oxd-topbar-body-nav-tab-link'][contains(., 'Data Import')]"))
        );
        //Set element locate
        //Click the import data menu
        driver.findElement(By.xpath("//*[@class='oxd-topbar-body-nav-tab-link'][contains(., 'Data Import')]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='download-link'][text()[contains(., 'Download')]]"))
        );
        //Set element locate
        //Click download link
        driver.findElement(By.xpath("//a[@class='download-link'][text()[contains(., 'Download')]]")).click();
        //Verify download method
        Assertions.assertTrue(FileUtil.isFileDownloaded("importData", "csv", 5000));
        //Quit chrome
        driver.quit();
    }

    @Test
    public void upload(){
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
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='oxd-main-menu-item'][contains(., 'PIM')]"))
        );
        //Set element locate
        //Click pim menu on the side bar
        driver.findElement(By.xpath("//a[@class='oxd-main-menu-item'][contains(., 'PIM')]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='oxd-topbar-body-nav-tab --parent'][contains(., 'Configuration')]"))
        );
        //Set element locate
        //Click configuration on the nav bar
        driver.findElement(By.xpath("//li[@class='oxd-topbar-body-nav-tab --parent'][contains(., 'Configuration')]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='oxd-topbar-body-nav-tab-link'][contains(., 'Data Import')]"))
        );
        //Set element locate
        //Click the import data menu
        driver.findElement(By.xpath("//*[@class='oxd-topbar-body-nav-tab-link'][contains(., 'Data Import')]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-file-div oxd-file-div--active'][contains(., 'Browse')]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit'][contains(., 'Upload')]"))
                )
        );
        //Set element locate
        //Input file
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/input")).sendKeys("D:\\belajar\\OrangeHRM\\src\\main\\resources\\drivers\\BrowserDownloadedFiles\\importData.csv");
        //Click upload button
        driver.findElement(By.xpath("//button[@type='submit'][contains(., 'Upload')]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--card-title'][text()[contains(., 'Import Details')]]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button'][contains(., 'Ok')]"))
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
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='oxd-main-menu-item'][contains(., 'PIM')]"))
        );
        //Set element locate
        //Click pim menu on the side bar
        driver.findElement(By.xpath("//a[@class='oxd-main-menu-item'][contains(., 'PIM')]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='oxd-topbar-body-nav-tab --parent'][contains(., 'Configuration')]"))
        );
        //Set element locate
        //Click configuration on the nav bar
        driver.findElement(By.xpath("//li[@class='oxd-topbar-body-nav-tab --parent'][contains(., 'Configuration')]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='oxd-topbar-body-nav-tab-link'][contains(., 'Data Import')]"))
        );
        //Set element locate
        //Click the import data menu
        driver.findElement(By.xpath("//*[@class='oxd-topbar-body-nav-tab-link'][contains(., 'Data Import')]")).click();
        //Set case stop tunggu
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-file-div oxd-file-div--active'][contains(., 'Browse')]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit'][contains(., 'Upload')]"))
                )
        );
        //Set element locate
        //Input invalid file
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/input")).sendKeys("C:\\Users\\ACER\\Downloads\\file-1.png");
        //Click upload button
        driver.findElement(By.xpath("//button[@type='submit'][contains(., 'Upload')]")).click();
        //Set case stop tunggu
        //Error messages
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"))
        );
        //Quit chrome
        driver.quit();
    }
}
