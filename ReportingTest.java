import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReportingTest {
    public ExtentReports report;
    public ExtentTest test;


    public void verifyHomePage() {
        report = new ExtentReports("C:\\Users\\Admin\\Desktop\\AutomationReports\\BasicReport.html", true);
        test = report.startTest("Verify application Title");

        System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Browser started");
        driver.get("https://http://thedemosite.co.uk/index.php");
        String title = driver.getTitle();

        if (title.equals("PHP | SQL")) {
            test.log(LogStatus.PASS, "verify Title of the page");
        } else {
            test.log(LogStatus.FAIL, "verify Title of the page");
        }
        report.endTest(test);
        report.flush();

        driver.quit();


    }
}