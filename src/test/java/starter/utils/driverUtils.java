package starter.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class driverUtils {
    public static WebDriver driver;

    public static WebDriver getDriver() {

        if(driver == null) {
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
            options.setExperimentalOption("prefs", prefs);
            options.addArguments("start-maximized");
            options.addArguments("disable-infobars");
            options.addArguments("--disable-gpu");
            options.addArguments("disable-features=NetworkService");
            options.addArguments("--no-sandbox");
            options.addArguments("enable-features=NetworkServiceInProcess");
            System.setProperty("webdriver.chrome.silentOutput", "true");

            Map<String, String> mobileEmulation = new HashMap<>();
            mobileEmulation.put("deviceName", "iPhone 7");
            options.setExperimentalOption("mobileEmulation", mobileEmulation);

            driver = new ChromeDriver(options);

        }
        return (WebDriver) driver;
    }

    public static String read_userName_from_html_files() throws InterruptedException {
        getDriver();

        driver.get("file:///Users//Yogita//Documents//Oldies//IMP-BKP-Webstorefront-TestAutomation//All My Automations//YogitaAssignment//src//test//resources//inputFiles//HTML_sample.html");
        Thread.sleep(2000);
        driver.getTitle();
        driver.switchTo().frame("frm1");
        Thread.sleep(2000);
        driver.switchTo().frame("frm2");
        Thread.sleep(2000);
        String nameFromHtml = driver.findElement(By.xpath("//label[@id='usrName']")).getText();
        System.out.println("nameFromHtml: "+nameFromHtml);
        return nameFromHtml;
    }

    public static void fill_actual_due_date_fill_the_due_date_in_form(String actualDueDate) {
        driver.findElement(By.xpath("//input[@id='expiryData']")).click();
        driver.findElement(By.xpath("//input[@id='expiryData']")).clear();
        driver.findElement(By.xpath("//input[@id='expiryData']")).sendKeys(actualDueDate);

        System.out.println("Done !!! ");
    }
}
