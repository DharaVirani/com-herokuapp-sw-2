package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public  static WebDriver driver;

    public void openBrowser(String baseUrl){
//  Browser to set up
        driver = new ChromeDriver();
//  Launch the URL
        driver.get(baseUrl);
//  Maximise the window
        driver.manage().window().maximize();
//  Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closeBrowser(){
//   Close browsers
        driver.quit();
    }
}
