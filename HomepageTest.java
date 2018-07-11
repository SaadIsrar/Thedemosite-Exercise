import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class HomepageTest {
    private WebDriver driver;
    private AddUser user;
    private LoginPage login;
    private Homepage home;

    public ExtentReports report = new ExtentReports("C:\\Users\\Saad\\Desktop\\BasicReport.html", true);
    public ExtentTest test;


    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Ignore
    @Test
    public void testHomepage1(){
        driver.get("https://www.thedemosite.co.uk");
        home = PageFactory.initElements(driver, Homepage.class);
        home.clicklogin();
        report.endTest(test);
        report.flush();
    }



    @Test
    public void testAddUser(){
        driver.get("https://www.thedemosite.co.uk");
        home = PageFactory.initElements(driver, Homepage.class);
        home.clickAddUser();
        user = PageFactory.initElements(driver, AddUser.class);
        user.enterdetails();

    }


    @Test
    public void testLoginPage(){
        testAddUser();
        test = report.startTest("DemoSite Test Report1");
        driver.get("https://www.thedemosite.co.uk");
        test.log(LogStatus.INFO, "gone to the demosite");
        home = PageFactory.initElements(driver, Homepage.class);
        home.clicklogin();
        test.log(LogStatus.INFO, "navigate to login page");
        login = PageFactory.initElements(driver, LoginPage.class);
        login.enterdetails();

        if (login.getLoginMessage().contains("Successful Login")){
            test.log(LogStatus.PASS, "login sucessful");
        }
        else {
            test.log(LogStatus.FAIL, "login failed");
        }
        report.endTest(test);
        report.flush();
        assertEquals(true, login.getLoginMessage().contains("Successful Login"));


    }


    @Ignore
    @Test
    public void testHomepage(){
        driver.get("https://www.thedemosite.co.uk");
        driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")).click();
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")).sendKeys("saad");
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")).sendKeys("saad");
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")).click();
        driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")).click();
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")).sendKeys("saad");
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")).sendKeys("saad");
        driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")).click();
        report.endTest(test);
        report.flush();
    }

    @After
    public void teardown() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();
    }



}


