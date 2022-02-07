package utilpackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	static WebDriver driver;
	static String browser;
	static String url;
	
	public static void readConfig() {
		
		//4 ways to read a file: FileReader, InputStream, Buffered, Scanner
		
		//Class for java to understand property file:
		Properties pro = new Properties();
		
		//try{}catch(){}
		try {
			
			//to get input
			InputStream input = new FileInputStream("C:\\Users\\sokoeurn chhay\\Selenium_Java_Review\\Class7_POM\\src\\main\\java\\congfig\\config.properties");	//erros before, I do not copy the right path.
			
			//to load
			pro.load(input);
			
			//to read
			pro.getProperty("browser");	
			
			browser = pro.getProperty("browser");
			
			System.out.println("Browser used: "+ browser);
			url = pro.getProperty("url");
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	public static WebDriver init() {
		//calling readConfig();
		readConfig();
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\sokoeurn chhay\\Selenium_Java_Review\\Class7_POM\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}

	public static void tearDown() {
		driver.close();
		driver.quit();
	}

}
